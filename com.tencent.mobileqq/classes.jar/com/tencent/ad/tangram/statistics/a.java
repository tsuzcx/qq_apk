package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.net.Uri;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.util.AdUriUtil;
import java.lang.ref.WeakReference;

public final class a
{
  private static final String TAG = "AdAnalysisHelperForStatistics";
  
  private static gdt_analysis_event createEventForStatistics(Context paramContext, int paramInt1, int paramInt2, Ad paramAd, String paramString)
  {
    paramString = AdUriUtil.parse(paramString);
    paramAd = AdAnalysisHelper.createEventForAd(paramContext, paramInt1, paramAd);
    paramAd.statisticsType = paramInt2;
    if (paramString != null) {
      paramContext = paramString.getHost();
    } else {
      paramContext = null;
    }
    paramAd.hostName = paramContext;
    return paramAd;
  }
  
  static void reportForActionStatisticsEnd(Context paramContext, Ad paramAd, AdHttp.Params paramParams)
  {
    reportForStatisticsEnd(paramContext, 4, new int[] { 200 }, paramAd, paramParams);
  }
  
  static void reportForActionStatisticsStart(Context paramContext, Ad paramAd, String paramString)
  {
    reportForStatisticsStart(paramContext, 4, paramAd, paramString);
  }
  
  static void reportForClickStatisticsEnd(Context paramContext, Ad paramAd, AdHttp.Params paramParams)
  {
    reportForStatisticsEnd(paramContext, 2, new int[] { 200, 302 }, paramAd, paramParams);
  }
  
  static void reportForClickStatisticsStart(Context paramContext, Ad paramAd, String paramString)
  {
    reportForStatisticsStart(paramContext, 2, paramAd, paramString);
  }
  
  static void reportForEffectStatisticsEnd(Context paramContext, Ad paramAd, AdHttp.Params paramParams)
  {
    reportForStatisticsEnd(paramContext, 3, new int[] { 200 }, paramAd, paramParams);
  }
  
  static void reportForEffectStatisticsStart(Context paramContext, Ad paramAd, String paramString)
  {
    reportForStatisticsStart(paramContext, 3, paramAd, paramString);
  }
  
  static void reportForFeedbackStatisticsEnd(Context paramContext, Ad paramAd, AdHttp.Params paramParams)
  {
    reportForStatisticsEnd(paramContext, 7, new int[] { 200 }, paramAd, paramParams);
  }
  
  static void reportForFeedbackStatisticsStart(Context paramContext, Ad paramAd, String paramString)
  {
    reportForStatisticsStart(paramContext, 7, paramAd, paramString);
  }
  
  static void reportForSdkMsgStatisticsEnd(Context paramContext, Ad paramAd, AdHttp.Params paramParams)
  {
    reportForStatisticsEnd(paramContext, 6, new int[] { 200 }, paramAd, paramParams);
  }
  
  static void reportForSdkMsgStatisticsStart(Context paramContext, Ad paramAd, String paramString)
  {
    reportForStatisticsStart(paramContext, 6, paramAd, paramString);
  }
  
  public static void reportForSettingsStatisticsEnd(Context paramContext, Ad paramAd, AdHttp.Params paramParams, int paramInt)
  {
    reportForStatisticsEnd(paramContext, paramInt, new int[] { 200 }, paramAd, paramParams);
  }
  
  private static void reportForStatisticsEnd(Context paramContext, int paramInt, int[] paramArrayOfInt, Ad paramAd, AdHttp.Params paramParams)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i;
      if ((paramParams != null) && (paramParams.canSend()))
      {
        int k = paramArrayOfInt.length;
        int j = 0;
        i = 0;
        while (i < k)
        {
          if (paramArrayOfInt[i] == paramParams.responseCode) {
            break label69;
          }
          i += 1;
        }
        j = 1;
        label69:
        i = j;
        if (j != 0) {
          if (paramParams.responseCode != -2147483648) {
            i = 5;
          } else {
            i = 3;
          }
        }
      }
      else
      {
        i = 4;
      }
      if (paramParams != null) {
        paramArrayOfInt = paramParams.getUrl();
      } else {
        paramArrayOfInt = null;
      }
      paramArrayOfInt = createEventForStatistics(paramContext, 1057, paramInt, paramAd, paramArrayOfInt);
      if (paramParams != null)
      {
        paramArrayOfInt.duration = paramParams.durationMillis;
        paramArrayOfInt.httpErrorCode = paramParams.responseCode;
        paramArrayOfInt.internalErrorCode = i;
      }
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramArrayOfInt, 103));
      return;
    }
    AdLog.e("AdAnalysisHelperForStatistics", "reportForStatisticsEnd error");
  }
  
  private static void reportForStatisticsStart(Context paramContext, int paramInt, Ad paramAd, String paramString)
  {
    paramAd = createEventForStatistics(paramContext, 1056, paramInt, paramAd, paramString);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, 103));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.a
 * JD-Core Version:    0.7.0.1
 */