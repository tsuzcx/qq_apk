package com.tencent.gdtad.views.canvas.components.appbutton;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import yxs;
import yzk;
import yzl;

public class GdtAppDownloadManager$6
  implements Runnable
{
  public GdtAppDownloadManager$6(yzl paramyzl) {}
  
  public void run()
  {
    long l1;
    long l2;
    if ((yzl.a(this.this$0) != null) && (yzl.a == null))
    {
      Object localObject = new yzk();
      l1 = System.currentTimeMillis();
      if (!TextUtils.isEmpty(yzl.a(this.this$0).getAppId()))
      {
        localObject = ((yzk)localObject).a(yzl.a(this.this$0).getAppId(), yzl.a(this.this$0).getAppChannelId(), -1);
        if ((localObject != null) && (((GdtAppBtnData)localObject).isValid()))
        {
          ((GdtAppBtnData)localObject).mGdtAd_appId = yzl.a(this.this$0).getAppId();
          yzl.a(this.this$0, (GdtAppBtnData)localObject);
        }
      }
      if ((yzl.a == null) || (yzl.a(this.this$0))) {
        break label161;
      }
      yxs.c("GdtAppBtnUIPresenter", "Click loader sucess!!!");
      this.this$0.b();
      l2 = System.currentTimeMillis();
      yzl.a(this.this$0, true, l2 - l1);
    }
    for (;;)
    {
      yzl.a(false);
      return;
      label161:
      yxs.c("GdtAppBtnUIPresenter", "Click loader failed!!!");
      l2 = System.currentTimeMillis();
      yzl.a(this.this$0, false, l2 - l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtAppDownloadManager.6
 * JD-Core Version:    0.7.0.1
 */