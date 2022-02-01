package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQWifiBannerProcessor$2
  implements View.OnClickListener
{
  QQWifiBannerProcessor$2(QQWifiBannerProcessor paramQQWifiBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    BannerManager.a().a(QQWifiBannerProcessor.a, 0, null);
    ReportController.b(QQWifiBannerProcessor.a(this.a).getAppRuntime(), "CliOper", "", "", "QQWIFI", "clk_buleClose", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.QQWifiBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */