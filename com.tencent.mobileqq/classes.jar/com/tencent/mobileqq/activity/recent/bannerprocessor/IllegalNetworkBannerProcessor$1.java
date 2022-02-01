package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

class IllegalNetworkBannerProcessor$1
  implements View.OnClickListener
{
  IllegalNetworkBannerProcessor$1(IllegalNetworkBannerProcessor paramIllegalNetworkBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    if (VersionUtils.e()) {
      IllegalNetworkBannerProcessor.a(this.a).startActivity(new Intent("android.settings.SETTINGS"));
    } else {
      IllegalNetworkBannerProcessor.b(this.a).startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }
    ReportController.a(IllegalNetworkBannerProcessor.c(this.a).getAppRuntime(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.IllegalNetworkBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */