package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$37
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$37(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AssistantSettingActivity.a(this.a, this.a.g.a(), paramBoolean);
    AssistantSettingActivity.a(this.a).a(paramBoolean, true);
    if (paramBoolean) {
      ReportController.b(this.a.app, "dc00898", "", "", "0X8009C0C", "0X8009C0C", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      ReportController.b(this.a.app, "dc00898", "", "", "0X8009C0D", "0X8009C0D", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.37
 * JD-Core Version:    0.7.0.1
 */