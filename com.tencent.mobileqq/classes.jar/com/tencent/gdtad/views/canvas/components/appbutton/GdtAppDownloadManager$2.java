package com.tencent.gdtad.views.canvas.components.appbutton;

import com.tencent.gdtad.aditem.GdtAd;
import yxp;
import yzi;

public class GdtAppDownloadManager$2
  implements Runnable
{
  public GdtAppDownloadManager$2(yzi paramyzi) {}
  
  public void run()
  {
    yzi.b(this.this$0, true);
    if (yzi.a == null)
    {
      yxp.b("GdtAppBtnUIPresenter", "mClick Delay 800ms --->Use Default Data");
      GdtAppBtnData localGdtAppBtnData = new GdtAppBtnData();
      localGdtAppBtnData.apkUrlhttp = yzi.a(this.this$0).getAppPackageUrl();
      localGdtAppBtnData.packageName = yzi.a(this.this$0).getAppPackageName();
      localGdtAppBtnData.name = yzi.a(this.this$0).getAppName();
      yxp.b("GdtAppBtnUIPresenter", "DefaultGdtAppBtnData apkUrlhttp " + localGdtAppBtnData.apkUrlhttp);
      localGdtAppBtnData.mGdtAd_appId = yzi.a(this.this$0).getAppId();
      yzi.a(this.this$0, localGdtAppBtnData);
      this.this$0.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */