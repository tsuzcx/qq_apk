package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$21
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$21(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    RichTextChatManager.a(this.a.app).a(paramBoolean, this.a.app);
    if (paramBoolean) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8008C75", "0X8008C75", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      ReportController.b(this.a.app, "CliOper", "", "", "0X8008C74", "0X8008C74", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.21
 * JD-Core Version:    0.7.0.1
 */