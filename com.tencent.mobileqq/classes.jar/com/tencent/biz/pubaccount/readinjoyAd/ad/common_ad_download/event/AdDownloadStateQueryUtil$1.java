package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import android.os.Handler;
import android.webkit.ValueCallback;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.lang.ref.SoftReference;

final class AdDownloadStateQueryUtil$1
  implements ValueCallback<Integer>
{
  AdDownloadStateQueryUtil$1(SoftReference paramSoftReference) {}
  
  public void a(Integer paramInteger)
  {
    ThreadManagerV2.getUIHandlerV2().post(new AdDownloadStateQueryUtil.1.1(this, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateQueryUtil.1
 * JD-Core Version:    0.7.0.1
 */