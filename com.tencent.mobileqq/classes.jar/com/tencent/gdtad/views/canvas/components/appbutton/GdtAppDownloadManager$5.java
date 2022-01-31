package com.tencent.gdtad.views.canvas.components.appbutton;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import yxs;
import yzk;
import yzl;

public class GdtAppDownloadManager$5
  implements Runnable
{
  public GdtAppDownloadManager$5(yzl paramyzl) {}
  
  public void run()
  {
    yzk localyzk;
    if (yzl.a(this.this$0) != null) {
      localyzk = new yzk();
    }
    for (;;)
    {
      long l1 = System.currentTimeMillis();
      yxs.a("GdtAppDownloadManager", "fetching AppData " + yzl.a(this.this$0));
      yzl.b(this.this$0);
      if (!TextUtils.isEmpty(yzl.a(this.this$0).getAppId()))
      {
        GdtAppBtnData localGdtAppBtnData = localyzk.a(yzl.a(this.this$0).getAppId(), yzl.a(this.this$0).getAppChannelId(), yzl.a(this.this$0));
        if ((localGdtAppBtnData != null) && (localGdtAppBtnData.isValid()))
        {
          localGdtAppBtnData.mGdtAd_appId = yzl.a(this.this$0).getAppId();
          yzl.a(this.this$0, localGdtAppBtnData);
        }
      }
      long l2;
      if (yzl.a != null)
      {
        yxs.c("GdtAppBtnUIPresenter", "loader sucess!!!");
        l2 = System.currentTimeMillis();
        yzl.a(this.this$0, true, l2 - l1);
        yzl.a(this.this$0);
        yzl.b(this.this$0);
      }
      while ((yzl.a != null) || (yzl.a(this.this$0) >= 2))
      {
        yzl.a(false);
        return;
        yxs.c("GdtAppBtnUIPresenter", "loader failed!!!");
        l2 = System.currentTimeMillis();
        yzl.a(this.this$0, false, l2 - l1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtAppDownloadManager.5
 * JD-Core Version:    0.7.0.1
 */