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
    if ((paramAd != null) && (paramAd.isValid())) {
      paramAd = paramAd.getUrlForFeedBack();
    } else {
      paramAd = null;
    }
    if (TextUtils.isEmpty(paramAd)) {
      return null;
    }
    return paramAd.replaceAll("__ACT_TYPE__", String.valueOf(paramInt));
  }
  
  public static void reportAsync(WeakReference<Context> paramWeakReference, Ad paramAd, int paramInt)
  {
    String str = getUrl(paramAd, paramInt);
    AdLog.i("AdReporterForFeedback", String.format("reportAsync %s", new Object[] { str }));
    Context localContext;
    if (paramWeakReference != null) {
      localContext = (Context)paramWeakReference.get();
    } else {
      localContext = null;
    }
    a.reportForFeedbackStatisticsStart(localContext, paramAd, str);
    AdThreadManager.INSTANCE.post(new AdReporterForFeedback.1(str, paramWeakReference, paramAd), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdReporterForFeedback
 * JD-Core Version:    0.7.0.1
 */