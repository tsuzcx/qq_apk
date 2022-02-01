package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeConstants;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class InstallUpgradeBannerProcessor$2
  implements View.OnClickListener
{
  InstallUpgradeBannerProcessor$2(InstallUpgradeBannerProcessor paramInstallUpgradeBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    if (UpgradeController.a().a() == 4) {
      ReportController.b(InstallUpgradeBannerProcessor.f(this.a).getAppRuntime(), "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, UpgradeConstants.b(), UpgradeController.b(), UpgradeController.a(), "0");
    } else {
      ReportController.b(InstallUpgradeBannerProcessor.g(this.a).getAppRuntime(), "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, UpgradeConstants.b(), UpgradeController.b(), UpgradeController.a(), "0");
    }
    BannerManager.a().a(InstallUpgradeBannerProcessor.a, 0, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.InstallUpgradeBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */