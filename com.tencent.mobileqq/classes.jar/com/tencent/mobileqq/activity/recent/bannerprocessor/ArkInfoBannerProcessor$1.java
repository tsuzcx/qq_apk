package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class ArkInfoBannerProcessor$1
  implements View.OnClickListener
{
  ArkInfoBannerProcessor$1(ArkInfoBannerProcessor paramArkInfoBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    AppRuntime localAppRuntime;
    if (ArkInfoBannerProcessor.a(this.a) != null) {
      localAppRuntime = ArkInfoBannerProcessor.b(this.a).getAppRuntime();
    } else {
      localAppRuntime = null;
    }
    if ((localAppRuntime instanceof QQAppInterface)) {
      ArkTipsManager.a().a(ArkInfoBannerProcessor.c(this.a), (QQAppInterface)localAppRuntime);
    }
    ArkTipsManager.a().a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ArkInfoBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */