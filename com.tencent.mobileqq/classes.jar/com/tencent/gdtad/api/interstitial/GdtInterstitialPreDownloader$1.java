package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import java.lang.ref.WeakReference;

class GdtInterstitialPreDownloader$1
  implements Runnable
{
  GdtInterstitialPreDownloader$1(GdtInterstitialPreDownloader paramGdtInterstitialPreDownloader, WeakReference paramWeakReference) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    AdSettingsUtil localAdSettingsUtil = AdSettingsUtil.INSTANCE;
    if (this.a != null) {}
    for (Context localContext = (Context)this.a.get();; localContext = null)
    {
      localAdSettingsUtil.update(localContext);
      GdtInterstitialPreDownloader.a().a();
      AdLog.i("GdtInterstitialPreDownloader", "preDownloadAfterToolProcessStartup durationMillis:" + (System.currentTimeMillis() - l));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader.1
 * JD-Core Version:    0.7.0.1
 */