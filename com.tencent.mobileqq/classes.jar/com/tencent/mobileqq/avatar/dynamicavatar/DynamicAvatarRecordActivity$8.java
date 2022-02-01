package com.tencent.mobileqq.avatar.dynamicavatar;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.widget.CircleProgress;

class DynamicAvatarRecordActivity$8
  implements Runnable
{
  DynamicAvatarRecordActivity$8(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.this$0.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.this$0.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.this$0.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText("0\"");
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    if (this.this$0.jdField_d_of_type_Boolean) {
      this.this$0.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    } else {
      this.this$0.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    this.this$0.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.this$0.c.setVisibility(0);
    this.this$0.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.this$0.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    this.this$0.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(4);
    this.this$0.e.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.8
 * JD-Core Version:    0.7.0.1
 */