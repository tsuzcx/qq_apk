package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeConstants;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UpgradeBannerProcessor$2
  implements View.OnClickListener
{
  UpgradeBannerProcessor$2(UpgradeBannerProcessor paramUpgradeBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    if (UpgradeController.a().a() == 4) {
      ReportController.b(UpgradeBannerProcessor.e(this.a).getAppRuntime(), "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, UpgradeConstants.b(), UpgradeController.b(), UpgradeController.a(), "0");
    }
    for (;;)
    {
      BannerManager.a().a(15, 0, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReportController.b(UpgradeBannerProcessor.f(this.a).getAppRuntime(), "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, UpgradeConstants.b(), UpgradeController.b(), UpgradeController.a(), "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.UpgradeBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */