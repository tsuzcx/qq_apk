package com.tencent.gdtad.aditem;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;
import ysu;
import ysv;
import yxp;

public class GdtPreLoader$1
  implements Runnable
{
  public GdtPreLoader$1(ysu paramysu, GdtAd paramGdtAd) {}
  
  public void run()
  {
    if ((this.a == null) || (!this.a.isValid())) {
      yxp.d("GdtPreLoader", "preLoadAfterAdLoaded error");
    }
    do
    {
      do
      {
        return;
        yxp.b("GdtPreLoader", "preLoadAfterAdLoaded");
      } while (!this.a.isQQMINIProgram());
      yxp.b("GdtPreLoader", String.format("canPreloadForQQMINIProgram %b", new Object[] { Boolean.valueOf(this.a.canPreloadForQQMINIProgram()) }));
    } while ((!this.a.canPreloadForQQMINIProgram()) || (TextUtils.isEmpty(this.a.getUrlForLandingPage())));
    yxp.b("GdtPreLoader", "MiniAppPrePullManager.getInstance().prePullAppinfoByLink start");
    MiniAppPrePullManager.getInstance().prePullAppinfoByLink(this.a.getUrlForLandingPage(), new ysv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtPreLoader.1
 * JD-Core Version:    0.7.0.1
 */