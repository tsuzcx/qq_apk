package com.tencent.gdtad.aditem;

import acoo;
import acop;
import acvc;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;

public class GdtPreLoader$1
  implements Runnable
{
  public GdtPreLoader$1(acoo paramacoo, GdtAd paramGdtAd) {}
  
  public void run()
  {
    if ((this.a == null) || (!this.a.isValid())) {
      acvc.d("GdtPreLoader", "preLoadAfterAdLoaded error");
    }
    do
    {
      do
      {
        return;
        acvc.b("GdtPreLoader", "preLoadAfterAdLoaded");
      } while (!this.a.isQQMINIProgram());
      acvc.b("GdtPreLoader", String.format("canPreloadForQQMINIProgram %b", new Object[] { Boolean.valueOf(this.a.canPreloadForQQMINIProgram()) }));
    } while ((!this.a.canPreloadForQQMINIProgram()) || (TextUtils.isEmpty(this.a.getUrlForLandingPage())));
    acvc.b("GdtPreLoader", "MiniAppPrePullManager.getInstance().prePullAppinfoByLink start");
    MiniAppPrePullManager.getInstance().prePullAppinfoByLink(this.a.getUrlForLandingPage(), false, new acop(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.1
 * JD-Core Version:    0.7.0.1
 */