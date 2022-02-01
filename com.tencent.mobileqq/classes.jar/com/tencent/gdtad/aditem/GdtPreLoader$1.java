package com.tencent.gdtad.aditem;

import acam;
import acan;
import acho;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;

public class GdtPreLoader$1
  implements Runnable
{
  public GdtPreLoader$1(acam paramacam, GdtAd paramGdtAd) {}
  
  public void run()
  {
    if ((this.a == null) || (!this.a.isValid())) {
      acho.d("GdtPreLoader", "preLoadAfterAdLoaded error");
    }
    do
    {
      do
      {
        return;
        acho.b("GdtPreLoader", "preLoadAfterAdLoaded");
      } while (!this.a.isQQMINIProgram());
      acho.b("GdtPreLoader", String.format("canPreloadForQQMINIProgram %b", new Object[] { Boolean.valueOf(this.a.canPreloadForQQMINIProgram()) }));
    } while ((!this.a.canPreloadForQQMINIProgram()) || (TextUtils.isEmpty(this.a.getUrlForLandingPage())));
    acho.b("GdtPreLoader", "MiniAppPrePullManager.getInstance().prePullAppinfoByLink start");
    MiniAppPrePullManager.getInstance().prePullAppinfoByLink(this.a.getUrlForLandingPage(), false, new acan(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.1
 * JD-Core Version:    0.7.0.1
 */