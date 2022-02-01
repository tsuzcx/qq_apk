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
import com.tencent.ad.tangram.halfScreen.AdHalfScreen;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.mini.AdQQMINIProgram;
import com.tencent.ad.tangram.net.AdNet;
import com.tencent.ad.tangram.offline.AdOffline;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.statistics.AdReporterForClick;
import com.tencent.ad.tangram.statistics.c;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.videoceiling.AdVideoSplice;
import com.tencent.ad.tangram.views.canvas.AdCanvas;
import com.tencent.ad.tangram.views.canvas.AdCanvasJsonManager;
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
    if ((paramParams != null) && (paramParams.isValid()) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!canAppAutoDownload(paramParams)) {
        return paramString1;
      }
      Uri localUri = AdUriUtil.parse(paramString1);
      if (localUri == null) {
        return paramString1;
      }
      Uri.Builder localBuilder = localUri.buildUpon();
      if (localBuilder == null) {
        return paramString1;
      }
      String str = paramString1;
      if (paramParams.ad.isAppProductType()) {
        if (!paramParams.ad.isAppXiJingDefault())
        {
          str = paramString1;
          if (!paramParams.ad.isAppXiJing()) {}
        }
        else
        {
          paramString1 = localBuilder;
          if (AdUriUtil.getQueryParameter(localUri, paramString2) == null) {
            paramString1 = localBuilder.appendQueryParameter(paramString2, "1");
          }
          str = paramString1.toString();
        }
      }
      return str;
    }
    AdLog.e("AdClickUtil", "appendUrlWithAutoDownload error");
    return null;
  }
  
  private static boolean canAppAutoDownload(AdClickUtil.Params paramParams)
  {
    return (isValidForApp(paramParams)) && (paramParams.enableAutoDownload) && (AdNet.getType((Context)paramParams.activity.get()) == 1);
  }
  
  public static int getActionAboutApp(AdClickUtil.Params paramParams, int paramInt)
  {
    int i = paramInt;
    if (paramParams != null)
    {
      if (!paramParams.isValid()) {
        return paramInt;
      }
      if ((paramParams.ad.isAppProductType()) && (isValidForApp(paramParams)))
      {
        if (AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName()))
        {
          if (!TextUtils.isEmpty(paramParams.ad.getAppDeeplink())) {
            return 4;
          }
          return 5;
        }
        return paramInt;
      }
      i = paramInt;
      if (isWebProductTypeDeeplinkSupported(paramParams))
      {
        i = paramInt;
        if (!TextUtils.isEmpty(paramParams.ad.getAppDeeplink()))
        {
          AdAppDeeplinkLauncher.Params localParams = new AdAppDeeplinkLauncher.Params();
          localParams.deeplink = paramParams.ad.getAppDeeplink();
          localParams.addflags = 268435456;
          localParams.extrasForIntent = paramParams.extrasForIntent;
          paramParams = AdAppDeeplinkLauncher.canLaunch((Activity)paramParams.activity.get(), localParams);
          if (paramParams != null) {
            paramParams = paramParams.getError();
          } else {
            paramParams = new AdError(1);
          }
          i = paramInt;
          if (paramParams != null)
          {
            i = paramInt;
            if (paramParams.isSuccess()) {
              i = 4;
            }
          }
        }
      }
    }
    return i;
  }
  
  private static AdClickUtil.a getBaseURLObject(AdClickUtil.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()))
    {
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
    return null;
  }
  
  private static AdClickUtil.a getURLObject(AdClickUtil.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()))
    {
      AdClickUtil.a locala = new AdClickUtil.a();
      if (((paramParams.ad.isAppXiJingOffline()) || (paramParams.ad.isWebXiJingOffline())) && (!TextUtils.isEmpty(AdOffline.INSTANCE.getVersionIfExistsFromMemory(paramParams.ad.getBusinessIdForXiJingOffline()))))
      {
        localObject = AdCanvasJsonManager.getInstance().getCachedCanvasJson(paramParams.ad, paramParams.ad.getJSONKeyForXiJingOffline(), true);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramParams.ad.setCanvasForXiJingOffline((String)localObject);
          locala.url = appendUrlWithAutoDownload(replaceUrlWithClickLpp(paramParams.ad.getUrlForXiJingOffline()), "autodownload", paramParams);
          locala.type = 3;
        }
      }
      Object localObject = locala;
      if (TextUtils.isEmpty(locala.url)) {
        localObject = getBaseURLObject(paramParams);
      }
      return localObject;
    }
    return null;
  }
  
  public static String getUrlForClick(AdClickUtil.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()))
    {
      Object localObject1 = paramParams.ad.getUrlForClick();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        AdLog.e("AdClickUtil", "getUrlForClick error");
        return null;
      }
      Object localObject2 = replaceUrlWithClickLpp((String)localObject1);
      Uri localUri = AdUriUtil.parse((String)localObject2);
      if (localUri == null)
      {
        AdLog.e("AdClickUtil", "getUrlForClick error");
        return localObject2;
      }
      localObject1 = localUri.buildUpon();
      if (localObject1 == null)
      {
        AdLog.e("AdClickUtil", "getUrlForClick error");
        return localObject2;
      }
      if (AdUriUtil.getQueryParameter(localUri, "feeds_attachment") == null) {
        try
        {
          localObject2 = new JSONObject();
          if (paramParams.sceneID != -2147483648) {
            ((JSONObject)localObject2).put("click_scene", String.valueOf(paramParams.sceneID));
          }
          if (paramParams.componentID != -2147483648) {
            ((JSONObject)localObject2).put("click_pos", String.valueOf(paramParams.componentID));
          }
          if (((JSONObject)localObject2).length() > 0)
          {
            localObject2 = ((Uri.Builder)localObject1).appendQueryParameter("feeds_attachment", ((JSONObject)localObject2).toString());
            localObject1 = localObject2;
          }
        }
        catch (Throwable localThrowable)
        {
          AdLog.e("AdClickUtil", "getUrlForClick", localThrowable);
        }
      }
      if (AdUriUtil.getQueryParameter(localUri, "isfromqqb") == null) {
        localObject1 = ((Uri.Builder)localObject1).appendQueryParameter("isfromqqb", "1");
      }
      Object localObject3 = localObject1;
      if (AdUriUtil.getQueryParameter(localUri, "s") == null) {
        if (TextUtils.isEmpty(paramParams.antiSpamParams)) {
          localObject3 = localObject1;
        } else {
          localObject3 = ((Uri.Builder)localObject1).appendQueryParameter("s", paramParams.antiSpamParams);
        }
      }
      return ((Uri.Builder)localObject3).toString();
    }
    AdLog.e("AdClickUtil", "getUrlForClick error");
    return null;
  }
  
  private static int getVideoCeilingStyle(AdClickUtil.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()) && (!TextUtils.isEmpty(paramParams.ad.getVideoUrl())) && (AdVideoCeiling.getAdapter() != null) && (!paramParams.ad.isVideoOnTopDisabled())) {
      i = 1;
    } else {
      i = 0;
    }
    int j = -2147483648;
    if (i == 0) {
      return -2147483648;
    }
    int i = getActionAboutApp(paramParams, 1);
    if (i == 4)
    {
      i = j;
      if (paramParams.videoCeilingSupportedIfInstalled) {
        i = 3;
      }
    }
    else if (i == 5)
    {
      i = j;
      if (paramParams.videoCeilingSupportedIfInstalled) {
        i = 2;
      }
    }
    else
    {
      i = j;
      if (paramParams.videoCeilingSupportedIfNotInstalled) {
        i = 1;
      }
    }
    j = i;
    if (i == 1)
    {
      j = i;
      if (paramParams.ad.isCanvas()) {
        j = 4;
      }
    }
    return j;
  }
  
  public static AdClickUtil.Result handle(AdClickUtil.Params paramParams)
  {
    AdLog.i("AdClickUtil", "handle");
    AdAnalysisHelperForUtil.reportForClickStart(paramParams);
    if ((paramParams != null) && (paramParams.isValid()))
    {
      boolean bool;
      if ((paramParams.enableAutoDownload) && (!paramParams.ad.disableAutoDownload())) {
        bool = true;
      } else {
        bool = false;
      }
      paramParams.enableAutoDownload = bool;
      AdClickUtil.Result localResult1 = new AdClickUtil.Result(1, 0);
      AdClickUtil.Result localResult2;
      if (paramParams.ad.isQQMINIProgram())
      {
        localResult2 = handleQQMINIProgramType(paramParams);
      }
      else
      {
        if (paramParams.ad.isAppProductType()) {
          localResult1 = handleAppProductType(paramParams);
        } else if (isWebProductType(paramParams)) {
          localResult1 = handleWebProductType(paramParams);
        }
        if (localResult1 != null)
        {
          localResult2 = localResult1;
          if (localResult1.isSuccess()) {}
        }
        else
        {
          localResult1 = handleUrl(paramParams, getBaseURLObject(paramParams));
          localResult2 = localResult1;
          if (localResult1 != null)
          {
            localResult1.errorHandled = true;
            localResult2 = localResult1;
          }
        }
      }
      AdAnalysisHelperForUtil.reportForClickEnd(paramParams, localResult2);
      AdOffline.INSTANCE.reportOnClick((Context)paramParams.activity.get(), paramParams.ad, localResult2);
      return localResult2;
    }
    AdLog.e("AdClickUtil", "handle error");
    return new AdClickUtil.Result(4, 0);
  }
  
  static AdClickUtil.Result handleApp(AdClickUtil.Params paramParams, boolean paramBoolean)
  {
    if ((isValidForApp(paramParams)) && (AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName())))
    {
      AdError localAdError = AdAppUtil.launch((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName(), paramParams.extrasForIntent);
      if ((localAdError != null) && (localAdError.isSuccess()) && (paramParams.reportForClick) && (!paramBoolean)) {
        AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
      }
      return new AdClickUtil.Result(localAdError, 5);
    }
    AdLog.e("AdClickUtil", "handleApp error");
    return new AdClickUtil.Result(4, 5);
  }
  
  private static void handleAppAfterInstalled(AdClickUtil.Params paramParams)
  {
    if (!isValidForApp(paramParams))
    {
      AdLog.e("AdClickUtil", "handleAppAfterInstalled error");
      return;
    }
    if (!paramParams.ad.isAppPreOrder())
    {
      if (paramParams.ad.isAppXiJingFengling()) {
        return;
      }
      if ((paramParams.appReceiver != null) && (paramParams.appReceiver.get() != null)) {
        ((AdAppReceiver)paramParams.appReceiver.get()).observe(paramParams);
      }
    }
  }
  
  private static AdClickUtil.Result handleAppMarket(AdClickUtil.Params paramParams)
  {
    boolean bool = isValidForApp(paramParams);
    String str = null;
    Object localObject;
    if ((bool) && (!TextUtils.isEmpty(paramParams.ad.getAppMarketDeeplink())) && (!TextUtils.isEmpty(paramParams.ad.getAppMarketPackageName())))
    {
      if (!AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppMarketPackageName()))
      {
        localObject = new AdClickUtil.Result(12, 8);
      }
      else
      {
        localObject = new AdAppDeeplinkLauncher.Params();
        ((AdAppDeeplinkLauncher.Params)localObject).deeplink = paramParams.ad.getAppMarketDeeplink();
        ((AdAppDeeplinkLauncher.Params)localObject).packageName = paramParams.ad.getAppMarketPackageName();
        ((AdAppDeeplinkLauncher.Params)localObject).extrasForIntent = paramParams.extrasForIntent;
        localResult = AdAppDeeplinkLauncher.launch((Activity)paramParams.activity.get(), (AdAppDeeplinkLauncher.Params)localObject);
        if (localResult != null) {
          localObject = localResult.getError();
        } else {
          localObject = new AdError(1);
        }
        localObject = new AdClickUtil.Result((AdError)localObject, 8);
        break label190;
      }
    }
    else {
      localObject = new AdClickUtil.Result(4, 8);
    }
    AdAppDeeplinkLauncher.Result localResult = null;
    label190:
    AdLog.i("AdClickUtil", String.format("handleAppMarket errorCode:%d manufacturer:%s model:%s appMarketPackageName:%s appMarketDeeplink:%s", new Object[] { Integer.valueOf(((AdClickUtil.Result)localObject).getErrorCode()), Build.MANUFACTURER, Build.MODEL, paramParams.ad.getAppMarketPackageName(), paramParams.ad.getAppMarketDeeplink() }));
    if ((((AdClickUtil.Result)localObject).isSuccess()) && (paramParams.reportForClick)) {
      AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
    }
    if (((AdClickUtil.Result)localObject).isSuccess()) {
      c.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, 285);
    }
    if (localResult != null) {
      str = localResult.getActivityName();
    }
    AdAnalysisHelperForUtil.reportForLaunchAppMarket(paramParams, (AdClickUtil.Result)localObject, str);
    return localObject;
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleAppProduct isAppPreOder:");
      ((StringBuilder)localObject).append(paramParams.ad.getDestType());
      AdLog.d("AdClickUtil", ((StringBuilder)localObject).toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleAppProductType ");
    ((StringBuilder)localObject).append(paramParams.ad.getAppPackageName());
    ((StringBuilder)localObject).append(" installed:");
    ((StringBuilder)localObject).append(bool);
    AdLog.i("AdClickUtil", ((StringBuilder)localObject).toString());
    localObject = new WeakReference(paramParams.activity.get());
    Ad localAd = paramParams.ad;
    int i;
    if (bool) {
      i = 247;
    } else {
      i = 248;
    }
    c.reportAsync((WeakReference)localObject, localAd, i);
    if (!TextUtils.isEmpty(paramParams.ad.getAppDeeplink())) {
      c.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, 245);
    }
    if (bool) {
      return handleAppProductTypeIfInstalled(paramParams);
    }
    return handleAppProductTypeIfNotInstalled(paramParams);
  }
  
  private static AdClickUtil.Result handleAppProductTypeIfInstalled(AdClickUtil.Params paramParams)
  {
    if ((isValidForApp(paramParams)) && (AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName())))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleAppProductTypeIfInstalled ");
      ((StringBuilder)localObject).append(paramParams.ad.getAppPackageName());
      AdLog.i("AdClickUtil", ((StringBuilder)localObject).toString());
      int i = getVideoCeilingStyle(paramParams);
      if (i != -2147483648) {
        return handleVideoCeiling(paramParams, i);
      }
      localObject = handleAppWithDeeplink(paramParams, false);
      if ((localObject != null) && (((AdClickUtil.Result)localObject).isSuccess())) {
        return localObject;
      }
      return handleApp(paramParams, false);
    }
    AdLog.e("AdClickUtil", "handleAppProductTypeIfInstalled error");
    return new AdClickUtil.Result(4, 0);
  }
  
  private static AdClickUtil.Result handleAppProductTypeIfNotInstalled(AdClickUtil.Params paramParams)
  {
    if ((isValidForApp(paramParams)) && (!AdAppUtil.isInstalled((Context)paramParams.activity.get(), paramParams.ad.getAppPackageName())))
    {
      int i = getVideoCeilingStyle(paramParams);
      if ((!paramParams.ad.isAppXiJingDefault()) && (!paramParams.ad.isAppXiJing()) && (!paramParams.ad.isAppXiJingFengling()))
      {
        AdLog.e("AdClickUtil", "handleAppProductTypeIfNotInstalled error");
        return new AdClickUtil.Result(4, 0);
      }
      handleAppAfterInstalled(paramParams);
      if (i != -2147483648) {
        return handleVideoCeiling(paramParams, i);
      }
      AdClickUtil.Result localResult = handleAppMarket(paramParams);
      if ((localResult != null) && (localResult.isSuccess())) {
        return localResult;
      }
      if (paramParams.halfScreenPageEnabled) {
        return handleHalfScreenPage(paramParams);
      }
      if (paramParams.ad.isCanvas()) {
        return handleCanvas(paramParams);
      }
      return handleUrl(paramParams, getURLObject(paramParams));
    }
    AdLog.e("AdClickUtil", "handleAppProductTypeIfNotInstalled error");
    return new AdClickUtil.Result(4, 0);
  }
  
  static AdClickUtil.Result handleAppWithDeeplink(AdClickUtil.Params paramParams, boolean paramBoolean)
  {
    if ((paramParams != null) && (paramParams.isValid()) && (!TextUtils.isEmpty(paramParams.ad.getAppDeeplink())))
    {
      AdAnalysisHelperForUtil.reportForLaunchAppWithDeepLinkStart(paramParams, paramBoolean);
      Object localObject = new AdAppDeeplinkLauncher.Params();
      ((AdAppDeeplinkLauncher.Params)localObject).deeplink = paramParams.ad.getAppDeeplink();
      ((AdAppDeeplinkLauncher.Params)localObject).extrasForIntent = paramParams.extrasForIntent;
      ((AdAppDeeplinkLauncher.Params)localObject).addflags = 268435456;
      localObject = AdAppDeeplinkLauncher.launch((Activity)paramParams.activity.get(), (AdAppDeeplinkLauncher.Params)localObject);
      if ((localObject != null) && (((AdAppDeeplinkLauncher.Result)localObject).isSuccess()) && (paramParams.reportForClick) && (!paramBoolean)) {
        AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
      }
      if ((localObject != null) && (((AdAppDeeplinkLauncher.Result)localObject).isSuccess()))
      {
        c.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, 246);
        WeakReference localWeakReference = new WeakReference(paramParams.activity.get());
        Ad localAd = paramParams.ad;
        int i;
        if (paramBoolean) {
          i = 295;
        } else {
          i = 290;
        }
        c.reportAsync(localWeakReference, localAd, i);
      }
      if (localObject != null) {
        localObject = ((AdAppDeeplinkLauncher.Result)localObject).getError();
      } else {
        localObject = new AdError(1);
      }
      localObject = new AdClickUtil.Result((AdError)localObject, 4);
      AdAnalysisHelperForUtil.reportForLaunchAppWithDeepLinkEND(paramParams, (AdClickUtil.Result)localObject, paramBoolean);
      return localObject;
    }
    AdLog.e("AdClickUtil", "handleAppWithDeeplink error");
    return new AdClickUtil.Result(4, 4);
  }
  
  private static AdClickUtil.Result handleCanvas(AdClickUtil.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()) && (paramParams.ad.isCanvas()))
    {
      AdError localAdError = AdCanvas.show(paramParams.activity, paramParams.ad, canAppAutoDownload(paramParams), paramParams.extrasForIntent);
      if ((localAdError != null) && (localAdError.isSuccess()) && (paramParams.reportForClick)) {
        AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
      }
      return new AdClickUtil.Result(localAdError, 3);
    }
    AdLog.e("AdClickUtil", "handleCanvas error");
    return new AdClickUtil.Result(4, 3);
  }
  
  private static AdClickUtil.Result handleHalfScreenPage(AdClickUtil.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()))
    {
      AdClickUtil.a locala = getURLObject(paramParams);
      if ((locala != null) && (locala.isValid()))
      {
        int i;
        if (paramParams.ad.isCanvas()) {
          i = 2;
        } else {
          i = 1;
        }
        AdError localAdError2 = AdHalfScreen.show(paramParams.activity, paramParams.ad, canAppAutoDownload(paramParams), i, locala.url, paramParams.extrasForIntent);
        AdError localAdError1;
        if (localAdError2 != null)
        {
          localAdError1 = localAdError2;
          if (localAdError2.isSuccess()) {}
        }
        else
        {
          i = 1;
          localAdError1 = AdHalfScreen.show(paramParams.activity, paramParams.ad, canAppAutoDownload(paramParams), 1, locala.url, paramParams.extrasForIntent);
        }
        if ((paramParams.reportForClick) && (localAdError1 != null) && (localAdError1.isSuccess()) && ((locala.type != 1) || (i == 2))) {
          AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
        }
        paramParams = new AdClickUtil.Result(localAdError1, 10);
        if (locala != null) {
          i = locala.type;
        } else {
          i = 0;
        }
        paramParams.urlType = i;
        return paramParams;
      }
      AdLog.e("AdClickUtil", "handleHalfScreenPage error");
      return new AdClickUtil.Result(4, 10);
    }
    AdLog.e("AdClickUtil", "handleHalfScreenPage error");
    return new AdClickUtil.Result(4, 10);
  }
  
  private static AdClickUtil.Result handleQQMINIProgramType(AdClickUtil.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()) && (paramParams.ad.isQQMINIProgram()))
    {
      AdError localAdError = AdQQMINIProgram.show(new WeakReference(paramParams.activity.get()), paramParams.ad);
      if ((localAdError != null) && (localAdError.isSuccess()) && (paramParams.reportForClick)) {
        AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
      }
      return new AdClickUtil.Result(localAdError, 6);
    }
    return new AdClickUtil.Result(4, 0);
  }
  
  private static AdClickUtil.Result handleUrl(AdClickUtil.Params paramParams, AdClickUtil.a parama)
  {
    if ((paramParams != null) && (paramParams.isValid()) && (parama != null) && (parama.isValid()))
    {
      if ((paramParams.reportForClick) && (parama.type != 1)) {
        AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
      }
      paramParams = new AdClickUtil.Result(AdBrowser.show(paramParams.activity, paramParams.ad, parama.url, paramParams.extrasForIntent), 1);
      paramParams.urlType = parama.type;
      return paramParams;
    }
    AdLog.e("AdClickUtil", "handleUrl error");
    return new AdClickUtil.Result(4, 1);
  }
  
  private static AdClickUtil.Result handleVideoCeiling(AdClickUtil.Params paramParams, int paramInt)
  {
    if (paramInt == -2147483648)
    {
      AdLog.e("AdClickUtil", "handleVideoCeiling error");
      return new AdClickUtil.Result(4, 2);
    }
    AdClickUtil.a locala = getURLObject(paramParams);
    if ((locala != null) && (locala.isValid()))
    {
      AdError localAdError = AdVideoCeiling.show(paramParams.activity, paramParams.ad, locala.url, paramParams.ad.getVideoUrl(), paramInt, paramParams.videoPlayForced, false, paramParams.videoStartPositionMillis, paramParams.extrasForIntent, canAppAutoDownload(paramParams));
      if ((localAdError != null) && (localAdError.isSuccess())) {
        break label149;
      }
      localAdError = AdVideoCeiling.show(paramParams.activity, paramParams.ad, locala.url, paramParams.ad.getVideoUrl(), 1, paramParams.videoPlayForced, false, paramParams.videoStartPositionMillis, paramParams.extrasForIntent, canAppAutoDownload(paramParams));
      paramInt = 1;
      label149:
      if ((paramParams.reportForClick) && (localAdError != null) && (localAdError.isSuccess()) && ((locala.type != 1) || (paramInt == 4)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleVideoCeiling click url:");
        localStringBuilder.append(getUrlForClick(paramParams));
        AdLog.e("AdClickUtil", localStringBuilder.toString());
        AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
      }
      paramParams = new AdClickUtil.Result(localAdError, 2);
      paramParams.urlType = locala.type;
      return paramParams;
    }
    AdLog.e("AdClickUtil", "handleVideoCeiling error");
    return new AdClickUtil.Result(4, 2);
  }
  
  private static AdClickUtil.Result handleVideoSplice(AdClickUtil.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()) && (paramParams.ad.isVideoSplice()))
    {
      boolean bool = TextUtils.isEmpty(paramParams.ad.getVideoUrl2());
      int j = 0;
      String str = null;
      AdClickUtil.a locala;
      if ((bool) && (paramParams.ad.getCreativeSize() == 585))
      {
        if (paramParams.reportForClick) {
          AdReporterForClick.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, getUrlForClick(paramParams));
        }
        locala = null;
        i = 1;
      }
      else if ((!TextUtils.isEmpty(paramParams.ad.getVideoUrl2())) && (paramParams.ad.getCreativeSize() == 930))
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
      }
      WeakReference localWeakReference = paramParams.activity;
      Ad localAd = paramParams.ad;
      if (locala != null) {
        str = locala.url;
      }
      paramParams = new AdClickUtil.Result(AdVideoSplice.show(localWeakReference, localAd, str, paramParams.ad.getVideoUrl2(), paramParams.mediaViewLocationRect, i, paramParams.videoPlayForced, false, paramParams.extrasForIntent), 7);
      int i = j;
      if (locala != null) {
        i = locala.type;
      }
      paramParams.urlType = i;
      return paramParams;
    }
    AdLog.e("AdClickUtil", "handleVideoSplice error");
    return new AdClickUtil.Result(4, 7);
  }
  
  private static AdClickUtil.Result handleWebProductType(AdClickUtil.Params paramParams)
  {
    if ((paramParams != null) && (isWebProductType(paramParams)) && ((paramParams.ad.getDestType() == 0) || (paramParams.ad.getDestType() == 4) || (paramParams.ad.getDestType() == 7)))
    {
      if ((paramParams.videoSpliceSupported) && (paramParams.ad.isVideoSplice())) {
        return handleVideoSplice(paramParams);
      }
      int i = getVideoCeilingStyle(paramParams);
      if ((isWebProductTypeDeeplinkSupported(paramParams)) && (!TextUtils.isEmpty(paramParams.ad.getAppDeeplink())))
      {
        c.reportAsync(new WeakReference(paramParams.activity.get()), paramParams.ad, 245);
        if (i != -2147483648) {
          return handleVideoCeiling(paramParams, i);
        }
        AdClickUtil.Result localResult = handleAppWithDeeplink(paramParams, false);
        if ((localResult != null) && (localResult.isSuccess())) {
          return localResult;
        }
        if (paramParams.halfScreenPageEnabled) {
          return handleHalfScreenPage(paramParams);
        }
        return handleUrl(paramParams, getURLObject(paramParams));
      }
      if (i != -2147483648) {
        return handleVideoCeiling(paramParams, i);
      }
      if (paramParams.halfScreenPageEnabled) {
        return handleHalfScreenPage(paramParams);
      }
      return handleUrl(paramParams, getURLObject(paramParams));
    }
    AdLog.e("AdClickUtil", "handleWebProductType error");
    return new AdClickUtil.Result(4, 0);
  }
  
  public static boolean isValidForApp(AdClickUtil.Params paramParams)
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (paramParams != null)
    {
      bool2 = bool3;
      if (paramParams.isValid())
      {
        if (!paramParams.ad.isAppProductType()) {
          return false;
        }
        boolean bool1;
        if ((!TextUtils.isEmpty(paramParams.ad.getProductId())) && (!TextUtils.isEmpty(paramParams.ad.getVia())) && (!TextUtils.isEmpty(paramParams.ad.getAppName())) && (!TextUtils.isEmpty(paramParams.ad.getAppId())) && (!TextUtils.isEmpty(paramParams.ad.getAppPackageName()))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (paramParams.ad.isAppPreOrder()) {
          return bool1;
        }
        bool2 = bool3;
        if (bool1)
        {
          bool2 = bool3;
          if (!TextUtils.isEmpty(paramParams.ad.getAppPackageUrl())) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
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
    if (!paramString.contains("__CLICK_LPP__")) {
      return paramString;
    }
    Object localObject = AdProcessManager.INSTANCE.isWebProcessRunning();
    int j = 0;
    int i;
    if (localObject != null)
    {
      if (((Boolean)localObject).booleanValue()) {
        i = 0;
      } else {
        i = 1;
      }
    }
    else {
      i = 2;
    }
    localObject = AdProcessManager.INSTANCE.isWebProcessRunningForPreloading();
    if (localObject != null)
    {
      if (!((Boolean)localObject).booleanValue()) {
        j = 1;
      }
    }
    else {
      j = 2;
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("click_time", System.currentTimeMillis());
      ((JSONObject)localObject).put("toolsalive", i);
      ((JSONObject)localObject).put("preload", j);
      localObject = ((JSONObject)localObject).toString();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return paramString;
      }
      localObject = URLEncoder.encode((String)localObject, "UTF-8");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return paramString;
      }
      localObject = paramString.replaceAll("__CLICK_LPP__", (String)localObject);
      boolean bool = TextUtils.isEmpty((CharSequence)localObject);
      if (bool) {
        return paramString;
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdClickUtil", "getUrlForClick", localThrowable);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdClickUtil
 * JD-Core Version:    0.7.0.1
 */