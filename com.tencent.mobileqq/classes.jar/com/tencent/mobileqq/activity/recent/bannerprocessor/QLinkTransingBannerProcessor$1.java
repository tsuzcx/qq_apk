package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qlink.QQProxyForQlink;

class QLinkTransingBannerProcessor$1
  implements View.OnClickListener
{
  QLinkTransingBannerProcessor$1(QLinkTransingBannerProcessor paramQLinkTransingBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    ((QQAppInterface)QLinkTransingBannerProcessor.a(this.a).getAppRuntime()).getQQProxyForQlink().a("0X800474F", 1);
    QQProxyForQlink.a(QLinkTransingBannerProcessor.b(this.a), 4, null);
    ReportController.a(QLinkTransingBannerProcessor.c(this.a).getAppRuntime(), "dc00898", "", "", "0X8009EE5", "0X8009EE5", 3, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.QLinkTransingBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */