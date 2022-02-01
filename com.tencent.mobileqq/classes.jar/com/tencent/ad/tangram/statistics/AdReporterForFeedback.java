package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

@Keep
public final class AdReporterForFeedback
{
  private static final String TAG = "AdReporterForFeedback";
  
  private static String getUrl(Ad paramAd, int paramInt)
  {
    if ((paramAd != null) && (paramAd.isValid())) {}
    for (paramAd = paramAd.getUrlForFeedBack(); TextUtils.isEmpty(paramAd); paramAd = null) {
      return null;
    }
    return paramAd.replaceAll("__ACT_TYPE__", String.valueOf(paramInt));
  }
  
  public static void reportAsync(WeakReference<Context> paramWeakReference, Ad paramAd, int paramInt)
  {
    String str = getUrl(paramAd, paramInt);
    AdLog.i("AdReporterForFeedback", String.format("reportAsync %s", new Object[] { str }));
    if (paramWeakReference != null) {}
    for (Context localContext = (Context)paramWeakReference.get();; localContext = null)
    {
      AdReporterForAnalysis.reportForFeedbackStatisticsStart(localContext, paramAd, str);
      AdThreadManager.INSTANCE.post(new AdReporterForFeedback.1(str, paramWeakReference, paramAd), 4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdReporterForFeedback
 * JD-Core Version:    0.7.0.1
 */