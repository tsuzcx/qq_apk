package com.tencent.ad.tangram.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

public final class c
{
  public static final int ACTION_MOBILEAPP_AD_APP_DOWN_PAUSED = 238;
  public static final int ACTION_MOBILEAPP_APP_SUBSCRIBE_ALERT_CLICK = 319;
  public static final int ACTION_MOBILEAPP_APP_SUBSCRIBE_ALERT_IMPRESSION = 318;
  public static final int ACTION_MOBILEAPP_APP_SUBSCRIBE_FINISH_PUSH = 317;
  public static final int ACTION_MOBILEAPP_APP_SUBSCRIBE_START_PUSH = 316;
  public static final int ACTION_MOBILEAPP_DEEPLINK_APP_ALREADY_INSTALLED = 247;
  public static final int ACTION_MOBILEAPP_DEEPLINK_APP_NOT_INSTALLED = 248;
  public static final int ACTION_MOBILEAPP_DEEPLINK_CAN_NOT_GET_APP_INSTALL_INFO = 249;
  public static final int ACTION_MOBILEAPP_DEEPLINK_OPEN_APP_SUCCESS = 246;
  public static final int ACTION_MOBILEAPP_DEEPLINK_TRY_TO_OPEN_APP = 245;
  public static final int ACTION_MOBILEAPP_DELAYED_DIRECT_START = 297;
  public static final int ACTION_MOBILEAPP_DELAYED_DIRECT_SUCCESS = 295;
  public static final int ACTION_MOBILEAPP_JUMP_MARKET_DEEPLINK_SUCC = 285;
  public static final int ACTION_MOBILEAPP_MARKET_INSTALL_SUCC = 286;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_ALREADY_DOWNLOAD = 270;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_AUTO_CREATE_DOWNLOAD = 269;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_CONTINUE_DOWNLOAD = 271;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_FINISH_DOWNLOAD = 274;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_INSTALLED_PACKAGE_MATCH = 275;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_INSTALLED_PACKAGE_NOT_MATCH = 276;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_MANUAL_CREATE_DOWNLOAD = 268;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_NEW_DOWNLOAD = 272;
  public static final int ACTION_MOBILEAPP_MOBILE_QQ_PAUSE_DOWNLOAD = 273;
  public static final int ACTION_MOBILEAPP_NATIVE_LANDINGPAGE_CLICK_FIVE_ELEMENT_BAR = 322;
  public static final int ACTION_MOBILEAPP_SCHEMA_SUCCESS = 290;
  private static final String TAG = "AdReporterForEffect";
  
  private static String getUrl(Ad paramAd, int paramInt)
  {
    String str;
    if ((paramAd != null) && (paramAd.isValid())) {
      str = paramAd.getUrlForEffect();
    } else {
      str = null;
    }
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return str.replaceAll("__CLICK_ID__", paramAd.getTraceId()).replaceAll("__ACTION_ID__", String.valueOf(paramInt));
  }
  
  public static void reportAsync(WeakReference<Context> paramWeakReference, Ad paramAd, int paramInt)
  {
    String str = getUrl(paramAd, paramInt);
    if (TextUtils.isEmpty(str))
    {
      AdLog.e("AdReporterForEffect", String.format("reportAsync %d error", new Object[] { Integer.valueOf(paramInt) }));
      return;
    }
    AdLog.i("AdReporterForEffect", String.format("reportAsync %s", new Object[] { str }));
    Context localContext;
    if (paramWeakReference != null) {
      localContext = (Context)paramWeakReference.get();
    } else {
      localContext = null;
    }
    a.reportForEffectStatisticsStart(localContext, paramAd, str);
    AdThreadManager.INSTANCE.post(new c.1(str, paramWeakReference, paramAd), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.c
 * JD-Core Version:    0.7.0.1
 */