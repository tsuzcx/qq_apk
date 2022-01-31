package com.tencent.gdtad.views.canvas.components.appbutton;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import yxp;
import yzh;
import yzi;

public class GdtAppDownloadManager$5
  implements Runnable
{
  public GdtAppDownloadManager$5(yzi paramyzi) {}
  
  public void run()
  {
    yzh localyzh;
    if (yzi.a(this.this$0) != null) {
      localyzh = new yzh();
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      yxp.a("GdtAppDownloadManager", "fetching AppData " + yzi.a(this.this$0));
      yzi.b(this.this$0);
      if (!TextUtils.isEmpty(yzi.a(this.this$0).getAppId()))
      {
        GdtAppBtnData localGdtAppBtnData = localyzh.a(yzi.a(this.this$0).getAppId(), yzi.a(this.this$0).getAppChannelId(), yzi.a(this.this$0));
        if ((localGdtAppBtnData != null) && (localGdtAppBtnData.isValid()))
        {
          localGdtAppBtnData.mGdtAd_appId = yzi.a(this.this$0).getAppId();
          yzi.a(this.this$0, localGdtAppBtnData);
        }
      }
      long l2;
      if (yzi.a != null)
      {
        yxp.c("GdtAppBtnUIPresenter", "loader sucess!!!");
        l2 = System.currentTimeMillis();
        yzi.a(this.this$0, true, l2 - l1);
        yzi.a(this.this$0);
        yzi.b(this.this$0);
      }
      while ((yzi.a != null) || (yzi.a(this.this$0) >= 2))
      {
        yzi.a(false);
        return;
        yxp.c("GdtAppBtnUIPresenter", "loader failed!!!");
        l2 = System.currentTimeMillis();
        yzi.a(this.this$0, false, l2 - l1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtAppDownloadManager.5
 * JD-Core Version:    0.7.0.1
 */