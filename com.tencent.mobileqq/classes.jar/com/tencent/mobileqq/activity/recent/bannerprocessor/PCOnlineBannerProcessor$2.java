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
    if ((PCOnlineBannerProcessor.a(this.a) != null) && ("1600000104".equals(PCOnlineBannerProcessor.a(this.a).trim())))
    {
      if (PCOnlineBannerProcessor.a(this.a) == 77313L) {
        PCOnlineBannerProcessor.a(this.a, true);
      }
      this.a.b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(PCOnlineBannerProcessor.a(this.a), QRLoginMgrActivity.class);
      localIntent.putExtra("loginInfo", PCOnlineBannerProcessor.b(this.a));
      localIntent.putExtra("appType", PCOnlineBannerProcessor.a(this.a));
      localIntent.putExtra("subappid", this.a.a);
      localIntent.putExtra("clientType", PCOnlineBannerProcessor.a(this.a));
      PCOnlineBannerProcessor.b(this.a).startActivity(localIntent);
      ReportController.a(PCOnlineBannerProcessor.c(this.a).getAppRuntime(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 10, 0, "", "", "", "");
      if (PCOnlineBannerProcessor.a(this.a) == 77313L) {
        ReportController.b(PCOnlineBannerProcessor.d(this.a).getAppRuntime(), "dc00898", "", "", "0X8008880", "0X8008880", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.PCOnlineBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */