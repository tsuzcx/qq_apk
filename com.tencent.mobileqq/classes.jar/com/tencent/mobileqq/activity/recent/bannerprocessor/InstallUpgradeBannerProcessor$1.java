package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeConstants;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class InstallUpgradeBannerProcessor$1
  implements View.OnClickListener
{
  InstallUpgradeBannerProcessor$1(InstallUpgradeBannerProcessor paramInstallUpgradeBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    InstallUpgradeBannerProcessor.a(this.a).getAppRuntime().getPreferences();
    UpgradeController.a().a();
    if (UpgradeController.a().a() == 4)
    {
      UpgradeController.a().a(InstallUpgradeBannerProcessor.b(this.a));
      ReportController.b(InstallUpgradeBannerProcessor.c(this.a).getAppRuntime(), "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, UpgradeConstants.b(), UpgradeController.b(), UpgradeController.a(), "1");
    }
    for (;;)
    {
      BannerManager.a().a(-1, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      UpgradeDetailActivity.a(InstallUpgradeBannerProcessor.d(this.a), UpgradeController.a().a(), true, true, true);
      ReportController.b(InstallUpgradeBannerProcessor.e(this.a).getAppRuntime(), "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, UpgradeConstants.b(), UpgradeController.b(), UpgradeController.a(), "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.InstallUpgradeBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */