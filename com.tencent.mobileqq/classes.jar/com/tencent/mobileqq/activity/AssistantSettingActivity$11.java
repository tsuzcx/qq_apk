package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$11
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$11(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingActivity.a(this.a, this.a.g.a(), paramBoolean);
    AssistantSettingActivity.a(this.a).a(paramBoolean, true);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.11
 * JD-Core Version:    0.7.0.1
 */