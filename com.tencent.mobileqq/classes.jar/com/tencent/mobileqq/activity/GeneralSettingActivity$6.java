package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GeneralSettingActivity$6
  implements View.OnClickListener
{
  GeneralSettingActivity$6(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, FontSettingActivity.class);
    this.a.startActivity(localIntent);
    if (SettingsConfigHelper.a(this.a.app)) {
      ReportController.a(this.a.app, "0X800B86F");
    } else {
      ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "0X8004FA2", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.6
 * JD-Core Version:    0.7.0.1
 */