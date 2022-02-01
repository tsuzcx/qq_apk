package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AutoStatusBannerProcessor$2
  implements View.OnClickListener
{
  AutoStatusBannerProcessor$2(AutoStatusBannerProcessor paramAutoStatusBannerProcessor, AutoStatusItem paramAutoStatusItem) {}
  
  public void onClick(View paramView)
  {
    AutoStatusManager.a((AppInterface)AutoStatusBannerProcessor.a(this.b).getAppRuntime(), this.a.b, false, "br_switch");
    ReportHelperKt.a("0X800AFA0", (int)this.a.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.AutoStatusBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */