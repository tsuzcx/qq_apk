package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class AutoStatusBannerProcessor$1
  implements View.OnClickListener
{
  AutoStatusBannerProcessor$1(AutoStatusBannerProcessor paramAutoStatusBannerProcessor, AutoStatusItem paramAutoStatusItem) {}
  
  public void onClick(View paramView)
  {
    if (AutoStatusBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorAutoStatusBannerProcessor).getAppRuntime().getExtOnlineStatus() > 40001L) {
      AutoStatusManager.a((QQAppInterface)AutoStatusBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorAutoStatusBannerProcessor).getAppRuntime(), 40001L, false, "br_close");
    }
    for (;;)
    {
      ReportHelperKt.a("0X800AF9F", (int)this.jdField_a_of_type_ComTencentMobileqqOnlinestatusConfigAutoStatusItem.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      BannerManager.a().a(30, 0, null);
      AutoStatusManager.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.AutoStatusBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */