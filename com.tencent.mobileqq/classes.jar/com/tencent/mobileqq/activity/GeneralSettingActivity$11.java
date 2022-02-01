package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GeneralSettingActivity$11
  implements View.OnClickListener
{
  GeneralSettingActivity$11(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    PublicFragmentActivity.a(this.a.getActivity(), QQSettingAutoDownloadAndSaveFragment.class);
    if (SettingsConfigHelper.a(this.a.app)) {
      ReportController.a(this.a.app, "0X800B872");
    } else {
      ReportController.b(null, "CliOper", "", "", "0X800A2DB", "0X800A2DB", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.11
 * JD-Core Version:    0.7.0.1
 */