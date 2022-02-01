package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.canvas.AdCanvas;
import com.tencent.ad.tangram.canvas.AdCanvasJsonManager;
import com.tencent.ad.tangram.halfScreen.AdHalfScreen;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.mini.AdQQMINIProgram;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.offline.AdOffline;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.statistics.AdReporterForClick;
import com.tencent.ad.tangram.statistics.b;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.videoceiling.AdVideoSplice;
import com.tencent.ad.tangram.web.AdBrowser;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import org.json.JSONObject;

@Keep
public final class AdClickUtil
{
  public static final int ACTION_APP = 5;
  public static final int ACTION_APP_MARKET = 8;
  public static final int ACTION_APP_WITH_DEEPLINK = 4;
  public static final int ACTION_CANVAS = 3;
  public static final int ACTION_HALF_SCREEN = 10;
  public static final int ACTION_INSTALL = 11;
  public static final int ACTION_QQ_MINI_PROGRAM = 6;
  public static final int ACTION_UNKNOWN = 0;
  public static final int ACTION_VIDEO_CEILING = 2;
  public static final int ACTION_VIDEO_SPLICE = 7;
  public static final int ACTION_WEB = 1;
  public static final int ACTION_WEIXIN_MINI_PROGRAM = 9;
  private static final String TAG = "AdClickUtil";
  
  private static String appendUrlWithAutoDownload(String paramString1, String paramString2, AdClickUtil.Params paramParams)
  {
    String str;
    if ((paramParams == null) || (!paramParams.isValid()) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AdLog.e("AdClickUtil", "appendUrlWithAutoDownload error");
      str = null;
    }
    Uri localUri;
    Uri.Builder localBuilder;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return str;
              str = paramString1;
            } while (!canAppAutoDownload(paramParams));
            localUri = AdUriUtil.parse(paramString1);
            str = paramString1;
          } while (localUri == null);
          localBuilder = localUri.buildUpon();
          str = paramString1;
        } while (localBuilder == null);
        str = paramString1;
      } while (!paramParams.ad.isAppProductType());
      if (paramParams.ad.isAppXiJingDefault()) {
        break;
      }
      str = paramString1;
    } while (!paramParams.ad.isAppXiJing());
    paramString1 = localBuilder;
    if (AdUriUtil.getQueryParameter(localUri, paramString2) == null) {
      paramString1 = localBuilder.appendQueryParameter(paramString2, "1");
    }
    return paramString1.toString();
  }
  
  private static boolean canAppAutoDownload(AdClickUtil.Params paramParams)
  {
    return (isValidForApp(paramParams)) && (paramParams.enableAutoDownload) && (AdNet.getType((Context)paramParams.activity.get()) == 1);
  }
  
  public static int getActionAboutApp(AdClickUtil.Params paramParams, int paramInt)
  {
    int i = 4;
    if ((paramParams == null) || (!paramParams.isValid())) {}
    do
    {
      do
      {
        return paramInt;
        if ((!paramParams.ad.isAppProductType()) || (!isValidForApp(paramParams))) {
          break;
        }
      } while (!AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName()));
      if (!TextUtils.isEmpty(paramParams.ad.getAppDeeplink())) {}
      for (paramInt = 4;; paramInt = 5) {
        return paramInt;
      }
    } while ((!isWebProductTypeDeeplinkSupported(paramParams)) || (TextUtils.isEmpty(paramParams.ad.getAppDeeplink())));
    AdAppDeeplinkLauncher.Params localParams = new AdAppDeeplinkLauncher.Params();
    localParams.deeplink = paramParams.ad.getAppDeeplink();
    localParams.addflags = 268435456;
    localParams.extrasForIntent = paramParams.extrasForIntent;
    paramParams = AdAppDeeplinkLauncher.canLaunch((Activity)paramParams.activity.get(), localParams);
    if (paramParams != null)
    {
      paramParams = paramParams.getError();
      if ((paramParams == null) || (!paramParams.isSuccess())) {
        break label191;
      }
      paramInt = i;
    }
    label191:
    for (;;)
    {
      return paramInt;
      paramParams = new AdError(1);
      break;
    }
  }
  
  private static AdClickUtil.a getBaseURLObject(AdClickUtil.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid())) {
      return null;
    }
    AdClickUtil.a locala = new AdClickUtil.a();
    if (!paramParams.reportForClick)
    {
      locala.url = appendUrlWithAutoDownload(replaceUrlWithClickLpp(paramParams.ad.getUrlForLandingPage()), "autodownload", paramParams);
      locala.type = 2;
      return locala;
    }
    locala.url = appendUrlWithAutoDownload(getUrlForClick(paramParams), "_autodownload", paramParams);
    locala.type = 1;
    return locala;
  }
  
  private static AdClickUtil.a getURLObject(AdClickUtil.Params paramParams)
  {
    Object localObject;
    if ((paramParams == null) || (!paramParams.isValid()))
    {
      localObject = null;
      return localObject;
    }
    AdClickUtil.a locala = new AdClickUtil.a();
    if ((!paramParams.ad.isAppXiJingOffline()) && (!paramParams.ad.isWebXiJingOffline())) {}
    for (;;)
    {
      localObject = locala;
      if (!TextUtils.isEmpty(locala.url)) {
        break;
      }
      return getBaseURLObject(paramParams);
      if (!TextUtils.isEmpty(AdOffline.INSTANCE.getVersionIfExistsFromMemory(paramParams.ad.getBusinessIdForXiJingOffline())))
      {
        localObject = AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramParams.ad, paramParams.ad.getJSONKeyForXiJingOffline(), true);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramParams.ad.setCanvasForXiJingOffline((String)localObject);
          locala.url = appendUrlWithAutoDownload(replaceUrlWithClickLpp(paramParams.ad.getUrlForXiJingOffline()), "autodownload", paramParams);
          locala.type = 3;
        }
      }
    }
  }
  
  public static String getUrlForClick(AdClickUtil.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()))
    {
      AdLog.e("AdClickUtil", "getUrlForClick error");
      return null;
    }
    Object localObject1 = paramParams.ad.getUrlForClick();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AdLog.e("AdClickUtil", "getUrlForClick error");
      return null;
    }
    localObject1 = replaceUrlWithClickLpp((String)localObject1);
    Uri localUri = AdUriUtil.parse((String)localObject1);
    if (localUri == null)
    {
      AdLog.e("AdClickUtil", "getUrlForClick error");
      return localObject1;
    }
    Object localObject3 = localUri.buildUpon();
    if (localObject3 == null)
    {
      AdLog.e("AdClickUtil", "getUrlForClick error");
      return localObject1;
    }
    if (AdUriUtil.getQueryParameter(localUri, "feeds_attachment") != null)
    {
      localObject1 = localObject3;
      if (AdUriUtil.getQueryParameter(localUri, "isfromqqb") == null) {
        break label244;
      }
      label113:
      localObject3 = localObject1;
      if (AdUriUtil.getQueryParameter(localUri, "s") == null) {
        if (!TextUtils.isEmpty(paramParams.antiSpamParams)) {
          break label257;
        }
      }
    }
    Object localObject2;
    label257:
    for (localObject3 = localObject1;; localObject3 = ((Uri.Builder)localObject2).appendQueryParameter("s", paramParams.antiSpamParams))
    {
      for (;;)
      {
        return ((Uri.Builder)localObject3).toString();
        try
        {
          JSONObject localJSONObject = new JSONObject();
          if (paramParams.sceneID != -2147483648) {
            localJSONObject.put("click_scene", String.valueOf(paramParams.sceneID));
          }
          if (paramParams.componentID != -2147483648) {
            localJSONObject.put("click_pos", String.valueOf(paramParams.componentID));
          }
          localObject1 = localObject3;
          if (localJSONObject.length() <= 0) {
            break;
          }
          localObject1 = ((Uri.Builder)localObject3).appendQueryParameter("feeds_attachment", localJSONObject.toString());
        }
        catch (Throwable localThrowable)
        {
          AdLog.e("AdClickUtil", "getUrlForClick", localThrowable);
          localObject2 = localObject3;
        }
      }
      break;
      label244:
      localObject2 = ((Uri.Builder)localObject2).appendQueryParameter("isfromqqb", "1");
      break label113;
    }
  }
  
  private static int getVideoCeilingStyle(AdClickUtil.Params paramParams)
  {
    int i = -2147483648;
    if ((paramParams != null) && (paramParams.isValid()) && (!TextUtils.isEmpty(paramParams.ad.getVideoUrl())) && (AdVideoCeiling.getAdapter() != null)) {}
    for (int j = 1; j == 0; j = 0)
    {
      j = i;
      return j;
    }
    j = getActionAboutApp(paramParams, 1);
    if (j == 4) {
      if (paramParams.videoCeilingSupportedIfInstalled) {
        i = 3;
      }
    }
    for (;;)
    {
      j = i;
      if (i != 1) {
        break;
      }
      j = i;
      if (!paramParams.ad.isCanvas()) {
        break;
      }
      return 4;
      if (j == 5)
      {
        if (paramParams.videoCeilingSupportedIfInstalled) {
          i = 2;
        }
      }
      else if (paramParams.videoCeilingSupportedIfNotInstalled) {
        i = 1;
      }
    }
  }
  
  public static AdClickUtil.Result handle(AdClickUtil.Params paramParams)
  {
    AdLog.i("AdClickUtil", "handle");
    AdReporterForAnalysis.reportForClickStart(paramParams);
    if ((paramParams == null) || (!paramParams.isValid()))
    {
      AdLog.e("AdClickUtil", "handle error");
      return new AdClickUtil.Result(4, 0);
    }
    boolean bool;
    AdClickUtil.Result localResult;
    if ((paramParams.enableAutoDownload) && (!paramParams.ad.disableAutoDownload()))
    {
      bool = true;
      paramParams.enableAutoDownload = bool;
      localResult = new AdClickUtil.Result(1, 0);
      if (!paramParams.ad.isQQMINIProgram()) {
        break label127;
      }
      localResult = handleQQMINIProgramType(paramParams);
    }
    label191:
    for (;;)
    {
      AdReporterForAnalysis.reportForClickEnd(paramParams, localResult);
      AdOffline.INSTANCE.reportOnClick((Context)paramParams.activity.get(), paramParams.ad, localResult);
      return localResult;
      bool = false;
      break;
      label127:
      if (paramParams.ad.isAppProductType()) {
        localResult = handleAppProductType(paramParams);
      }
      for (;;)
      {
        if ((localResult != null) && (localResult.isSuccess())) {
          break label191;
        }
        localResult = handleUrl(paramParams, getBaseURLObject(paramParams));
        if (localResult != null) {
          localResult.errorHandled = true;
        }
        break;
        if (isWebProductType(paramParams)) {
          localResult = handleWebProductType(paramParams);
        }
      }
    }
  }
  
  static AdClickUtil.Result handleApp(AdClickUtil.Params paramParams, boolean paramBoolean)
  {
    if ((!isValidForApp(paramParams)) || (!AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName())))
    {
      AdLog.e("AdClickUtil", "handleApp error");
      return new AdClickUtil.Result(4, 5);
    }
    AdError localAdError = AdAppUtil.launch((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName(), paramParams.extrasForIntent);
    if ((localAdError != null) && (localAdError.isSuccess()) && (paramParams.reportForClick) && (!paramBoolean)) {
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
    }
    return new AdClickUtil.Result(localAdError, 5);
  }
  
  private static void handleAppAfterInstalled(AdClickUtil.Params paramParams)
  {
    if (!isValidForApp(paramParams)) {
      AdLog.e("AdClickUtil", "handleAppAfterInstalled error");
    }
    while ((paramParams.ad.isAppPreOrder()) || (paramParams.ad.isAppXiJingFengling()) || (paramParams.appReceiver == null) || (paramParams.appReceiver.get() == null)) {
      return;
    }
    ((AdAppReceiver)paramParams.appReceiver.get()).observe(paramParams);
  }
  
  private static AdClickUtil.Result handleAppMarket(AdClickUtil.Params paramParams)
  {
    String str = null;
    if ((!isValidForApp(paramParams)) || (TextUtils.isEmpty(paramParams.ad.getAppMarketDeeplink())) || (TextUtils.isEmpty(paramParams.ad.getAppMarketPackageName()))) {
      localObject2 = new AdClickUtil.Result(4, 8);
    }
    for (Object localObject1 = null;; localObject1 = null)
    {
      AdLog.i("AdClickUtil", String.format("handleAppMarket errorCode:%d manufacturer:%s model:%s appMarketPackageName:%s appMarketDeeplink:%s", new Object[] { Integer.valueOf(((AdClickUtil.Result)localObject2).getErrorCode()), Build.MANUFACTURER, Build.MODEL, paramParams.ad.getAppMarketPackageName(), paramParams.ad.getAppMarketDeeplink() }));
      if ((localObject2 != null) && (((AdClickUtil.Result)localObject2).isSuccess()) && (paramParams.reportForClick)) {
        AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
      }
      if ((localObject2 != null) && (((AdClickUtil.Result)localObject2).isSuccess())) {
        b.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, 285);
      }
      if (localObject1 != null) {
        str = ((AdAppDeeplinkLauncher.Result)localObject1).getActivityName();
      }
      AdReporterForAnalysis.reportForLaunchAppMarket(paramParams, (AdClickUtil.Result)localObject2, str);
      return localObject2;
      if (AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppMarketPackageName())) {
        break;
      }
      localObject2 = new AdClickUtil.Result(12, 8);
    }
    localObject1 = new AdAppDeeplinkLauncher.Params();
    ((AdAppDeeplinkLauncher.Params)localObject1).deeplink = paramParams.ad.getAppMarketDeeplink();
    ((AdAppDeeplinkLauncher.Params)localObject1).packageName = paramParams.ad.getAppMarketPackageName();
    ((AdAppDeeplinkLauncher.Params)localObject1).extrasForIntent = paramParams.extrasForIntent;
    Object localObject2 = AdAppDeeplinkLauncher.launch((Activity)paramParams.activity.get(), (AdAppDeeplinkLauncher.Params)localObject1);
    if (localObject2 != null) {}
    for (localObject1 = ((AdAppDeeplinkLauncher.Result)localObject2).getError();; localObject1 = new AdError(1))
    {
      AdClickUtil.Result localResult = new AdClickUtil.Result((AdError)localObject1, 8);
      localObject1 = localObject2;
      localObject2 = localResult;
      break;
    }
  }
  
  private static AdClickUtil.Result handleAppProductType(AdClickUtil.Params paramParams)
  {
    if (!isValidForApp(paramParams))
    {
      AdLog.e("AdClickUtil", "handleAppProductType error");
      return new AdClickUtil.Result(4, 0);
    }
    if (paramParams.ad.isAppPreOrder())
    {
      AdLog.d("AdClickUtil", "handleAppProduct isAppPreOder:" + paramParams.ad.getDestType());
      return handleAppProductTypeIfNotInstalled(paramParams);
    }
    boolean bool = AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName());
    if ((paramParams.videoSpliceSupported) && (paramParams.ad.isVideoSplice()))
    {
      if (!bool) {
        handleAppAfterInstalled(paramParams);
      }
      return handleVideoSplice(paramParams);
    }
    AdLog.i("AdClickUtil", "handleAppProductType " + paramParams.ad.getAppPackageName() + " installed:" + bool);
    WeakReference localWeakReference = new WeakReference(paramParams.activity.get());
    Ad localAd = paramParams.ad;
    if (bool) {}
    for (int i = 247;; i = 248)
    {
      b.reportAsync(localWeakReference, localAd, i);
      if (!TextUtils.isEmpty(paramParams.ad.getAppDeeplink())) {
        b.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, 245);
      }
      if (!bool) {
        break;
      }
      return handleAppProductTypeIfInstalled(paramParams);
    }
    return handleAppProductTypeIfNotInstalled(paramParams);
  }
  
  private static AdClickUtil.Result handleAppProductTypeIfInstalled(AdClickUtil.Params paramParams)
  {
    Object localObject;
    if ((!isValidForApp(paramParams)) || (!AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName())))
    {
      AdLog.e("AdClickUtil", "handleAppProductTypeIfInstalled error");
      localObject = new AdClickUtil.Result(4, 0);
    }
    AdClickUtil.Result localResult;
    do
    {
      return localObject;
      AdLog.i("AdClickUtil", "handleAppProductTypeIfInstalled " + paramParams.ad.getAppPackageName());
      int i = getVideoCeilingStyle(paramParams);
      if (i != -2147483648) {
        return handleVideoCeiling(paramParams, i);
      }
      localResult = handleAppWithDeeplink(paramParams, false);
      if (localResult == null) {
        break;
      }
      localObject = localResult;
    } while (localResult.isSuccess());
    return handleApp(paramParams, false);
  }
  
  private static AdClickUtil.Result handleAppProductTypeIfNotInstalled(AdClickUtil.Params paramParams)
  {
    Object localObject;
    if ((!isValidForApp(paramParams)) || (AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName())))
    {
      AdLog.e("AdClickUtil", "handleAppProductTypeIfNotInstalled error");
      localObject = new AdClickUtil.Result(4, 0);
    }
    AdClickUtil.Result localResult;
    do
    {
      return localObject;
      int i = getVideoCeilingStyle(paramParams);
      if ((!paramParams.ad.isAppXiJingDefault()) && (!paramParams.ad.isAppXiJing()) && (!paramParams.ad.isAppXiJingFengling())) {
        break label166;
      }
      handleAppAfterInstalled(paramParams);
      if (i != -2147483648) {
        return handleVideoCeiling(paramParams, i);
      }
      localResult = handleAppMarket(paramParams);
      if (localResult == null) {
        break;
      }
      localObject = localResult;
    } while (localResult.isSuccess());
    if (paramParams.halfScreenPageEnabled) {
      return handleHalfScreenPage(paramParams);
    }
    if (paramParams.ad.isCanvas()) {
      return handleCanvas(paramParams);
    }
    return handleUrl(paramParams, getURLObject(paramParams));
    label166:
    AdLog.e("AdClickUtil", "handleAppProductTypeIfNotInstalled error");
    return new AdClickUtil.Result(4, 0);
  }
  
  static AdClickUtil.Result handleAppWithDeeplink(AdClickUtil.Params paramParams, boolean paramBoolean)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (TextUtils.isEmpty(paramParams.ad.getAppDeeplink())))
    {
      AdLog.e("AdClickUtil", "handleAppWithDeeplink error");
      return new AdClickUtil.Result(4, 4);
    }
    AdReporterForAnalysis.reportForLaunchAppWithDeepLinkStart(paramParams, paramBoolean);
    Object localObject = new AdAppDeeplinkLauncher.Params();
    ((AdAppDeeplinkLauncher.Params)localObject).deeplink = paramParams.ad.getAppDeeplink();
    ((AdAppDeeplinkLauncher.Params)localObject).extrasForIntent = paramParams.extrasForIntent;
    ((AdAppDeeplinkLauncher.Params)localObject).addflags = 268435456;
    localObject = AdAppDeeplinkLauncher.launch((Activity)paramParams.activity.get(), (AdAppDeeplinkLauncher.Params)localObject);
    if ((localObject != null) && (((AdAppDeeplinkLauncher.Result)localObject).isSuccess()) && (paramParams.reportForClick) && (!paramBoolean)) {
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
    }
    int i;
    if ((localObject != null) && (((AdAppDeeplinkLauncher.Result)localObject).isSuccess()))
    {
      b.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, 246);
      WeakReference localWeakReference = new WeakReference(paramParams.activity.get());
      Ad localAd = paramParams.ad;
      if (paramBoolean)
      {
        i = 295;
        b.reportAsync(localWeakReference, localAd, i);
      }
    }
    else
    {
      if (localObject == null) {
        break label253;
      }
    }
    label253:
    for (localObject = ((AdAppDeeplinkLauncher.Result)localObject).getError();; localObject = new AdError(1))
    {
      localObject = new AdClickUtil.Result((AdError)localObject, 4);
      AdReporterForAnalysis.reportForLaunchAppWithDeepLinkEND(paramParams, (AdClickUtil.Result)localObject, paramBoolean);
      return localObject;
      i = 290;
      break;
    }
  }
  
  private static AdClickUtil.Result handleCanvas(AdClickUtil.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!paramParams.ad.isCanvas()))
    {
      AdLog.e("AdClickUtil", "handleCanvas error");
      return new AdClickUtil.Result(4, 3);
    }
    AdError localAdError = AdCanvas.show(paramParams.activity, paramParams.ad, canAppAutoDownload(paramParams), paramParams.extrasForIntent);
    if ((localAdError != null) && (localAdError.isSuccess()) && (paramParams.reportForClick)) {
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
    }
    return new AdClickUtil.Result(localAdError, 3);
  }
  
  private static AdClickUtil.Result handleHalfScreenPage(AdClickUtil.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()))
    {
      AdLog.e("AdClickUtil", "handleHalfScreenPage error");
      return new AdClickUtil.Result(4, 10);
    }
    AdClickUtil.a locala = getURLObject(paramParams);
    if ((locala == null) || (!locala.isValid()))
    {
      AdLog.e("AdClickUtil", "handleHalfScreenPage error");
      return new AdClickUtil.Result(4, 10);
    }
    if (paramParams.ad.isCanvas())
    {
      i = 2;
      AdError localAdError2 = AdHalfScreen.show(paramParams.activity, paramParams.ad, canAppAutoDownload(paramParams), i, locala.url, paramParams.extrasForIntent);
      AdError localAdError1;
      if (localAdError2 != null)
      {
        localAdError1 = localAdError2;
        if (localAdError2.isSuccess()) {}
      }
      else
      {
        localAdError1 = AdHalfScreen.show(paramParams.activity, paramParams.ad, canAppAutoDownload(paramParams), 1, locala.url, paramParams.extrasForIntent);
        i = 1;
      }
      if ((paramParams.reportForClick) && (localAdError1 != null) && (localAdError1.isSuccess()) && ((locala.type != 1) || (i == 2))) {
        AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
      }
      paramParams = new AdClickUtil.Result(localAdError1, 10);
      if (locala == null) {
        break label240;
      }
    }
    label240:
    for (int i = locala.type;; i = 0)
    {
      paramParams.urlType = i;
      return paramParams;
      i = 1;
      break;
    }
  }
  
  private static AdClickUtil.Result handleQQMINIProgramType(AdClickUtil.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!paramParams.ad.isQQMINIProgram())) {
      return new AdClickUtil.Result(4, 0);
    }
    AdError localAdError = AdQQMINIProgram.show(new WeakReference(paramParams.activity.get()), paramParams.ad);
    if ((localAdError != null) && (localAdError.isSuccess()) && (paramParams.reportForClick)) {
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
    }
    return new AdClickUtil.Result(localAdError, 6);
  }
  
  private static AdClickUtil.Result handleUrl(AdClickUtil.Params paramParams, AdClickUtil.a parama)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (parama == null) || (!parama.isValid()))
    {
      AdLog.e("AdClickUtil", "handleUrl error");
      return new AdClickUtil.Result(4, 1);
    }
    if ((paramParams.reportForClick) && (parama.type != 1)) {
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
    }
    paramParams = new AdClickUtil.Result(AdBrowser.show(paramParams.activity, paramParams.ad, parama.url, paramParams.extrasForIntent), 1);
    paramParams.urlType = parama.type;
    return paramParams;
  }
  
  private static AdClickUtil.Result handleVideoCeiling(AdClickUtil.Params paramParams, int paramInt)
  {
    if (paramInt == -2147483648)
    {
      AdLog.e("AdClickUtil", "handleVideoCeiling error");
      return new AdClickUtil.Result(4, 2);
    }
    AdClickUtil.a locala = getURLObject(paramParams);
    if ((locala == null) || (!locala.isValid()))
    {
      AdLog.e("AdClickUtil", "handleVideoCeiling error");
      return new AdClickUtil.Result(4, 2);
    }
    AdError localAdError2 = AdVideoCeiling.show(paramParams.activity, paramParams.ad, locala.url, paramParams.ad.getVideoUrl(), paramInt, paramParams.videoPlayForced, false, paramParams.videoStartPositionMillis, paramParams.extrasForIntent, canAppAutoDownload(paramParams));
    AdError localAdError1;
    if (localAdError2 != null)
    {
      localAdError1 = localAdError2;
      if (localAdError2.isSuccess()) {}
    }
    else
    {
      localAdError1 = AdVideoCeiling.show(paramParams.activity, paramParams.ad, locala.url, paramParams.ad.getVideoUrl(), 1, paramParams.videoPlayForced, false, paramParams.videoStartPositionMillis, paramParams.extrasForIntent, canAppAutoDownload(paramParams));
      paramInt = 1;
    }
    if ((paramParams.reportForClick) && (localAdError1 != null) && (localAdError1.isSuccess()) && ((locala.type != 1) || (paramInt == 4)))
    {
      AdLog.e("AdClickUtil", "handleVideoCeiling click url:" + getUrlForClick(paramParams));
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
    }
    paramParams = new AdClickUtil.Result(localAdError1, 2);
    paramParams.urlType = locala.type;
    return paramParams;
  }
  
  private static AdClickUtil.Result handleVideoSplice(AdClickUtil.Params paramParams)
  {
    String str = null;
    int i = 1;
    int j = 0;
    if ((paramParams == null) || (!paramParams.isValid()) || (!paramParams.ad.isVideoSplice()))
    {
      AdLog.e("AdClickUtil", "handleVideoSplice error");
      return new AdClickUtil.Result(4, 7);
    }
    AdClickUtil.a locala;
    if ((TextUtils.isEmpty(paramParams.ad.getVideoUrl2())) && (paramParams.ad.getCreativeSize() == 585))
    {
      if (!paramParams.reportForClick) {
        break label284;
      }
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
      locala = null;
    }
    for (;;)
    {
      WeakReference localWeakReference = paramParams.activity;
      Ad localAd = paramParams.ad;
      if (locala != null) {
        str = locala.url;
      }
      paramParams = new AdClickUtil.Result(AdVideoSplice.show(localWeakReference, localAd, str, paramParams.ad.getVideoUrl2(), paramParams.mediaViewLocationRect, i, paramParams.videoPlayForced, false, paramParams.extrasForIntent), 7);
      i = j;
      if (locala != null) {
        i = locala.type;
      }
      paramParams.urlType = i;
      return paramParams;
      if ((!TextUtils.isEmpty(paramParams.ad.getVideoUrl2())) && (paramParams.ad.getCreativeSize() == 930))
      {
        locala = getURLObject(paramParams);
        if ((paramParams.reportForClick) && (locala.type != 1)) {
          AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
        }
        i = 0;
      }
      else
      {
        locala = null;
        i = -2147483648;
        continue;
        label284:
        locala = null;
      }
    }
  }
  
  private static AdClickUtil.Result handleWebProductType(AdClickUtil.Params paramParams)
  {
    Object localObject;
    if ((paramParams == null) || (!isWebProductType(paramParams)) || ((paramParams.ad.getDestType() != 0) && (paramParams.ad.getDestType() != 4) && (paramParams.ad.getDestType() != 7)))
    {
      AdLog.e("AdClickUtil", "handleWebProductType error");
      localObject = new AdClickUtil.Result(4, 0);
    }
    int i;
    AdClickUtil.Result localResult;
    do
    {
      return localObject;
      if ((paramParams.videoSpliceSupported) && (paramParams.ad.isVideoSplice())) {
        return handleVideoSplice(paramParams);
      }
      i = getVideoCeilingStyle(paramParams);
      if ((!isWebProductTypeDeeplinkSupported(paramParams)) || (TextUtils.isEmpty(paramParams.ad.getAppDeeplink()))) {
        break label198;
      }
      b.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, 245);
      if (i != -2147483648) {
        return handleVideoCeiling(paramParams, i);
      }
      localResult = handleAppWithDeeplink(paramParams, false);
      if (localResult == null) {
        break;
      }
      localObject = localResult;
    } while (localResult.isSuccess());
    if (paramParams.halfScreenPageEnabled) {
      return handleHalfScreenPage(paramParams);
    }
    return handleUrl(paramParams, getURLObject(paramParams));
    label198:
    if (i != -2147483648) {
      return handleVideoCeiling(paramParams, i);
    }
    if (paramParams.halfScreenPageEnabled) {
      return handleHalfScreenPage(paramParams);
    }
    return handleUrl(paramParams, getURLObject(paramParams));
  }
  
  public static boolean isValidForApp(AdClickUtil.Params paramParams)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramParams != null)
    {
      bool1 = bool2;
      if (paramParams.isValid())
      {
        if (paramParams.ad.isAppProductType()) {
          break label37;
        }
        bool1 = bool2;
      }
    }
    bool2 = bool1;
    label37:
    label114:
    do
    {
      return bool2;
      if ((TextUtils.isEmpty(paramParams.ad.getProductId())) || (TextUtils.isEmpty(paramParams.ad.getVia())) || (TextUtils.isEmpty(paramParams.ad.getAppName())) || (TextUtils.isEmpty(paramParams.ad.getAppId())) || (TextUtils.isEmpty(paramParams.ad.getAppPackageName()))) {
        break;
      }
      bool1 = true;
      bool2 = bool1;
    } while (paramParams.ad.isAppPreOrder());
    if ((bool1) && (!TextUtils.isEmpty(paramParams.ad.getAppPackageUrl()))) {}
    for (bool1 = bool3;; bool1 = false)
    {
      break;
      bool1 = false;
      break label114;
    }
  }
  
  private static boolean isWebProductType(AdClickUtil.Params paramParams)
  {
    return (paramParams != null) && ((isWebProductTypeDeeplinkSupported(paramParams)) || (paramParams.ad.getProductType() == 30));
  }
  
  private static boolean isWebProductTypeDeeplinkSupported(AdClickUtil.Params paramParams)
  {
    return (paramParams != null) && ((paramParams.ad.getProductType() == 25) || (paramParams.ad.getProductType() == 26) || (paramParams.ad.getProductType() == 37) || (paramParams.ad.getProductType() == 41) || (paramParams.ad.getProductType() == 1000));
  }
  
  private static String replaceUrlWithClickLpp(String paramString)
  {
    int j = 0;
    if (!paramString.contains("__CLICK_LPP__")) {
      return paramString;
    }
    Object localObject = AdProcessManager.INSTANCE.isWebProcessRunning();
    int i;
    if (localObject != null) {
      if (((Boolean)localObject).booleanValue()) {
        i = 0;
      }
    }
    for (;;)
    {
      label37:
      localObject = AdProcessManager.INSTANCE.isWebProcessRunningForPreloading();
      if (localObject != null) {
        if (!((Boolean)localObject).booleanValue()) {}
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("click_time", System.currentTimeMillis());
          ((JSONObject)localObject).put("toolsalive", i);
          ((JSONObject)localObject).put("preload", j);
          localObject = ((JSONObject)localObject).toString();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          localObject = URLEncoder.encode((String)localObject, "UTF-8");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          localObject = paramString.replaceAll("__CLICK_LPP__", (String)localObject);
          boolean bool = TextUtils.isEmpty((CharSequence)localObject);
          if (bool) {
            break;
          }
          return localObject;
        }
        catch (Throwable localThrowable)
        {
          AdLog.e("AdClickUtil", "getUrlForClick", localThrowable);
          return paramString;
        }
        i = 1;
        break label37;
        j = 1;
        continue;
        j = 2;
      }
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdClickUtil
 * JD-Core Version:    0.7.0.1
 */