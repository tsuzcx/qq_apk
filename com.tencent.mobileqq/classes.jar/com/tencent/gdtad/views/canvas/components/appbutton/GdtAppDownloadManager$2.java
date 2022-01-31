package com.tencent.gdtad.views.canvas.components.appbutton;

import com.tencent.gdtad.aditem.GdtAd;
import yny;
import ypr;

public class GdtAppDownloadManager$2
  implements Runnable
{
  public GdtAppDownloadManager$2(ypr paramypr) {}
  
  public void run()
  {
    ypr.b(this.this$0, true);
    if (ypr.a == null)
    {
      yny.b("GdtAppBtnUIPresenter", "mClick Delay 800ms --->Use Default Data");
      GdtAppBtnData localGdtAppBtnData = new GdtAppBtnData();
      localGdtAppBtnData.apkUrlhttp = ypr.a(this.this$0).getAppPackageUrl();
      localGdtAppBtnData.packageName = ypr.a(this.this$0).getAppPackageName();
      localGdtAppBtnData.name = ypr.a(this.this$0).getAppName();
      yny.b("GdtAppBtnUIPresenter", "DefaultGdtAppBtnData apkUrlhttp " + localGdtAppBtnData.apkUrlhttp);
      localGdtAppBtnData.mGdtAd_appId = ypr.a(this.this$0).getAppId();
      ypr.a(this.this$0, localGdtAppBtnData);
      this.this$0.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */