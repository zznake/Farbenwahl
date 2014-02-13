package de.i3a;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Fenster extends JFrame {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Container c;
	private JPanel jpnorth,jpwest,jpcenter,jpsouth;
	private JButton jbtnrot, jbtnblau, jbtngelb;
	private JRadioButton jrbtnrot, jrbtnblau, jrbtngelb;
	private JComboBox<String> jcombobox;
	private ButtonGroup bg;
	
	public Fenster() {
		this.setTitle("Farbwahl");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		initComponents();
		initEvents();
		
		this.setVisible(true);
	}

	private void initComponents() {
		c=this.getContentPane();
		
		jpnorth = new JPanel();
		jpwest = new JPanel();
		jpcenter = new JPanel();
		jpsouth = new JPanel();
		
		jbtnrot = new JButton("Rot");
		jbtnblau = new JButton("Blau");
		jbtngelb = new JButton("Gelb");
		
		jrbtnblau = new JRadioButton("Blau");
		jrbtngelb = new JRadioButton("Gelb");
		jrbtnrot = new JRadioButton("Rot");
		jrbtnrot.setSelected(true);
		jpcenter.setBackground(Color.RED);
		
		jcombobox = new JComboBox<>();
		jcombobox.addItem("Rot");
		jcombobox.addItem("Blau");
		jcombobox.addItem("Gelb");
		
		bg = new ButtonGroup();
		bg.add(jrbtnblau);
		bg.add(jrbtngelb);
		bg.add(jrbtnrot);
		
		jpnorth.add(jcombobox);
		
		jpwest.add(jrbtnrot);
		jpwest.add(jrbtngelb);
		jpwest.add(jrbtnblau);
		jpwest.setLayout(new BoxLayout(jpwest, BoxLayout.Y_AXIS));
		
		jpsouth.add(jbtnrot);
		jpsouth.add(jbtngelb);
		jpsouth.add(jbtnblau);
		
		c.add(jpnorth,BorderLayout.NORTH);
		c.add(jpwest,BorderLayout.WEST);
		c.add(jpcenter,BorderLayout.CENTER);
		c.add(jpsouth,BorderLayout.SOUTH);
		
	}
	
	public void initEvents() {
		
		MeinActionListener mal = new MeinActionListener();
		
		jbtnrot.addActionListener(mal);
		jbtnblau.addActionListener(mal);
		jbtngelb.addActionListener(mal);
		jrbtnblau.addActionListener(mal);
		jrbtngelb.addActionListener(mal);
		jrbtnrot.addActionListener(mal);
		jcombobox.addActionListener(mal);
	}
	
	private class MeinActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			
			String ActionCommand = e.getActionCommand();
			
			if(ActionCommand=="comboBoxChanged") {
				ActionCommand=(String)jcombobox.getSelectedItem();
			}
			
			switch(ActionCommand ) {
				case "Rot":
					jpcenter.setBackground(Color.RED);
					jrbtnrot.setSelected(true);
					jcombobox.setSelectedIndex(0);
					break;
				case "Blau":
					jpcenter.setBackground(Color.BLUE);
					jrbtnblau.setSelected(true);
					jcombobox.setSelectedIndex(1);
					break;
				case "Gelb":
					jpcenter.setBackground(Color.YELLOW);
					jrbtngelb.setSelected(true);
					jcombobox.setSelectedIndex(2);
					break;
			}
		}		
	}
}
