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

class UpgradeBannerProcessor$1
  implements View.OnClickListener
{
  UpgradeBannerProcessor$1(UpgradeBannerProcessor paramUpgradeBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    BannerManager.a().a(-1, null);
    if (UpgradeController.a().a() == 4)
    {
      ReportController.b(UpgradeBannerProcessor.a(this.a).getAppRuntime(), "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, UpgradeConstants.b(), UpgradeController.b(), UpgradeController.a(), "1");
      UpgradeController.a().a(UpgradeBannerProcessor.b(this.a));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReportController.b(UpgradeBannerProcessor.c(this.a).getAppRuntime(), "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, UpgradeConstants.b(), UpgradeController.b(), UpgradeController.a(), "1");
      UpgradeDetailActivity.a(UpgradeBannerProcessor.d(this.a), UpgradeController.a().a(), true, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.UpgradeBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */