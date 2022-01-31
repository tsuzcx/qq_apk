package com.tencent.ad.tangram.statistics;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.device.AdCarrier;
import com.tencent.ad.tangram.loader.AdLoaderWithJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ad.tangram.util.AdClickUtil.Params;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import com.tencent.ad.tangram.util.AdUriUtil;
import java.lang.ref.WeakReference;

@Keep
public final class AdReporterForAnalysis
{
  private static final String TAG = "AdReporterForAnalysis";
  
  public static AdAnalysisEvent createEventCarrier(Context paramContext, int paramInt, long paramLong)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1039, localgdt_analysis_event);
    localgdt_analysis_event.internalErrorCode = paramInt;
    localgdt_analysis_event.duration = paramLong;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static gdt_analysis_event createEventForAd(Context paramContext, int paramInt, Ad paramAd)
  {
    String str1;
    String str2;
    if (paramAd != null)
    {
      str1 = paramAd.getPosId();
      if (paramAd == null) {
        break label101;
      }
      str2 = String.valueOf(paramAd.getAId());
      label27:
      if (paramAd == null) {
        break label107;
      }
    }
    label101:
    label107:
    for (int i = paramAd.getCreativeSize();; i = -2147483648)
    {
      paramAd = new gdt_analysis_event();
      AdAnalysisUtil.initEvent(paramContext, paramInt, paramAd);
      paramAd.posId = str1;
      paramAd.aid = str2;
      paramAd.carrierCode = AdCarrier.getCode(paramContext);
      paramAd.creativeSize = i;
      paramAd.netType = AdNet.getTypeWith5G(paramContext);
      paramAd.networkType = AdNet.getNetworkType(paramContext);
      return paramAd;
      str1 = null;
      break;
      str2 = null;
      break label27;
    }
  }
  
  public static AdAnalysisEvent createEventForAidTicket(Context paramContext, int paramInt1, int paramInt2, long paramLong)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1049, localgdt_analysis_event);
    localgdt_analysis_event.internalErrorCode = paramInt1;
    localgdt_analysis_event.errorCode1 = paramInt2;
    localgdt_analysis_event.duration = paramLong;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static AdAnalysisEvent createEventForAndroidId(Context paramContext, int paramInt, long paramLong, boolean paramBoolean)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1042, localgdt_analysis_event);
    localgdt_analysis_event.internalErrorCode = paramInt;
    localgdt_analysis_event.duration = paramLong;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localgdt_analysis_event.cached = paramInt;
      return new AdAnalysisEvent(localgdt_analysis_event, 102);
    }
  }
  
  public static AdAnalysisEvent createEventForDeviceId(Context paramContext, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1040, localgdt_analysis_event);
    localgdt_analysis_event.internalErrorCode = paramInt1;
    localgdt_analysis_event.duration = paramLong;
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localgdt_analysis_event.cached = paramInt1;
      localgdt_analysis_event.errorCode3 = paramInt2;
      localgdt_analysis_event.phoneType = paramInt2;
      return new AdAnalysisEvent(localgdt_analysis_event, 102);
    }
  }
  
  public static AdAnalysisEvent createEventForDeviceInfoEnd(Context paramContext, String paramString, long paramLong)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1037, localgdt_analysis_event);
    localgdt_analysis_event.businessId = paramString;
    localgdt_analysis_event.duration = paramLong;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static AdAnalysisEvent createEventForGetImei(Context paramContext, int paramInt1, long paramLong, int paramInt2)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1073, localgdt_analysis_event);
    localgdt_analysis_event.internalErrorCode = paramInt1;
    localgdt_analysis_event.duration = paramLong;
    localgdt_analysis_event.errorCode3 = paramInt2;
    localgdt_analysis_event.phoneType = paramInt2;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static AdAnalysisEvent createEventForGetQADID(Context paramContext, int paramInt, long paramLong)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1044, localgdt_analysis_event);
    localgdt_analysis_event.internalErrorCode = paramInt;
    localgdt_analysis_event.duration = paramLong;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static AdAnalysisEvent createEventForIPV4(Context paramContext, int paramInt)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1045, localgdt_analysis_event);
    localgdt_analysis_event.internalErrorCode = paramInt;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  private static gdt_analysis_event createEventForLaunchAppWithDeepLink(Context paramContext, int paramInt, Ad paramAd, boolean paramBoolean)
  {
    int i = 1;
    String str;
    if (paramAd != null)
    {
      str = paramAd.getAppPackageName();
      paramAd = createEventForAd(paramContext, paramInt, paramAd);
      if (!TextUtils.isEmpty(str)) {
        break label55;
      }
      paramAd.androidAppInstalled = 2;
      if (!paramBoolean) {
        break label79;
      }
    }
    label55:
    label79:
    for (paramInt = i;; paramInt = 0)
    {
      paramAd.androidDeeplinkDelayed = paramInt;
      return paramAd;
      str = null;
      break;
      if (AdAppUtil.isInstalled(paramContext, str)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramAd.androidAppInstalled = paramInt;
        break;
      }
    }
  }
  
  public static AdAnalysisEvent createEventForLocation(Context paramContext, boolean paramBoolean, long paramLong)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1038, localgdt_analysis_event);
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localgdt_analysis_event.internalErrorCode = i;
      if (paramBoolean) {
        localgdt_analysis_event.interval = paramLong;
      }
      return new AdAnalysisEvent(localgdt_analysis_event, 102);
    }
  }
  
  public static AdAnalysisEvent createEventForMacAddress(Context paramContext, int paramInt, long paramLong, boolean paramBoolean)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1041, localgdt_analysis_event);
    localgdt_analysis_event.internalErrorCode = paramInt;
    localgdt_analysis_event.duration = paramLong;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localgdt_analysis_event.cached = paramInt;
      return new AdAnalysisEvent(localgdt_analysis_event, 102);
    }
  }
  
  private static gdt_analysis_event createEventForStatistics(Context paramContext, int paramInt1, int paramInt2, Ad paramAd, String paramString)
  {
    paramString = AdUriUtil.parse(paramString);
    paramAd = createEventForAd(paramContext, paramInt1, paramAd);
    paramAd.statisticsType = paramInt2;
    if (paramString != null) {}
    for (paramContext = paramString.getHost();; paramContext = null)
    {
      paramAd.hostName = paramContext;
      return paramAd;
    }
  }
  
  public static AdAnalysisEvent createEventForTaidTicket(Context paramContext, int paramInt1, int paramInt2, long paramLong)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1050, localgdt_analysis_event);
    localgdt_analysis_event.internalErrorCode = paramInt1;
    localgdt_analysis_event.errorCode1 = paramInt2;
    localgdt_analysis_event.duration = paramLong;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static AdAnalysisEvent createEventImeiConsistency(Context paramContext, int paramInt1, int paramInt2)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1074, localgdt_analysis_event);
    localgdt_analysis_event.internalErrorCode = paramInt1;
    localgdt_analysis_event.errorCode3 = paramInt2;
    localgdt_analysis_event.phoneType = paramInt2;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static AdAnalysisEvent createEventImeiSource(Context paramContext, int paramInt1, int paramInt2)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1075, localgdt_analysis_event);
    localgdt_analysis_event.androidSimState = paramInt1;
    localgdt_analysis_event.muidSourceType = paramInt1;
    localgdt_analysis_event.errorCode3 = paramInt2;
    localgdt_analysis_event.phoneType = paramInt2;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static void reportForAPIInvoked(Context paramContext, boolean paramBoolean, String paramString, Ad paramAd)
  {
    if (paramBoolean) {}
    for (int i = 102;; i = 103)
    {
      paramAd = createEventForAd(paramContext, 1051, paramAd);
      paramAd.api = paramString;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, i));
      return;
    }
  }
  
  public static void reportForAPIInvoked(Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    Uri localUri = AdUriUtil.parse(paramString2);
    int i;
    if (paramBoolean)
    {
      i = 102;
      paramString2 = new gdt_analysis_event();
      AdAnalysisUtil.initEvent(paramContext, 1051, paramString2);
      paramString2.api = paramString1;
      if (localUri == null) {
        break label85;
      }
    }
    label85:
    for (paramString1 = AdUriUtil.getQueryParameter(localUri, "pid");; paramString1 = null)
    {
      paramString2.posId = paramString1;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramString2, i));
      return;
      i = 103;
      break;
    }
  }
  
  public static void reportForARKReceiveNotification(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, Ad paramAd)
  {
    if (paramBoolean) {}
    for (int i = 102;; i = 103)
    {
      paramAd = createEventForAd(paramContext, 1071, paramAd);
      paramAd.api = paramString1;
      paramAd.hostName = paramString2;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, i));
      return;
    }
  }
  
  public static void reportForARKSendNotification(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, Ad paramAd)
  {
    if (paramBoolean) {}
    for (int i = 102;; i = 103)
    {
      paramAd = createEventForAd(paramContext, 1072, paramAd);
      paramAd.api = paramString1;
      paramAd.hostName = paramString2;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, i));
      return;
    }
  }
  
  public static void reportForActionStatisticsEnd(Context paramContext, Ad paramAd, AdHttp.Params paramParams)
  {
    reportForStatisticsEnd(paramContext, 4, new int[] { 200 }, paramAd, paramParams);
  }
  
  public static void reportForActionStatisticsStart(Context paramContext, Ad paramAd, String paramString)
  {
    reportForStatisticsStart(paramContext, 4, paramAd, paramString);
  }
  
  public static void reportForActivityStatusChanged(Context paramContext, Ad paramAd, String paramString, int paramInt)
  {
    paramAd = createEventForAd(paramContext, 1102, paramAd);
    paramAd.api = paramString;
    paramAd.acitivtyStatus = paramInt;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, 102));
  }
  
  public static void reportForAppInstalled(AdClickUtil.Params paramParams)
  {
    Object localObject2 = null;
    Activity localActivity;
    if ((paramParams != null) && (paramParams.activity != null))
    {
      localActivity = (Activity)paramParams.activity.get();
      if (paramParams == null) {
        break label105;
      }
    }
    label105:
    for (Object localObject1 = paramParams.ad;; localObject1 = null)
    {
      gdt_analysis_event localgdt_analysis_event = createEventForAd(localActivity, 1062, (Ad)localObject1);
      localObject1 = localObject2;
      if (paramParams != null)
      {
        localObject1 = localObject2;
        if (paramParams.ad != null) {
          localObject1 = paramParams.ad.getAppPackageName();
        }
      }
      localgdt_analysis_event.androidPackageName = ((String)localObject1);
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(localActivity), new AdAnalysisEvent(localgdt_analysis_event, 103));
      return;
      localActivity = null;
      break;
    }
  }
  
  public static void reportForBanner(Context paramContext, Ad paramAd)
  {
    paramAd = createEventForAd(paramContext, 1054, paramAd);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, 102));
  }
  
  public static void reportForClickEnd(AdClickUtil.Params paramParams, AdClickUtil.Result paramResult)
  {
    int j = 1;
    Activity localActivity;
    if ((paramParams != null) && (paramParams.activity != null))
    {
      localActivity = (Activity)paramParams.activity.get();
      if (paramParams == null) {
        break label122;
      }
      paramParams = paramParams.ad;
      label34:
      paramParams = createEventForAd(localActivity, 1017, paramParams);
      if (paramResult == null) {
        break label127;
      }
      i = paramResult.getErrorCode();
      label53:
      paramParams.internalErrorCode = i;
      if (paramResult == null) {
        break label132;
      }
      i = paramResult.action;
      label67:
      paramParams.actionId = i;
      if ((paramResult == null) || (!paramResult.errorHandled)) {
        break label137;
      }
    }
    label132:
    label137:
    for (int i = j;; i = 0)
    {
      paramParams.errorHandled = i;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(localActivity), new AdAnalysisEvent(paramParams, 103));
      return;
      localActivity = null;
      break;
      label122:
      paramParams = null;
      break label34;
      label127:
      i = 1;
      break label53;
      i = 0;
      break label67;
    }
  }
  
  public static void reportForClickStart(AdClickUtil.Params paramParams)
  {
    Activity localActivity;
    if ((paramParams != null) && (paramParams.activity != null))
    {
      localActivity = (Activity)paramParams.activity.get();
      if (paramParams == null) {
        break label70;
      }
    }
    label70:
    for (paramParams = paramParams.ad;; paramParams = null)
    {
      paramParams = createEventForAd(localActivity, 1016, paramParams);
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(localActivity), new AdAnalysisEvent(paramParams, 103));
      return;
      localActivity = null;
      break;
    }
  }
  
  public static void reportForClickStatisticsEnd(Context paramContext, Ad paramAd, AdHttp.Params paramParams)
  {
    reportForStatisticsEnd(paramContext, 2, new int[] { 200, 302 }, paramAd, paramParams);
  }
  
  public static void reportForClickStatisticsStart(Context paramContext, Ad paramAd, String paramString)
  {
    reportForStatisticsStart(paramContext, 2, paramAd, paramString);
  }
  
  public static void reportForEffectStatisticsEnd(Context paramContext, Ad paramAd, AdHttp.Params paramParams)
  {
    reportForStatisticsEnd(paramContext, 3, new int[] { 200 }, paramAd, paramParams);
  }
  
  public static void reportForEffectStatisticsStart(Context paramContext, Ad paramAd, String paramString)
  {
    reportForStatisticsStart(paramContext, 3, paramAd, paramString);
  }
  
  public static void reportForGetIPV4End(Context paramContext, long paramLong, AdHttp.Params paramParams, String paramString, Throwable paramThrowable)
  {
    int j;
    if ((paramParams == null) || (!paramParams.canSend()))
    {
      i = 4;
      if (i != 0) {
        break label187;
      }
      j = 1047;
      label24:
      paramString = new gdt_analysis_event();
      AdAnalysisUtil.initEvent(paramContext, j, paramString);
      paramString.carrierCode = AdCarrier.getCode(paramContext);
      paramString.netType = AdNet.getTypeWith5G(paramContext);
      paramString.networkType = AdNet.getNetworkType(paramContext);
      paramString.duration = paramLong;
      paramString.internalErrorCode = i;
      if (paramParams == null) {
        break label195;
      }
    }
    label187:
    label195:
    for (int i = paramParams.responseCode;; i = -2147483648)
    {
      paramString.httpErrorCode = i;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramString, 102));
      return;
      if (paramParams.responseCode == -2147483648)
      {
        i = 3;
        break;
      }
      if (paramParams.responseCode != 200)
      {
        i = 5;
        break;
      }
      if (paramThrowable != null)
      {
        i = 11;
        break;
      }
      if (TextUtils.isEmpty(paramString))
      {
        i = 5;
        break;
      }
      i = 0;
      break;
      j = 1048;
      break label24;
    }
  }
  
  public static void reportForGetIPV4Start(Context paramContext)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1046, localgdt_analysis_event);
    localgdt_analysis_event.carrierCode = AdCarrier.getCode(paramContext);
    localgdt_analysis_event.netType = AdNet.getTypeWith5G(paramContext);
    localgdt_analysis_event.networkType = AdNet.getNetworkType(paramContext);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, 102));
  }
  
  public static void reportForJSBridgeInvoked(Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    Uri localUri = AdUriUtil.parse(paramString2);
    int i;
    gdt_analysis_event localgdt_analysis_event;
    if (paramBoolean)
    {
      i = 102;
      localgdt_analysis_event = new gdt_analysis_event();
      AdAnalysisUtil.initEvent(paramContext, 1052, localgdt_analysis_event);
      localgdt_analysis_event.api = paramString1;
      localgdt_analysis_event.url = paramString2;
      if (localUri == null) {
        break label94;
      }
    }
    label94:
    for (paramString1 = localUri.getHost();; paramString1 = null)
    {
      localgdt_analysis_event.hostName = paramString1;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, i));
      return;
      i = 103;
      break;
    }
  }
  
  public static void reportForJSBridgeInvoked(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, Ad paramAd)
  {
    Uri localUri = AdUriUtil.parse(paramString2);
    int i;
    if (paramBoolean)
    {
      i = 102;
      paramAd = createEventForAd(paramContext, 1052, paramAd);
      paramAd.api = paramString1;
      paramAd.url = paramString2;
      if (localUri == null) {
        break label87;
      }
    }
    label87:
    for (paramString1 = localUri.getHost();; paramString1 = null)
    {
      paramAd.hostName = paramString1;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, i));
      return;
      i = 103;
      break;
    }
  }
  
  public static void reportForJSBridgeInvoked(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = null;
    Uri localUri1 = AdUriUtil.parse(paramString2);
    Uri localUri2 = AdUriUtil.parse(paramString3);
    int i;
    if (paramBoolean)
    {
      i = 102;
      paramString3 = new gdt_analysis_event();
      AdAnalysisUtil.initEvent(paramContext, 1052, paramString3);
      paramString3.api = paramString1;
      paramString3.url = paramString2;
      if (localUri2 == null) {
        break label126;
      }
    }
    label126:
    for (paramString1 = AdUriUtil.getQueryParameter(localUri2, "pid");; paramString1 = null)
    {
      paramString3.posId = paramString1;
      paramString1 = localObject;
      if (localUri1 != null) {
        paramString1 = localUri1.getHost();
      }
      paramString3.hostName = paramString1;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramString3, i));
      return;
      i = 103;
      break;
    }
  }
  
  public static void reportForLaunchAppMarket(AdClickUtil.Params paramParams, AdClickUtil.Result paramResult, String paramString)
  {
    Object localObject2 = null;
    Activity localActivity;
    Object localObject1;
    label36:
    int i;
    if ((paramParams != null) && (paramParams.activity != null))
    {
      localActivity = (Activity)paramParams.activity.get();
      if (paramParams == null) {
        break label162;
      }
      localObject1 = paramParams.ad;
      if (paramResult == null) {
        break label168;
      }
      i = paramResult.getErrorCode();
      label45:
      localObject1 = createEventForAd(localActivity, 1061, (Ad)localObject1);
      ((gdt_analysis_event)localObject1).androidActivityName = paramString;
      if ((paramParams == null) || (paramParams.ad == null)) {
        break label173;
      }
    }
    label162:
    label168:
    label173:
    for (paramResult = paramParams.ad.getAppMarketPackageName();; paramResult = null)
    {
      ((gdt_analysis_event)localObject1).androidAppMarketPackageName = paramResult;
      paramResult = localObject2;
      if (paramParams != null)
      {
        paramResult = localObject2;
        if (paramParams.ad != null) {
          paramResult = paramParams.ad.getAppPackageName();
        }
      }
      ((gdt_analysis_event)localObject1).androidPackageName = paramResult;
      ((gdt_analysis_event)localObject1).internalErrorCode = i;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(localActivity), new AdAnalysisEvent((gdt_analysis_event)localObject1, 103));
      return;
      localActivity = null;
      break;
      localObject1 = null;
      break label36;
      i = 1;
      break label45;
    }
  }
  
  public static void reportForLaunchAppWithDeepLinkEND(AdClickUtil.Params paramParams, AdClickUtil.Result paramResult, boolean paramBoolean)
  {
    Activity localActivity;
    label32:
    int i;
    if ((paramParams != null) && (paramParams.activity != null))
    {
      localActivity = (Activity)paramParams.activity.get();
      if (paramParams == null) {
        break label97;
      }
      paramParams = paramParams.ad;
      if (paramResult == null) {
        break label102;
      }
      i = paramResult.getErrorCode();
      label41:
      if (i != 0) {
        break label107;
      }
    }
    label97:
    label102:
    label107:
    for (int j = 1004;; j = 1005)
    {
      paramParams = createEventForLaunchAppWithDeepLink(localActivity, j, paramParams, paramBoolean);
      paramParams.internalErrorCode = i;
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(localActivity), new AdAnalysisEvent(paramParams, 103));
      return;
      localActivity = null;
      break;
      paramParams = null;
      break label32;
      i = 1;
      break label41;
    }
  }
  
  public static void reportForLaunchAppWithDeepLinkStart(AdClickUtil.Params paramParams, boolean paramBoolean)
  {
    Activity localActivity;
    if ((paramParams != null) && (paramParams.activity != null))
    {
      localActivity = (Activity)paramParams.activity.get();
      if (paramParams == null) {
        break label71;
      }
    }
    label71:
    for (paramParams = paramParams.ad;; paramParams = null)
    {
      paramParams = createEventForLaunchAppWithDeepLink(localActivity, 1003, paramParams, paramBoolean);
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(localActivity), new AdAnalysisEvent(paramParams, 103));
      return;
      localActivity = null;
      break;
    }
  }
  
  public static void reportForLaunchQQMINIProgramEND(Context paramContext, Ad paramAd, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1014;; i = 1015)
    {
      paramAd = createEventForAd(paramContext, i, paramAd);
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, 103));
      return;
    }
  }
  
  public static void reportForLaunchQQMINIProgramStart(Context paramContext, Ad paramAd)
  {
    paramAd = createEventForAd(paramContext, 1013, paramAd);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, 103));
  }
  
  public static void reportForLoadAd(Context paramContext, String paramString)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1053, localgdt_analysis_event);
    localgdt_analysis_event.posId = paramString;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, 102));
  }
  
  public static void reportForLoadAdEnd(Context paramContext, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = AdLoaderWithJSON.getErrorCode(paramInt1, paramInt2, paramInt3);
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    if (i == 0)
    {
      AdAnalysisUtil.initEvent(paramContext, 1001, localgdt_analysis_event);
      localgdt_analysis_event.carrierCode = AdCarrier.getCode(paramContext);
      localgdt_analysis_event.netType = AdNet.getTypeWith5G(paramContext);
      localgdt_analysis_event.networkType = AdNet.getNetworkType(paramContext);
      localgdt_analysis_event.duration = paramLong;
    }
    for (;;)
    {
      AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, 102));
      return;
      AdAnalysisUtil.initEvent(paramContext, 1002, localgdt_analysis_event);
      localgdt_analysis_event.carrierCode = AdCarrier.getCode(paramContext);
      localgdt_analysis_event.netType = AdNet.getTypeWith5G(paramContext);
      localgdt_analysis_event.networkType = AdNet.getNetworkType(paramContext);
      localgdt_analysis_event.duration = paramLong;
      localgdt_analysis_event.internalErrorCode = i;
      localgdt_analysis_event.httpErrorCode = paramInt1;
      localgdt_analysis_event.errorCode1 = paramInt2;
      localgdt_analysis_event.errorCode2 = paramInt3;
    }
  }
  
  public static void reportForLoadAdStart(Context paramContext)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1000, localgdt_analysis_event);
    localgdt_analysis_event.carrierCode = AdCarrier.getCode(paramContext);
    localgdt_analysis_event.netType = AdNet.getTypeWith5G(paramContext);
    localgdt_analysis_event.networkType = AdNet.getNetworkType(paramContext);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, 102));
  }
  
  public static void reportForRewardedVideo(Context paramContext, Ad paramAd)
  {
    paramAd = createEventForAd(paramContext, 1055, paramAd);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, 102));
  }
  
  public static void reportForStartActivity(Context paramContext, Ad paramAd, String paramString)
  {
    paramAd = createEventForAd(paramContext, 1101, paramAd);
    paramAd.api = paramString;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, 102));
  }
  
  private static void reportForStatisticsEnd(Context paramContext, int paramInt, int[] paramArrayOfInt, Ad paramAd, AdHttp.Params paramParams)
  {
    int j = 0;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AdLog.e("AdReporterForAnalysis", "reportForStatisticsEnd error");
      return;
    }
    if ((paramParams != null) && (paramParams.canSend()))
    {
      int k = paramArrayOfInt.length;
      i = 0;
      if (i >= k) {
        break label187;
      }
      if (paramArrayOfInt[i] != paramParams.responseCode) {}
    }
    label187:
    for (int i = j;; i = 1)
    {
      if (i != 0) {
        if (paramParams.responseCode != -2147483648) {
          i = 5;
        }
      }
      for (;;)
      {
        label82:
        if (paramParams != null) {}
        for (paramArrayOfInt = paramParams.getUrl();; paramArrayOfInt = null)
        {
          paramArrayOfInt = createEventForStatistics(paramContext, 1057, paramInt, paramAd, paramArrayOfInt);
          if (paramParams != null)
          {
            paramArrayOfInt.duration = paramParams.durationMillis;
            paramArrayOfInt.httpErrorCode = paramParams.responseCode;
            paramArrayOfInt.internalErrorCode = i;
          }
          AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramArrayOfInt, 103));
          return;
          i += 1;
          break;
          i = 3;
          break label82;
          i = 4;
          break label82;
        }
      }
    }
  }
  
  private static void reportForStatisticsStart(Context paramContext, int paramInt, Ad paramAd, String paramString)
  {
    paramAd = createEventForStatistics(paramContext, 1056, paramInt, paramAd, paramString);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, 103));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdReporterForAnalysis
 * JD-Core Version:    0.7.0.1
 */