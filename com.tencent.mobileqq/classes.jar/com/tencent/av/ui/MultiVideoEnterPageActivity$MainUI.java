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
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(paramInt);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(paramInt);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(paramInt);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(paramInt);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetButton;
    if (localObject != null) {
      ((Button)localObject).setVisibility(paramInt);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetButton;
    if ((localObject != null) && (paramInt != 0)) {
      ((Button)localObject).setVisibility(paramInt);
    }
  }
  
  void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramActivity.findViewById(2131373542));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramActivity.findViewById(2131373376));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramActivity.findViewById(2131373375));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramActivity.findViewById(2131373406));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramActivity.findViewById(2131373399));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramActivity.findViewById(2131373404));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.MainUI
 * JD-Core Version:    0.7.0.1
 */