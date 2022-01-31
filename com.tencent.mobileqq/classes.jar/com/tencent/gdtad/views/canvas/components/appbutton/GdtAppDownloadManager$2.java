package com.tencent.gdtad.views.canvas.components.appbutton;

import com.tencent.gdtad.aditem.GdtAd;
import yxs;
import yzl;

public class GdtAppDownloadManager$2
  implements Runnable
{
  public GdtAppDownloadManager$2(yzl paramyzl) {}
  
  public void run()
  {
    yzl.b(this.this$0, true);
    if (yzl.a == null)
    {
      yxs.b("GdtAppBtnUIPresenter", "mClick Delay 800ms --->Use Default Data");
      GdtAppBtnData localGdtAppBtnData = new GdtAppBtnData();
      localGdtAppBtnData.apkUrlhttp = yzl.a(this.this$0).getAppPackageUrl();
      localGdtAppBtnData.packageName = yzl.a(this.this$0).getAppPackageName();
      localGdtAppBtnData.name = yzl.a(this.this$0).getAppName();
      yxs.b("GdtAppBtnUIPresenter", "DefaultGdtAppBtnData apkUrlhttp " + localGdtAppBtnData.apkUrlhttp);
      localGdtAppBtnData.mGdtAd_appId = yzl.a(this.this$0).getAppId();
      yzl.a(this.this$0, localGdtAppBtnData);
      this.this$0.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */