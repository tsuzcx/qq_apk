package com.tencent.av.ui;

import android.app.Activity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

class MultiVideoEnterPageActivity$MainUI
{
  Button jdField_a_of_type_AndroidWidgetButton = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  Button jdField_b_of_type_AndroidWidgetButton = null;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_b_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(paramInt);
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(paramInt);
    }
    if ((this.jdField_b_of_type_AndroidWidgetButton != null) && (paramInt != 0)) {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(paramInt);
    }
  }
  
  void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramActivity.findViewById(2131373970));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramActivity.findViewById(2131373804));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramActivity.findViewById(2131373803));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramActivity.findViewById(2131373834));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramActivity.findViewById(2131373827));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramActivity.findViewById(2131373832));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.MainUI
 * JD-Core Version:    0.7.0.1
 */