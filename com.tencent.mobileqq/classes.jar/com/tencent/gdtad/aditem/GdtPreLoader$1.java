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
    if ((this.a == null) || (!this.a.isValid())) {
      GdtLog.d("GdtPreLoader", "preLoadAfterAdLoaded error");
    }
    do
    {
      do
      {
        return;
        GdtLog.b("GdtPreLoader", "preLoadAfterAdLoaded");
      } while (!this.a.isQQMINIProgram());
      GdtLog.b("GdtPreLoader", String.format("canPreloadForQQMINIProgram %b", new Object[] { Boolean.valueOf(this.a.canPreloadForQQMINIProgram()) }));
    } while ((!this.a.canPreloadForQQMINIProgram()) || (TextUtils.isEmpty(this.a.getUrlForLandingPage())));
    GdtLog.b("GdtPreLoader", "MiniAppPrePullManager.getInstance().prePullAppinfoByLink start");
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).prePullAppinfoByLink(this.a.getUrlForLandingPage(), false, new GdtPreLoader.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.1
 * JD-Core Version:    0.7.0.1
 */