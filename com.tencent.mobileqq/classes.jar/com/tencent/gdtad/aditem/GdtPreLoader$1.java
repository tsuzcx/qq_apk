package com.tencent.gdtad.aditem;

import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;

class GdtPreLoader$1
  implements Runnable
{
  GdtPreLoader$1(GdtPreLoader paramGdtPreLoader, GdtAd paramGdtAd) {}
  
  public void run()
  {
    GdtAd localGdtAd = this.a;
    if ((localGdtAd != null) && (localGdtAd.isValid()))
    {
      GdtLog.b("GdtPreLoader", "preLoadAfterAdLoaded");
      if (!this.a.isQQMINIProgram()) {
        return;
      }
      GdtLog.b("GdtPreLoader", String.format("canPreloadForQQMINIProgram %b", new Object[] { Boolean.valueOf(this.a.canPreloadForQQMINIProgram()) }));
      if (!this.a.canPreloadForQQMINIProgram()) {
        return;
      }
      if (TextUtils.isEmpty(this.a.getUrlForLandingPage())) {
        return;
      }
      GdtLog.b("GdtPreLoader", "MiniAppPrePullManager.getInstance().prePullAppinfoByLink start");
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).prePullAppinfoByLink(this.a.getUrlForLandingPage(), false, new GdtPreLoader.1.1(this));
      return;
    }
    GdtLog.d("GdtPreLoader", "preLoadAfterAdLoaded error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.1
 * JD-Core Version:    0.7.0.1
 */