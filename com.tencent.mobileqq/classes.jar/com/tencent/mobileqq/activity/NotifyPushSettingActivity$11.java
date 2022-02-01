package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyPushSettingActivity$11
  implements CompoundButton.OnCheckedChangeListener
{
  NotifyPushSettingActivity$11(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (NotifyPushSettingActivity.a())
    {
      NotifyPushSettingActivity.b(this.a).setChecked(false);
      NotifyPushSettingActivity.b(this.a).setVisibility(8);
      if (!paramBoolean) {
        break label121;
      }
    }
    label121:
    for (int i = 1;; i = 0)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_hide_text", 0, i, String.valueOf(i), "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramBoolean)
      {
        NotifyPushSettingActivity.b(this.a).setVisibility(0);
        NotifyPushSettingActivity.b(this.a).setVisibility(8);
        break;
      }
      NotifyPushSettingActivity.b(this.a).setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity.11
 * JD-Core Version:    0.7.0.1
 */