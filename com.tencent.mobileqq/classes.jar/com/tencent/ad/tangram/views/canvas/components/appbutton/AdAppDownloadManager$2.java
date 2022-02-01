package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

class AdAppDownloadManager$2
  implements Runnable
{
  AdAppDownloadManager$2(AdAppDownloadManager paramAdAppDownloadManager) {}
  
  public void run()
  {
    if (this.this$0.ad != null)
    {
      new b();
      int i = 0;
      int j;
      do
      {
        long l1 = System.currentTimeMillis();
        j = i + 1;
        if (!TextUtils.isEmpty(this.this$0.ad.getAppId()))
        {
          AdAppBtnData localAdAppBtnData = b.loadGdtAppBtnData(this.this$0.ad.getAppId(), this.this$0.ad.getAppChannelId(), j);
          if ((localAdAppBtnData != null) && (localAdAppBtnData.isValid()))
          {
            localAdAppBtnData.mGdtAd_appId = this.this$0.ad.getAppId();
            AdAppDownloadManager.access$100(this.this$0, localAdAppBtnData);
          }
        }
        long l2;
        if (AdAppDownloadManager.access$200(this.this$0) != null)
        {
          AdLog.w("AdCanvasAppBtnUIAdapter", "loader sucess!!!");
          l2 = System.currentTimeMillis();
          AdAppDownloadManager.access$300(this.this$0, true, l2 - l1);
          AdAppDownloadManager.access$400(this.this$0);
          if ((AdAppDownloadManager.access$500(this.this$0) != null) && (AdAppDownloadManager.access$500(this.this$0).get() != null)) {
            ((AdAppDownloadManager.a)AdAppDownloadManager.access$500(this.this$0).get()).onFetchSuccess(AdAppDownloadManager.access$200(this.this$0));
          }
          AdAppDownloadManager.access$600(this.this$0);
        }
        else
        {
          AdLog.w("AdCanvasAppBtnUIAdapter", "loader failed!!!");
          l2 = System.currentTimeMillis();
          AdAppDownloadManager.access$300(this.this$0, false, l2 - l1);
        }
        if (AdAppDownloadManager.access$200(this.this$0) != null) {
          break;
        }
        i = j;
      } while (j < 3);
    }
    AdAppDownloadManager.access$702(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */