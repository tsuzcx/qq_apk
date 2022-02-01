package com.tencent.gdtad.api.interstitial;

import acmb;
import acme;
import android.content.Context;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import java.lang.ref.WeakReference;

public class GdtInterstitialPreDownloader$1
  implements Runnable
{
  public GdtInterstitialPreDownloader$1(acme paramacme, WeakReference paramWeakReference) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = AdSettingsUtil.INSTANCE;
    if (this.a != null)
    {
      localContext = (Context)this.a.get();
      ((AdSettingsUtil)localObject).update(localContext);
      localObject = acmb.a();
      if (this.a == null) {
        break label121;
      }
    }
    label121:
    for (Context localContext = (Context)this.a.get();; localContext = null)
    {
      boolean bool = ((acmb)localObject).a(localContext);
      if (bool) {
        acme.a().a();
      }
      AdLog.i("GdtInterstitialPreDownloader", "preDownloadAfterToolProcessStartup enabled:" + bool + " durationMillis:" + (System.currentTimeMillis() - l));
      return;
      localContext = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader.1
 * JD-Core Version:    0.7.0.1
 */