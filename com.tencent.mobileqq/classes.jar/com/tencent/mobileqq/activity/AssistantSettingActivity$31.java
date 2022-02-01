package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$31
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$31(AssistantSettingActivity paramAssistantSettingActivity, SpringFestivalEntryManager paramSpringFestivalEntryManager) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalEntryManager.a(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.31
 * JD-Core Version:    0.7.0.1
 */