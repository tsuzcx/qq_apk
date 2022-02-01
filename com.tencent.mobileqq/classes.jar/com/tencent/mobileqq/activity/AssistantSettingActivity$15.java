package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$15
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$15(AssistantSettingActivity paramAssistantSettingActivity, TroopManager paramTroopManager) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.15
 * JD-Core Version:    0.7.0.1
 */