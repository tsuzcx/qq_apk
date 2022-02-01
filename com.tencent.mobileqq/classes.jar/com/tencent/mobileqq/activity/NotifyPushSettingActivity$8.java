package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUnRead;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyPushSettingActivity$8
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingActivity$8(NotifyPushSettingActivity paramNotifyPushSettingActivity, BubbleManager paramBubbleManager) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a.a(paramBoolean);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.app.getCurrentAccountUin();
    String str1;
    if (paramBoolean) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    VasWebviewUtil.a(str2, "bubble_new", "change", "0", 0, 0, 0, "", "", str1, "", "", "", "", 0, 0, 0, 0);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.8
 * JD-Core Version:    0.7.0.1
 */