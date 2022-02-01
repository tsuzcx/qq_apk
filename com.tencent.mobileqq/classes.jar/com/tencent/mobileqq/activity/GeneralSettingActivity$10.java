package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.settings.message.ReportClickEventHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GeneralSettingActivity$10
  implements CompoundButton.OnCheckedChangeListener
{
  GeneralSettingActivity$10(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (SettingsConfigHelper.a(this.a.app))
    {
      ReportClickEventHelper.a(this.a.app, "0X800B873", paramBoolean);
      SettingCloneUtil.writeValue(this.a, null, this.a.getString(2131719122), "qqsetting_notify_icon_key", paramBoolean);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "System_icon", 0, i, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.10
 * JD-Core Version:    0.7.0.1
 */