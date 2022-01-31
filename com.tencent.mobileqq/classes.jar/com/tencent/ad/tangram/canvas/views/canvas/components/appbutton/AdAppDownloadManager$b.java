package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;

class AdAppDownloadManager$b
  implements Runnable
{
  String id;
  
  AdAppDownloadManager$b(AdAppDownloadManager paramAdAppDownloadManager, String paramString)
  {
    this.id = paramString;
  }
  
  public void run()
  {
    long l1;
    long l2;
    if ((this.this$0.ad != null) && (AdAppDownloadManager.access$200(this.this$0) == null))
    {
      Object localObject = new b();
      l1 = System.currentTimeMillis();
      if (!TextUtils.isEmpty(this.this$0.ad.getAppId()))
      {
        localObject = ((b)localObject).loadGdtAppBtnData(this.this$0.ad.getAppId(), this.this$0.ad.getAppChannelId(), -1);
        if ((localObject != null) && (((AdAppBtnData)localObject).isValid()))
        {
          ((AdAppBtnData)localObject).mGdtAd_appId = this.this$0.ad.getAppId();
          AdAppDownloadManager.access$100(this.this$0, (AdAppBtnData)localObject);
        }
      }
      if (AdAppDownloadManager.access$200(this.this$0) == null) {
        break label172;
      }
      AdLog.w("AdCanvasAppBtnUIAdapter", "Click loader sucess!!!");
      this.this$0.initDownloadAction(true);
      l2 = System.currentTimeMillis();
      AdAppDownloadManager.access$300(this.this$0, true, l2 - l1);
    }
    for (;;)
    {
      AdAppDownloadManager.access$602(this.this$0, false);
      return;
      label172:
      AdLog.w("AdCanvasAppBtnUIAdapter", "Click loader failed!!!");
      l2 = System.currentTimeMillis();
      AdAppDownloadManager.access$300(this.this$0, false, l2 - l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager.b
 * JD-Core Version:    0.7.0.1
 */