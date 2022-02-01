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

class UpdateBannerProcessor$1
  implements View.OnClickListener
{
  UpdateBannerProcessor$1(UpdateBannerProcessor paramUpdateBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    BannerManager.a().a(-1, null);
    if (UpgradeController.a().b() == 4)
    {
      ReportController.b(UpdateBannerProcessor.a(this.a).getAppRuntime(), "CliOper", "", "", "0X8004DA4", "0X8004DA4", 0, 0, UpgradeConstants.b(), UpgradeController.l(), UpgradeController.k(), "1");
      UpgradeController.a().a(UpdateBannerProcessor.b(this.a));
    }
    else
    {
      ReportController.b(UpdateBannerProcessor.c(this.a).getAppRuntime(), "CliOper", "", "", "0X8004DA3", "0X8004DA3", 0, 0, UpgradeConstants.b(), UpgradeController.l(), UpgradeController.k(), "1");
      UpgradeDetailActivity.a(UpdateBannerProcessor.d(this.a), UpgradeController.a().d(), true, true, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.UpdateBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */