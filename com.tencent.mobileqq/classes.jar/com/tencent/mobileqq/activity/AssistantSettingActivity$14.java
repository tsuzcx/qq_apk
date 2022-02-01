package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$14
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$14(AssistantSettingActivity paramAssistantSettingActivity, FriendsManager paramFriendsManager) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.14
 * JD-Core Version:    0.7.0.1
 */