package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import android.webkit.ValueCallback;
import java.lang.ref.SoftReference;

class AdDownloadStateQueryUtil$1$1
  implements Runnable
{
  AdDownloadStateQueryUtil$1$1(AdDownloadStateQueryUtil.1 param1, Integer paramInteger) {}
  
  public void run()
  {
    if (this.this$0.a.get() != null) {
      ((ValueCallback)this.this$0.a.get()).onReceiveValue(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateQueryUtil.1.1
 * JD-Core Version:    0.7.0.1
 */