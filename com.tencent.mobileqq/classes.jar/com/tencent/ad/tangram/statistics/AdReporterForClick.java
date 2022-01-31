package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

@Keep
public final class AdReporterForClick
{
  private static final String TAG = "AdReporterForClick";
  
  public static void reportAsync(WeakReference<Context> paramWeakReference, Ad paramAd, String paramString)
  {
    AdLog.i("AdReporterForClick", String.format("reportAsync %s", new Object[] { paramString }));
    if (paramWeakReference != null) {}
    for (Context localContext = (Context)paramWeakReference.get();; localContext = null)
    {
      AdReporterForAnalysis.reportForClickStatisticsStart(localContext, paramAd, paramString);
      AdThreadManager.INSTANCE.post(new AdReporterForClick.1(paramString, paramWeakReference, paramAd), 4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdReporterForClick
 * JD-Core Version:    0.7.0.1
 */