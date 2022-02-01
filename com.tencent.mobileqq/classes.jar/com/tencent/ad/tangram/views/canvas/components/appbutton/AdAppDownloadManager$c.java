package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;

class AdAppDownloadManager$c
  implements Runnable
{
  String id;
  
  AdAppDownloadManager$c(AdAppDownloadManager paramAdAppDownloadManager, String paramString)
  {
    this.id = paramString;
  }
  
  public void run()
  {
    if ((this.this$0.ad != null) && (AdAppDownloadManager.access$200(this.this$0) == null))
    {
      new b();
      long l1 = System.currentTimeMillis();
      if (!TextUtils.isEmpty(this.this$0.ad.getAppId()))
      {
        AdAppBtnData localAdAppBtnData = b.loadGdtAppBtnData(this.this$0.ad.getAppId(), this.this$0.ad.getAppChannelId(), -1);
        if ((localAdAppBtnData != null) && (localAdAppBtnData.isValid()))
        {
          localAdAppBtnData.mGdtAd_appId = this.this$0.ad.getAppId();
          AdAppDownloadManager.access$100(this.this$0, localAdAppBtnData);
        }
      }
      long l2;
      if (AdAppDownloadManager.access$200(this.this$0) != null)
      {
        AdLog.w("AdCanvasAppBtnUIAdapter", "Click loader sucess!!!");
        this.this$0.initDownloadAction(true);
        l2 = System.currentTimeMillis();
        AdAppDownloadManager.access$300(this.this$0, true, l2 - l1);
      }
      else
      {
        AdLog.w("AdCanvasAppBtnUIAdapter", "Click loader failed!!!");
        l2 = System.currentTimeMillis();
        AdAppDownloadManager.access$300(this.this$0, false, l2 - l1);
      }
    }
    AdAppDownloadManager.access$702(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.c
 * JD-Core Version:    0.7.0.1
 */