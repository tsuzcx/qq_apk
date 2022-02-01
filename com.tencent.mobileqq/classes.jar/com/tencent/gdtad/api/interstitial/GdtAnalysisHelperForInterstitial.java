package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.statistics.AdAnalysisHelper;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import java.lang.ref.WeakReference;

public final class GdtAnalysisHelperForInterstitial
{
  private static gdt_analysis_event a(Context paramContext, int paramInt, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    int j = -2147483648;
    int k = 0;
    if (paramGdtInterstitialParams != null)
    {
      if (paramGdtInterstitialParams.e == 1)
      {
        i = 0;
        break label57;
      }
      if (paramGdtInterstitialParams.e == 0)
      {
        i = 1;
        break label57;
      }
      if (paramGdtInterstitialParams.e == 8)
      {
        i = 2;
        break label57;
      }
    }
    int i = -2147483648;
    label57:
    if ((paramGdtInterstitialParams != null) && (paramGdtInterstitialParams.d != null)) {
      paramGdtInterstitialParams = paramGdtInterstitialParams.d.a;
    } else {
      paramGdtInterstitialParams = null;
    }
    paramContext = AdAnalysisHelper.createEventForAd(paramContext, paramInt, paramGdtInterstitialParams);
    if (paramGdtInterstitialStatus != null) {
      paramInt = paramGdtInterstitialStatus.a;
    } else {
      paramInt = -2147483648;
    }
    paramContext.activityStatus = paramInt;
    long l;
    if (paramGdtInterstitialStatus != null) {
      l = paramGdtInterstitialStatus.a();
    } else {
      l = -2147483648L;
    }
    paramContext.duration = l;
    paramContext.orientation = i;
    if (paramGdtInterstitialStatus != null) {
      paramInt = paramGdtInterstitialStatus.h;
    } else {
      paramInt = -2147483648;
    }
    paramContext.reason = paramInt;
    if ((paramGdtInterstitialStatus != null) && (paramGdtInterstitialStatus.b)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    paramContext.status1 = paramInt;
    if ((paramGdtInterstitialStatus != null) && (paramGdtInterstitialStatus.c)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    paramContext.status2 = paramInt;
    if ((paramGdtInterstitialStatus != null) && (paramGdtInterstitialStatus.d)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    paramContext.status3 = paramInt;
    if ((paramGdtInterstitialStatus != null) && (paramGdtInterstitialStatus.f)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    paramContext.status4 = paramInt;
    paramInt = k;
    if (paramGdtInterstitialStatus != null)
    {
      paramInt = k;
      if (paramGdtInterstitialStatus.g) {
        paramInt = 1;
      }
    }
    paramContext.status5 = paramInt;
    paramInt = j;
    if (paramGdtInterstitialStatus != null) {
      paramInt = paramGdtInterstitialStatus.l;
    }
    paramContext.videoStatus = paramInt;
    return paramContext;
  }
  
  public static void a(Context paramContext)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1081, localgdt_analysis_event);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, 102));
  }
  
  public static void a(Context paramContext, long paramLong, int paramInt1, int paramInt2)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1082, localgdt_analysis_event);
    long l = -2147483648L;
    if (paramLong != -2147483648L) {
      l = System.currentTimeMillis() - paramLong;
    }
    localgdt_analysis_event.duration = l;
    localgdt_analysis_event.internalErrorCode = paramInt1;
    localgdt_analysis_event.errorCode1 = paramInt2;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, 102));
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, int paramInt)
  {
    paramGdtInterstitialParams = a(paramContext, 1084, paramGdtInterstitialParams, null);
    paramGdtInterstitialParams.internalErrorCode = paramInt;
    paramGdtInterstitialParams.androidFromProcessName = AdProcessManager.INSTANCE.getCurrentProcessName(paramContext);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    paramGdtInterstitialParams = a(paramContext, 1086, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, int paramInt)
  {
    paramGdtInterstitialParams = a(paramContext, 1085, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.internalErrorCode = paramInt;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, int paramInt1, int paramInt2)
  {
    paramGdtInterstitialParams = a(paramContext, 1087, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.internalErrorCode = paramInt1;
    paramGdtInterstitialParams.errorCode1 = paramInt2;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void a(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, String paramString1, String paramString2)
  {
    paramGdtInterstitialParams = a(paramContext, 1071, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.api = paramString1;
    paramGdtInterstitialParams.hostName = paramString2;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void b(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    paramGdtInterstitialParams = a(paramContext, 1088, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void b(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus, String paramString1, String paramString2)
  {
    paramGdtInterstitialParams = a(paramContext, 1072, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.api = paramString1;
    paramGdtInterstitialParams.hostName = paramString2;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void c(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    paramGdtInterstitialParams = a(paramContext, 1089, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
  
  public static void d(Context paramContext, GdtInterstitialParams paramGdtInterstitialParams, GdtInterstitialStatus paramGdtInterstitialStatus)
  {
    paramGdtInterstitialParams = a(paramContext, 1092, paramGdtInterstitialParams, paramGdtInterstitialStatus);
    paramGdtInterstitialParams.internalErrorCode = paramGdtInterstitialStatus.i;
    paramGdtInterstitialParams.errorCode1 = paramGdtInterstitialStatus.j;
    paramGdtInterstitialParams.errorCode2 = paramGdtInterstitialStatus.k;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtInterstitialParams, 102));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtAnalysisHelperForInterstitial
 * JD-Core Version:    0.7.0.1
 */