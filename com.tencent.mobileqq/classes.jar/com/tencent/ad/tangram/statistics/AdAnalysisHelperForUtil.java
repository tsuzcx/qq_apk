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
import com.tencent.ad.tangram.device.c;
import com.tencent.ad.tangram.device.r;
import com.tencent.ad.tangram.device.r.a;
import com.tencent.ad.tangram.loader.AdLoaderWithJSON;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.util.AdClickUtil.Params;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import com.tencent.ad.tangram.util.AdUriUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@Keep
public final class AdAnalysisHelperForUtil
{
  private static final String TAG = "AdAnalysisHelperForUtil";
  
  public static AdAnalysisEvent createEventCarrier(Context paramContext, int paramInt, long paramLong)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1039, localgdt_analysis_event);
    localgdt_analysis_event.internalErrorCode = paramInt;
    localgdt_analysis_event.duration = paramLong;
    localgdt_analysis_event.errorCode1 = 0;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static AdAnalysisEvent createEventForAidTicket(Context paramContext, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1049, localgdt_analysis_event);
    localgdt_analysis_event.businessId = paramString;
    localgdt_analysis_event.posId = paramString;
    localgdt_analysis_event.internalErrorCode = paramInt1;
    localgdt_analysis_event.errorCode1 = paramInt2;
    localgdt_analysis_event.duration = paramLong;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static gdt_analysis_event createEventForAppPreOrder(Context paramContext, int paramInt, String paramString)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, paramInt, localgdt_analysis_event);
    localgdt_analysis_event.aid = paramString;
    localgdt_analysis_event.carrierCode = AdCarrier.getCode(paramContext);
    localgdt_analysis_event.netType = AdNet.getTypeWith5G(paramContext);
    localgdt_analysis_event.networkType = AdNet.getNetworkType(paramContext);
    return localgdt_analysis_event;
  }
  
  public static AdAnalysisEvent createEventForDeviceIdentifier(Context paramContext, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, paramInt1, localgdt_analysis_event);
    localgdt_analysis_event.internalErrorCode = paramInt2;
    localgdt_analysis_event.duration = paramLong;
    localgdt_analysis_event.cached = paramInt3;
    localgdt_analysis_event.phoneType = c.getPhoneType(paramContext);
    localgdt_analysis_event.errorCode1 = 0;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static AdAnalysisEvent createEventForDeviceIdentifierV2(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, paramInt1, localgdt_analysis_event);
    localgdt_analysis_event.internalErrorCode = paramInt2;
    localgdt_analysis_event.duration = paramInt3;
    localgdt_analysis_event.cached = paramInt4;
    localgdt_analysis_event.phoneType = c.getPhoneType(paramContext);
    localgdt_analysis_event.errorCode1 = 1;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static AdAnalysisEvent createEventForDeviceInfoEnd(Context paramContext, String paramString, long paramLong, int paramInt)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1037, localgdt_analysis_event);
    localgdt_analysis_event.businessId = paramString;
    localgdt_analysis_event.posId = paramString;
    localgdt_analysis_event.duration = paramLong;
    localgdt_analysis_event.errorCode1 = paramInt;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static AdAnalysisEvent createEventForIPV4(Context paramContext, String paramString, int paramInt)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1045, localgdt_analysis_event);
    localgdt_analysis_event.businessId = paramString;
    localgdt_analysis_event.posId = paramString;
    localgdt_analysis_event.internalErrorCode = paramInt;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  private static gdt_analysis_event createEventForLaunchAppWithDeepLink(Context paramContext, int paramInt, Ad paramAd, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static AdAnalysisEvent createEventForLocation(Context paramContext, String paramString, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1038, localgdt_analysis_event);
    localgdt_analysis_event.businessId = paramString;
    localgdt_analysis_event.posId = paramString;
    localgdt_analysis_event.internalErrorCode = (paramBoolean ^ true);
    localgdt_analysis_event.duration = paramLong1;
    if (paramBoolean) {
      localgdt_analysis_event.interval = paramLong2;
    }
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static AdAnalysisEvent createEventForTaidTicket(Context paramContext, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1050, localgdt_analysis_event);
    localgdt_analysis_event.businessId = paramString;
    localgdt_analysis_event.posId = paramString;
    localgdt_analysis_event.internalErrorCode = paramInt1;
    localgdt_analysis_event.errorCode1 = paramInt2;
    localgdt_analysis_event.duration = paramLong;
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  private static AdAnalysisEvent createEventForUUID(Context paramContext, int paramInt, r paramr, r.a parama)
  {
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, paramInt, localgdt_analysis_event);
    if (paramr == null) {
      localgdt_analysis_event.internalErrorCode = 16;
    } else if (!paramr.isValid(parama)) {
      localgdt_analysis_event.internalErrorCode = 4;
    } else {
      localgdt_analysis_event.internalErrorCode = 0;
    }
    return new AdAnalysisEvent(localgdt_analysis_event, 102);
  }
  
  public static void reportForAPIInvoked(Context paramContext, boolean paramBoolean, String paramString, Ad paramAd)
  {
    int i;
    if (paramBoolean) {
      i = 102;
    } else {
      i = 103;
    }
    paramAd = AdAnalysisHelper.createEventForAd(paramContext, 1051, paramAd);
    paramAd.api = paramString;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, i));
  }
  
  public static void reportForAPIInvoked(Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    Uri localUri = AdUriUtil.parse(paramString2);
    int i;
    if (paramBoolean) {
      i = 102;
    } else {
      i = 103;
    }
    paramString2 = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1051, paramString2);
    paramString2.api = paramString1;
    if (localUri != null) {
      paramString1 = AdUriUtil.getQueryParameter(localUri, "pid");
    } else {
      paramString1 = null;
    }
    paramString2.posId = paramString1;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramString2, i));
  }
  
  public static void reportForARKReceiveNotification(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, Ad paramAd)
  {
    int i;
    if (paramBoolean) {
      i = 102;
    } else {
      i = 103;
    }
    paramAd = AdAnalysisHelper.createEventForAd(paramContext, 1071, paramAd);
    paramAd.api = paramString1;
    paramAd.hostName = paramString2;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, i));
  }
  
  public static void reportForARKSendNotification(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, Ad paramAd)
  {
    int i;
    if (paramBoolean) {
      i = 102;
    } else {
      i = 103;
    }
    paramAd = AdAnalysisHelper.createEventForAd(paramContext, 1072, paramAd);
    paramAd.api = paramString1;
    paramAd.hostName = paramString2;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, i));
  }
  
  public static void reportForAppInstalled(AdClickUtil.Params paramParams)
  {
    Object localObject2 = null;
    Activity localActivity;
    if ((paramParams != null) && (paramParams.activity != null)) {
      localActivity = (Activity)paramParams.activity.get();
    } else {
      localActivity = null;
    }
    if (paramParams != null) {
      localObject1 = paramParams.ad;
    } else {
      localObject1 = null;
    }
    gdt_analysis_event localgdt_analysis_event = AdAnalysisHelper.createEventForAd(localActivity, 1062, (Ad)localObject1);
    Object localObject1 = localObject2;
    if (paramParams != null)
    {
      localObject1 = localObject2;
      if (paramParams.ad != null) {
        localObject1 = paramParams.ad.getAppPackageName();
      }
    }
    localgdt_analysis_event.androidPackageName = ((String)localObject1);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(localActivity), new AdAnalysisEvent(localgdt_analysis_event, 103));
  }
  
  public static void reportForAppPreOrderBackgroundTimeMillis(Context paramContext, long paramLong)
  {
    gdt_analysis_event localgdt_analysis_event = createEventForAppPreOrder(paramContext, 1207, null);
    localgdt_analysis_event.duration = paramLong;
    localgdt_analysis_event.androidCurrentProcessName = AdProcessManager.INSTANCE.getCurrentProcessName(paramContext);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, 102));
  }
  
  public static void reportForAppPreOrderCanStartDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void reportForAppPreOrderClicked(Context paramContext, String paramString, AdClickUtil.Result paramResult)
  {
    paramString = createEventForAppPreOrder(paramContext, 1205, paramString);
    int j = 1;
    int i;
    if (paramResult != null) {
      i = paramResult.getErrorCode();
    } else {
      i = 1;
    }
    paramString.internalErrorCode = i;
    if (paramResult != null) {
      i = paramResult.action;
    } else {
      i = 0;
    }
    paramString.actionId = i;
    if ((paramResult != null) && (paramResult.errorHandled)) {
      i = j;
    } else {
      i = 0;
    }
    paramString.errorHandled = i;
    if (paramResult != null) {
      i = paramResult.urlType;
    } else {
      i = -2147483648;
    }
    paramString.urlType = i;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramString, 103));
  }
  
  public static void reportForAppPreOrderTaskReportStageStatusChanged(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void reportForAppPreOrderTaskStatusChanged(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString, int paramInt3)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void reportForBanner(Context paramContext, Ad paramAd)
  {
    paramAd = AdAnalysisHelper.createEventForAd(paramContext, 1054, paramAd);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, 102));
  }
  
  public static void reportForClickEnd(AdClickUtil.Params paramParams, AdClickUtil.Result paramResult)
  {
    Ad localAd = null;
    Activity localActivity;
    if ((paramParams != null) && (paramParams.activity != null)) {
      localActivity = (Activity)paramParams.activity.get();
    } else {
      localActivity = null;
    }
    if (paramParams != null) {
      localAd = paramParams.ad;
    }
    paramParams = AdAnalysisHelper.createEventForAd(localActivity, 1017, localAd);
    int j = 1;
    int i;
    if (paramResult != null) {
      i = paramResult.getErrorCode();
    } else {
      i = 1;
    }
    paramParams.internalErrorCode = i;
    if (paramResult != null) {
      i = paramResult.action;
    } else {
      i = 0;
    }
    paramParams.actionId = i;
    if ((paramResult != null) && (paramResult.errorHandled)) {
      i = j;
    } else {
      i = 0;
    }
    paramParams.errorHandled = i;
    if (paramResult != null) {
      i = paramResult.urlType;
    } else {
      i = -2147483648;
    }
    paramParams.urlType = i;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(localActivity), new AdAnalysisEvent(paramParams, 103));
  }
  
  public static void reportForClickStart(AdClickUtil.Params paramParams)
  {
    Ad localAd = null;
    Activity localActivity;
    if ((paramParams != null) && (paramParams.activity != null)) {
      localActivity = (Activity)paramParams.activity.get();
    } else {
      localActivity = null;
    }
    if (paramParams != null) {
      localAd = paramParams.ad;
    }
    paramParams = AdAnalysisHelper.createEventForAd(localActivity, 1016, localAd);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(localActivity), new AdAnalysisEvent(paramParams, 103));
  }
  
  public static void reportForExposureApiInvoked(Context paramContext, Ad paramAd)
  {
    paramAd = AdAnalysisHelper.createEventForAd(paramContext, 1103, paramAd);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, 102));
  }
  
  public static void reportForExposureCallback(Context paramContext, Ad paramAd, int paramInt)
  {
    paramAd = AdAnalysisHelper.createEventForAd(paramContext, 1104, paramAd);
    paramAd.isSupplement = paramInt;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, 102));
  }
  
  public static void reportForGetIPV4End(Context paramContext, long paramLong, AdHttp.Params paramParams, String paramString, Throwable paramThrowable)
  {
    int i = 5;
    int k = -2147483648;
    if ((paramParams != null) && (paramParams.canSend()))
    {
      if (paramParams.responseCode == -2147483648) {
        i = 3;
      } else if (paramParams.responseCode == 200) {
        if (paramThrowable != null) {
          i = 11;
        } else if (!TextUtils.isEmpty(paramString)) {
          i = 0;
        }
      }
    }
    else {
      i = 4;
    }
    int j;
    if (i == 0) {
      j = 1047;
    } else {
      j = 1048;
    }
    paramString = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, j, paramString);
    paramString.carrierCode = AdCarrier.getCode(paramContext);
    paramString.netType = AdNet.getTypeWith5G(paramContext);
    paramString.networkType = AdNet.getNetworkType(paramContext);
    paramString.duration = paramLong;
    paramString.internalErrorCode = i;
    i = k;
    if (paramParams != null) {
      i = paramParams.responseCode;
    }
    paramString.httpErrorCode = i;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramString, 102));
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
    if (paramBoolean) {
      i = 102;
    } else {
      i = 103;
    }
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1052, localgdt_analysis_event);
    localgdt_analysis_event.api = paramString1;
    localgdt_analysis_event.url = paramString2;
    if (localUri != null) {
      paramString1 = localUri.getHost();
    } else {
      paramString1 = null;
    }
    localgdt_analysis_event.hostName = paramString1;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, i));
  }
  
  public static void reportForJSBridgeInvoked(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, Ad paramAd)
  {
    Uri localUri = AdUriUtil.parse(paramString2);
    int i;
    if (paramBoolean) {
      i = 102;
    } else {
      i = 103;
    }
    paramAd = AdAnalysisHelper.createEventForAd(paramContext, 1052, paramAd);
    paramAd.api = paramString1;
    paramAd.url = paramString2;
    if (localUri != null) {
      paramString1 = localUri.getHost();
    } else {
      paramString1 = null;
    }
    paramAd.hostName = paramString1;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, i));
  }
  
  public static void reportForJSBridgeInvoked(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, Ad paramAd, long paramLong)
  {
    Uri localUri = AdUriUtil.parse(paramString2);
    int i;
    if (paramBoolean) {
      i = 102;
    } else {
      i = 103;
    }
    paramAd = AdAnalysisHelper.createEventForAd(paramContext, 1052, paramAd);
    paramAd.api = paramString1;
    paramAd.url = paramString2;
    if (localUri != null) {
      paramString1 = localUri.getHost();
    } else {
      paramString1 = null;
    }
    paramAd.hostName = paramString1;
    paramAd.duration = paramLong;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, i));
  }
  
  public static void reportForJSBridgeInvoked(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    Uri localUri1 = AdUriUtil.parse(paramString2);
    Uri localUri2 = AdUriUtil.parse(paramString3);
    int i;
    if (paramBoolean) {
      i = 102;
    } else {
      i = 103;
    }
    paramString3 = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1052, paramString3);
    paramString3.api = paramString1;
    paramString3.url = paramString2;
    paramString2 = null;
    if (localUri2 != null) {
      paramString1 = AdUriUtil.getQueryParameter(localUri2, "pid");
    } else {
      paramString1 = null;
    }
    paramString3.posId = paramString1;
    paramString1 = paramString2;
    if (localUri1 != null) {
      paramString1 = localUri1.getHost();
    }
    paramString3.hostName = paramString1;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramString3, i));
  }
  
  public static void reportForLaunchAppMarket(AdClickUtil.Params paramParams, AdClickUtil.Result paramResult, String paramString)
  {
    Object localObject2 = null;
    Activity localActivity;
    if ((paramParams != null) && (paramParams.activity != null)) {
      localActivity = (Activity)paramParams.activity.get();
    } else {
      localActivity = null;
    }
    if (paramParams != null) {
      localObject1 = paramParams.ad;
    } else {
      localObject1 = null;
    }
    int i;
    if (paramResult != null) {
      i = paramResult.getErrorCode();
    } else {
      i = 1;
    }
    Object localObject1 = AdAnalysisHelper.createEventForAd(localActivity, 1061, (Ad)localObject1);
    ((gdt_analysis_event)localObject1).androidActivityName = paramString;
    if ((paramParams != null) && (paramParams.ad != null)) {
      paramResult = paramParams.ad.getAppMarketPackageName();
    } else {
      paramResult = null;
    }
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
  }
  
  public static void reportForLaunchAppWithDeepLinkEND(AdClickUtil.Params paramParams, AdClickUtil.Result paramResult, boolean paramBoolean)
  {
    Ad localAd = null;
    Activity localActivity;
    if ((paramParams != null) && (paramParams.activity != null)) {
      localActivity = (Activity)paramParams.activity.get();
    } else {
      localActivity = null;
    }
    if (paramParams != null) {
      localAd = paramParams.ad;
    }
    int i;
    if (paramResult != null) {
      i = paramResult.getErrorCode();
    } else {
      i = 1;
    }
    int j;
    if (i == 0) {
      j = 1004;
    } else {
      j = 1005;
    }
    paramParams = createEventForLaunchAppWithDeepLink(localActivity, j, localAd, paramBoolean);
    paramParams.internalErrorCode = i;
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(localActivity), new AdAnalysisEvent(paramParams, 103));
  }
  
  public static void reportForLaunchAppWithDeepLinkStart(AdClickUtil.Params paramParams, boolean paramBoolean)
  {
    Ad localAd = null;
    Activity localActivity;
    if ((paramParams != null) && (paramParams.activity != null)) {
      localActivity = (Activity)paramParams.activity.get();
    } else {
      localActivity = null;
    }
    if (paramParams != null) {
      localAd = paramParams.ad;
    }
    paramParams = createEventForLaunchAppWithDeepLink(localActivity, 1003, localAd, paramBoolean);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(localActivity), new AdAnalysisEvent(paramParams, 103));
  }
  
  public static void reportForLaunchQQMINIProgramEND(Context paramContext, Ad paramAd, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1014;
    } else {
      i = 1015;
    }
    paramAd = AdAnalysisHelper.createEventForAd(paramContext, i, paramAd);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, 103));
  }
  
  public static void reportForLaunchQQMINIProgramStart(Context paramContext, Ad paramAd)
  {
    paramAd = AdAnalysisHelper.createEventForAd(paramContext, 1013, paramAd);
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
    else
    {
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
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(localgdt_analysis_event, 102));
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
  
  public static void reportForPreload(Context paramContext, Ad paramAd)
  {
    paramAd = AdAnalysisHelper.createEventForAd(paramContext, 1105, paramAd);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, 102));
  }
  
  public static void reportForRewardedVideo(Context paramContext, Ad paramAd)
  {
    paramAd = AdAnalysisHelper.createEventForAd(paramContext, 1055, paramAd);
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), new AdAnalysisEvent(paramAd, 102));
  }
  
  public static void reportForUUID(Context paramContext, r paramr1, r paramr2, r.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(createEventForUUID(paramContext, 1126, paramr1, parama));
    localArrayList.add(createEventForUUID(paramContext, 1127, paramr2, parama));
    parama = new gdt_analysis_event();
    AdAnalysisUtil.initEvent(paramContext, 1128, parama);
    if ((paramr1 == null) && (paramr2 == null)) {
      parama.internalErrorCode = 0;
    } else if ((paramr1 != null) && (paramr2 != null))
    {
      if (paramr1.equals(paramr2)) {
        parama.internalErrorCode = 0;
      } else {
        parama.internalErrorCode = 1;
      }
    }
    else {
      parama.internalErrorCode = 1;
    }
    localArrayList.add(new AdAnalysisEvent(parama, 102));
    AdAnalysis.INSTANCE.handleAsync(new WeakReference(paramContext), localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil
 * JD-Core Version:    0.7.0.1
 */