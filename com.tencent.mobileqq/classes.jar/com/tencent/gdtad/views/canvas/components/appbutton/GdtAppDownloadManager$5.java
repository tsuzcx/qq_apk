package com.tencent.gdtad.views.canvas.components.appbutton;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import yny;
import ypq;
import ypr;

public class GdtAppDownloadManager$5
  implements Runnable
{
  public GdtAppDownloadManager$5(ypr paramypr) {}
  
  public void run()
  {
    long l1;
    long l2;
    if ((ypr.a(this.this$0) != null) && (ypr.a == null))
    {
      Object localObject = new ypq();
      l1 = System.currentTimeMillis();
      if (!TextUtils.isEmpty(ypr.a(this.this$0).getAppId()))
      {
        localObject = ((ypq)localObject).a(ypr.a(this.this$0).getAppId(), ypr.a(this.this$0).getAppChannelId(), -1);
        if ((localObject != null) && (((GdtAppBtnData)localObject).isValid()))
        {
          ((GdtAppBtnData)localObject).mGdtAd_appId = ypr.a(this.this$0).getAppId();
          ypr.a(this.this$0, (GdtAppBtnData)localObject);
        }
      }
      if ((ypr.a == null) || (ypr.a(this.this$0))) {
        break label161;
      }
      yny.c("GdtAppBtnUIPresenter", "Click loader sucess!!!");
      this.this$0.b();
      l2 = System.currentTimeMillis();
      ypr.a(this.this$0, true, l2 - l1);
    }
    for (;;)
    {
      ypr.a(false);
      return;
      label161:
      yny.c("GdtAppBtnUIPresenter", "Click loader failed!!!");
      l2 = System.currentTimeMillis();
      ypr.a(this.this$0, false, l2 - l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtAppDownloadManager.5
 * JD-Core Version:    0.7.0.1
 */