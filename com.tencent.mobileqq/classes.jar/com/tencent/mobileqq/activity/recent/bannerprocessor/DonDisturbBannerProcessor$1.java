package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.settings.message.NotifyPushSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DonDisturbBannerProcessor$1
  implements View.OnClickListener
{
  DonDisturbBannerProcessor$1(DonDisturbBannerProcessor paramDonDisturbBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if (SettingsConfigHelper.a((AppInterface)DonDisturbBannerProcessor.a(this.a).getAppRuntime()))
    {
      localIntent = new Intent();
      PublicFragmentActivity.a(DonDisturbBannerProcessor.b(this.a), localIntent, NotifyPushSettingFragment.class);
    }
    else
    {
      localIntent = new Intent(DonDisturbBannerProcessor.c(this.a), NotifyPushSettingActivity.class);
      DonDisturbBannerProcessor.d(this.a).startActivity(localIntent);
    }
    ReportController.b(DonDisturbBannerProcessor.e(this.a).getAppRuntime(), "CliOper", "", "", "0X8009EBB", "0X8009EBB", 0, 1, "", "", "", "");
    ReportController.a(DonDisturbBannerProcessor.f(this.a).getAppRuntime(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 2, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.DonDisturbBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */