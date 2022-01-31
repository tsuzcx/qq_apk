package com.tencent.gdtad.aditem;

import aail;
import aaim;
import aanp;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;

public class GdtPreLoader$1
  implements Runnable
{
  public GdtPreLoader$1(aail paramaail, GdtAd paramGdtAd) {}
  
  public void run()
  {
    if ((this.a == null) || (!this.a.isValid())) {
      aanp.d("GdtPreLoader", "preLoadAfterAdLoaded error");
    }
    do
    {
      do
      {
        return;
        aanp.b("GdtPreLoader", "preLoadAfterAdLoaded");
      } while (!this.a.isQQMINIProgram());
      aanp.b("GdtPreLoader", String.format("canPreloadForQQMINIProgram %b", new Object[] { Boolean.valueOf(this.a.canPreloadForQQMINIProgram()) }));
    } while ((!this.a.canPreloadForQQMINIProgram()) || (TextUtils.isEmpty(this.a.getUrlForLandingPage())));
    aanp.b("GdtPreLoader", "MiniAppPrePullManager.getInstance().prePullAppinfoByLink start");
    MiniAppPrePullManager.getInstance().prePullAppinfoByLink(this.a.getUrlForLandingPage(), false, new aaim(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.1
 * JD-Core Version:    0.7.0.1
 */