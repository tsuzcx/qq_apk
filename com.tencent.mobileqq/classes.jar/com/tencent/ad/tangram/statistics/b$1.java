package com.tencent.ad.tangram.statistics;

import android.content.Context;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import java.lang.ref.WeakReference;

final class b$1
  implements Runnable
{
  b$1(String paramString, WeakReference paramWeakReference, Ad paramAd) {}
  
  public void run()
  {
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl(this.val$url);
    localParams.method = "GET";
    AdHttp.send(localParams);
    if (this.val$context != null) {}
    for (Context localContext = (Context)this.val$context.get();; localContext = null)
    {
      AdReporterForAnalysis.reportForEffectStatisticsEnd(localContext, this.val$ad, localParams);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.b.1
 * JD-Core Version:    0.7.0.1
 */