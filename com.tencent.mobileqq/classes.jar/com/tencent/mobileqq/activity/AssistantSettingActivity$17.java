package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.multiaio.MultiAIOHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$17
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$17(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    MultiAIOHelper.a(paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.17
 * JD-Core Version:    0.7.0.1
 */