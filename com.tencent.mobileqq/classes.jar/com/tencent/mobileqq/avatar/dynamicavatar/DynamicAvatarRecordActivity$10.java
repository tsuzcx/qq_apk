package com.tencent.mobileqq.avatar.dynamicavatar;

import android.widget.TextView;
import com.tencent.mobileqq.widget.CircleProgress;

class DynamicAvatarRecordActivity$10
  implements Runnable
{
  DynamicAvatarRecordActivity$10(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity, int paramInt) {}
  
  public void run()
  {
    int i = this.a / 1000;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("\"");
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder);
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(this.a / 80);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.10
 * JD-Core Version:    0.7.0.1
 */