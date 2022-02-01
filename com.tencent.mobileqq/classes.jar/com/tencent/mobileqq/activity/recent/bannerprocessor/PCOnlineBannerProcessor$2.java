package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PCOnlineBannerProcessor$2
  implements View.OnClickListener
{
  PCOnlineBannerProcessor$2(PCOnlineBannerProcessor paramPCOnlineBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    if ((PCOnlineBannerProcessor.b(this.a) != null) && ("1600000104".equals(PCOnlineBannerProcessor.b(this.a).trim())))
    {
      if (PCOnlineBannerProcessor.a(this.a) == 77313L) {
        PCOnlineBannerProcessor.a(this.a, true);
      }
      this.a.d();
    }
    else
    {
      Intent localIntent = new Intent(PCOnlineBannerProcessor.c(this.a), QRLoginMgrActivity.class);
      localIntent.putExtra("loginInfo", PCOnlineBannerProcessor.d(this.a));
      localIntent.putExtra("appType", PCOnlineBannerProcessor.e(this.a));
      localIntent.putExtra("subappid", this.a.b);
      localIntent.putExtra("clientType", PCOnlineBannerProcessor.a(this.a));
      PCOnlineBannerProcessor.f(this.a).startActivity(localIntent);
      ReportController.a(PCOnlineBannerProcessor.g(this.a).getAppRuntime(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 10, 0, "", "", "", "");
      if (PCOnlineBannerProcessor.a(this.a) == 77313L) {
        ReportController.b(PCOnlineBannerProcessor.h(this.a).getAppRuntime(), "dc00898", "", "", "0X8008880", "0X8008880", 0, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.PCOnlineBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */