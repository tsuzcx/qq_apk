package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.mobileqq.onlinestatus.constants.CommonConstants;
import com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.IAutoStatusManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class AutoStatusBannerProcessor$1
  implements View.OnClickListener
{
  AutoStatusBannerProcessor$1(AutoStatusBannerProcessor paramAutoStatusBannerProcessor, AutoStatusItem paramAutoStatusItem) {}
  
  public void onClick(View paramView)
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if (((IOnlineStatusService)((AppRuntime)localObject).getRuntimeService(IOnlineStatusService.class, "")).getExtOnlineStatus() > 40001L)
    {
      AutoStatusManager.a((AppInterface)localObject, 40001L, false, "br_close");
    }
    else
    {
      BannerManager.a().a(CommonConstants.a, 0, null);
      localObject = (AutoStatusManager)((IOnlineStatusManagerService)((AppRuntime)localObject).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IAutoStatusManager.class);
      if (localObject != null) {
        ((AutoStatusManager)localObject).d();
      }
    }
    ReportHelperKt.a("0X800AF9F", (int)this.a.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.AutoStatusBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */