package com.tencent.gdtad.statistics;

import android.content.Context;
import android.net.Uri;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.statistics.AdAnalysisHelper;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.c2s.GdtC2SReportInterface;
import java.lang.ref.WeakReference;

public final class GdtReporterForAnalysis
{
  private static gdt_analysis_event a(Context paramContext, int paramInt1, GdtAd paramGdtAd, int paramInt2, int paramInt3, String paramString)
  {
    paramString = AdUriUtil.parse(paramString);
    paramGdtAd = AdAnalysisHelper.createEventForAd(paramContext, paramInt1, paramGdtAd);
    if (paramInt2 == 0) {
      paramGdtAd.statisticsType = 101;
    } else if (paramInt2 == 1) {
      paramGdtAd.statisticsType = 102;
    } else if (paramInt2 == 2) {
      paramGdtAd.statisticsType = 105;
    }
    paramGdtAd.businessId = String.valueOf(paramInt3);
    if (paramString != null) {
      paramContext = paramString.getHost();
    } else {
      paramContext = null;
    }
    paramGdtAd.hostName = paramContext;
    return paramGdtAd;
  }
  
  public static void a(Context paramContext, GdtAd paramGdtAd, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtAd = a(paramContext, 1058, paramGdtAd, paramInt1, paramInt2, null);
    if (paramBoolean) {
      paramInt1 = 0;
    } else {
      paramInt1 = 4;
    }
    paramGdtAd.internalErrorCode = paramInt1;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtAd, 102));
  }
  
  public static void a(Context paramContext, GdtC2SReportInterface paramGdtC2SReportInterface, String paramString)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtC2SReportInterface = a(paramContext, 1056, new GdtAd(paramGdtC2SReportInterface.c), paramGdtC2SReportInterface.a, paramGdtC2SReportInterface.b, paramString);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtC2SReportInterface, 102));
  }
  
  public static void a(Context paramContext, GdtC2SReportInterface paramGdtC2SReportInterface, String paramString, int paramInt)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtC2SReportInterface = a(paramContext, 1060, new GdtAd(paramGdtC2SReportInterface.c), paramGdtC2SReportInterface.a, paramGdtC2SReportInterface.b, paramString);
    paramGdtC2SReportInterface.httpErrorCode = paramInt;
    if (paramGdtC2SReportInterface.httpErrorCode == 200) {
      paramGdtC2SReportInterface.internalErrorCode = 0;
    } else if (paramGdtC2SReportInterface.httpErrorCode == -1) {
      paramGdtC2SReportInterface.internalErrorCode = 3;
    } else {
      paramGdtC2SReportInterface.internalErrorCode = 5;
    }
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtC2SReportInterface, 102));
  }
  
  public static void a(Context paramContext, GdtC2SReportInterface paramGdtC2SReportInterface, String paramString, int paramInt, long paramLong)
  {
    paramContext = BaseApplicationImpl.getContext();
    paramGdtC2SReportInterface = a(paramContext, 1057, new GdtAd(paramGdtC2SReportInterface.c), paramGdtC2SReportInterface.a, paramGdtC2SReportInterface.b, paramString);
    paramGdtC2SReportInterface.httpErrorCode = paramInt;
    if (paramGdtC2SReportInterface.httpErrorCode == 200) {
      paramGdtC2SReportInterface.internalErrorCode = 0;
    } else if (paramGdtC2SReportInterface.httpErrorCode == -1) {
      paramGdtC2SReportInterface.internalErrorCode = 3;
    } else {
      paramGdtC2SReportInterface.internalErrorCode = 5;
    }
    paramGdtC2SReportInterface.duration = paramLong;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramGdtC2SReportInterface, 102));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtReporterForAnalysis
 * JD-Core Version:    0.7.0.1
 */