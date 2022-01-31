package com.tencent.gdtad.views.canvas.components.appbutton;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import yny;
import ypq;
import ypr;

public class GdtAppDownloadManager$4
  implements Runnable
{
  public GdtAppDownloadManager$4(ypr paramypr) {}
  
  public void run()
  {
    ypq localypq;
    if (ypr.a(this.this$0) != null) {
      localypq = new ypq();
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      yny.a("GdtAppDownloadManager", "fetching AppData " + ypr.a(this.this$0));
      ypr.b(this.this$0);
      if (!TextUtils.isEmpty(ypr.a(this.this$0).getAppId()))
      {
        GdtAppBtnData localGdtAppBtnData = localypq.a(ypr.a(this.this$0).getAppId(), ypr.a(this.this$0).getAppChannelId(), ypr.a(this.this$0));
        if ((localGdtAppBtnData != null) && (localGdtAppBtnData.isValid()))
        {
          localGdtAppBtnData.mGdtAd_appId = ypr.a(this.this$0).getAppId();
          ypr.a(this.this$0, localGdtAppBtnData);
        }
      }
      long l2;
      if (ypr.a != null)
      {
        yny.c("GdtAppBtnUIPresenter", "loader sucess!!!");
        l2 = System.currentTimeMillis();
        ypr.a(this.this$0, true, l2 - l1);
        ypr.a(this.this$0);
        ypr.b(this.this$0);
      }
      while ((ypr.a != null) || (ypr.a(this.this$0) >= 2))
      {
        ypr.a(false);
        return;
        yny.c("GdtAppBtnUIPresenter", "loader failed!!!");
        l2 = System.currentTimeMillis();
        ypr.a(this.this$0, false, l2 - l1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtAppDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */