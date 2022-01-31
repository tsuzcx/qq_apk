package com.tencent.gdtad.api.interstitial;

import aaoq;
import aaot;
import android.content.Context;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.settings.AdSettingsUtil;
import java.lang.ref.WeakReference;

public class GdtInterstitialPreDownloader$1
  implements Runnable
{
  public GdtInterstitialPreDownloader$1(aaot paramaaot, WeakReference paramWeakReference) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = AdSettingsUtil.INSTANCE;
    if (this.a != null)
    {
      localContext = (Context)this.a.get();
      ((AdSettingsUtil)localObject).update(localContext);
      localObject = aaoq.a();
      if (this.a == null) {
        break label121;
      }
    }
    label121:
    for (Context localContext = (Context)this.a.get();; localContext = null)
    {
      boolean bool = ((aaoq)localObject).a(localContext);
      if (bool) {
        aaot.a().a();
      }
      AdLog.i("GdtInterstitialPreDownloader", "preDownloadAfterToolProcessStartup enabled:" + bool + " durationMillis:" + (System.currentTimeMillis() - l));
      return;
      localContext = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialPreDownloader.1
 * JD-Core Version:    0.7.0.1
 */