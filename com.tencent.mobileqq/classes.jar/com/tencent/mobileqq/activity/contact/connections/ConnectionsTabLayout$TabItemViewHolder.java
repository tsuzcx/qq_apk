package com.tencent.mobileqq.activity.contact.connections;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ConnectionsTabLayout$TabItemViewHolder
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TriangleView jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ConnectionsTabLayout$TabItemViewHolder(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371840));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371837));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371841));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371839));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView = ((TriangleView)paramView.findViewById(2131379123));
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setSelected(true);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setSelected(true);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setSelected(true);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setSelected(true);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView;
    if (localObject != null) {
      ((TriangleView)localObject).setVisibility(0);
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setSelected(false);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setSelected(false);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setSelected(false);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setSelected(false);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView;
    if (localObject != null) {
      ((TriangleView)localObject).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsTabLayout.TabItemViewHolder
 * JD-Core Version:    0.7.0.1
 */