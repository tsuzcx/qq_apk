package com.tencent.gdtad.views.canvas.components.appbutton;

import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import yxp;
import yzh;
import yzi;

public class GdtAppDownloadManager$6
  implements Runnable
{
  public GdtAppDownloadManager$6(yzi paramyzi) {}
  
  public void run()
  {
    long l1;
    long l2;
    if ((yzi.a(this.this$0) != null) && (yzi.a == null))
    {
      Object localObject = new yzh();
      l1 = System.currentTimeMillis();
      if (!TextUtils.isEmpty(yzi.a(this.this$0).getAppId()))
      {
        localObject = ((yzh)localObject).a(yzi.a(this.this$0).getAppId(), yzi.a(this.this$0).getAppChannelId(), -1);
        if ((localObject != null) && (((GdtAppBtnData)localObject).isValid()))
        {
          ((GdtAppBtnData)localObject).mGdtAd_appId = yzi.a(this.this$0).getAppId();
          yzi.a(this.this$0, (GdtAppBtnData)localObject);
        }
      }
      if ((yzi.a == null) || (yzi.a(this.this$0))) {
        break label161;
      }
      yxp.c("GdtAppBtnUIPresenter", "Click loader sucess!!!");
      this.this$0.b();
      l2 = System.currentTimeMillis();
      yzi.a(this.this$0, true, l2 - l1);
    }
    for (;;)
    {
      yzi.a(false);
      return;
      label161:
      yxp.c("GdtAppBtnUIPresenter", "Click loader failed!!!");
      l2 = System.currentTimeMillis();
      yzi.a(this.this$0, false, l2 - l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtAppDownloadManager.6
 * JD-Core Version:    0.7.0.1
 */