package com.tencent.mobileqq.activity.weather.webpage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.weather.WeatherDCReportHelper;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.FightMsgReporter;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"AD_CODE_KEY", "", "AD_CODE_VALUE_EMPTY", "AREA_ID_VALUE_EMPTY", "BASE_URL", "BUSINESS_ID_KEY", "FOLLOW_TYPE_NO", "", "FOLLOW_TYPE_UNKNOW", "FOLLOW_TYPE_YES", "REPORT_ACTION_OPEN_WEB_EXT3_VERSION", "SCENE_KEY", "SCENE_VALUE_DRAWER", "SCENE_VALUE_SHARE", "TAG", "WEATHER_ARK_DEFAULT_HEIGHT", "WEATHER_ARK_MIN_VERSION", "WEATHER_ARK_NAME", "WEATHER_ARK_NO_PULL_MATE", "WEATHER_ARK_VIEW", "WEATHER_DOMAIN", "WEATHER_GDT_BIZ_ID", "WEATHER_SCHEME_HEAD", "WEATHER_WEB_HOST", "WEATHER_WEB_PREFIX", "encodedDeviceInfo", "asyncInitGdtDeviceInfo", "", "buildDrawerArk", "Lcom/tencent/mobileqq/activity/weather/webpage/WaterfallArk;", "areaId", "buildNoPushWaterArk", "adCode", "buildShareWaterFallArk", "messageArk", "shareUrl", "checkShareUrlIsError", "", "clearUnRead", "accountUin", "getAdCodeFromArkAppMessage", "ark", "getDrawerWeatherWebUrl", "height", "getGdtDeviceInfoBase64", "getLastUnreadWaterfallArk", "Lcom/tencent/mobileqq/data/MessageRecord;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getShareWeatherWebUrl", "getWaterFallArkFromChatMessage", "message", "getWeatherWebUrl", "hasFollowWeather", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isFollow", "isNewWeatherPushMsg", "mr", "isWeatherArkPageUrl", "url", "openWeatherByScheme", "context", "Landroid/content/Context;", "scheme", "openWeatherWebPage", "businessId", "startNewWeatherWebPageActivity", "isShare", "isFromDrawer", "drawerAreaId", "startNewWeatherWebPageActivityByFollowState", "from", "startWeatherWebPageActivity", "transformUrlToScheme", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class WeatherWebPageHelperKt
{
  private static String a;
  
  @Nullable
  public static final WaterfallArk a(@Nullable WaterfallArk paramWaterfallArk, @Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.i("WeatherWebPageHelper", 1, "buildShareWaterFallArk shareUrl == null");
      return paramWaterfallArk;
    }
    Object localObject = URLUtil.a(paramString);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "URLUtil.getArgumentsFromURL(shareUrl)");
    String str1 = (String)((Map)localObject).get("adcode");
    if (str1 != null)
    {
      localObject = (String)((Map)localObject).get("scene");
      if (localObject == null) {
        break label167;
      }
    }
    String str2;
    for (;;)
    {
      str2 = "{\"qq_weather\": {\"adcode\": " + str1 + ",\"scene\": " + (String)localObject + "}}";
      QLog.i("WeatherWebPageHelper", 1, "buildShareWaterFallArk shareUrl == " + paramString + " adcode = " + str1 + " scene = " + (String)localObject);
      if (paramWaterfallArk != null) {
        break label173;
      }
      return new WaterfallArk("com.tencent.weather_v2", str2, "1.0.0.1", "qq_weather");
      str1 = "";
      break;
      label167:
      localObject = "1";
    }
    label173:
    paramWaterfallArk.a(str2);
    return paramWaterfallArk;
  }
  
  private static final WaterfallArk a(MessageRecord paramMessageRecord)
  {
    try
    {
      if ((paramMessageRecord instanceof Message)) {
        paramMessageRecord = ((Message)paramMessageRecord).lastMsg;
      }
      while (((paramMessageRecord instanceof MessageForArkApp)) && (((MessageForArkApp)paramMessageRecord).ark_app_message != null) && (!TextUtils.isEmpty((CharSequence)((MessageForArkApp)paramMessageRecord).ark_app_message.metaList)))
      {
        Object localObject = new JSONObject(((MessageForArkApp)paramMessageRecord).ark_app_message.metaList).optJSONObject("weather").optJSONObject("waterfall_ark");
        paramMessageRecord = ((JSONObject)localObject).optString("app");
        String str1 = ((JSONObject)localObject).optString("meta");
        String str2 = ((JSONObject)localObject).optString("view");
        localObject = ((JSONObject)localObject).optString("ver");
        Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "app");
        Intrinsics.checkExpressionValueIsNotNull(str1, "meta");
        Intrinsics.checkExpressionValueIsNotNull(localObject, "ver");
        Intrinsics.checkExpressionValueIsNotNull(str2, "view");
        paramMessageRecord = new WaterfallArk(paramMessageRecord, str1, (String)localObject, str2);
        return paramMessageRecord;
      }
      return null;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.d("WeatherWebPageHelper", 1, paramMessageRecord, new Object[0]);
    }
  }
  
  @NotNull
  public static final WaterfallArk a(@Nullable String paramString)
  {
    QLog.i("WeatherWebPageHelper", 1, "buildNoPushWaterArk");
    if (paramString != null)
    {
      paramString = "{\"qq_weather\": {\"adcode\": " + paramString + ",\"scene\": 1}}";
      if (paramString == null) {}
    }
    for (;;)
    {
      return new WaterfallArk("com.tencent.weather_v2", paramString, "1.0.0.1", "qq_weather");
      paramString = "{\"qq_weather\": {}}";
    }
  }
  
  private static final MessageRecord a(QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (paramQQAppInterface == null)
    {
      localObject = null;
      return localObject;
    }
    List localList = paramQQAppInterface.getMessageFacade().a("2658655094", 1008);
    int i = localList.size() - 1;
    label30:
    if (i >= 0)
    {
      paramQQAppInterface = (ChatMessage)localList.get(i);
      if ((paramQQAppInterface instanceof Message)) {}
      for (paramQQAppInterface = ((Message)paramQQAppInterface).lastMsg;; paramQQAppInterface = (MessageRecord)paramQQAppInterface)
      {
        localObject = paramQQAppInterface;
        if ((paramQQAppInterface instanceof MessageForArkApp)) {
          break;
        }
        i -= 1;
        break label30;
      }
    }
    return null;
  }
  
  @Nullable
  public static final String a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebPageHelper", 2, "gdt device info for weather 2.0 retrieved: " + a);
    }
    return a;
  }
  
  private static final String a(WaterfallArk paramWaterfallArk)
  {
    try
    {
      paramWaterfallArk = new JSONObject(paramWaterfallArk.b()).optJSONObject("qq_weather").optString("adcode", "");
      Intrinsics.checkExpressionValueIsNotNull(paramWaterfallArk, "weather.optString(\"adcode\", \"\")");
      return paramWaterfallArk;
    }
    catch (Throwable paramWaterfallArk)
    {
      QLog.d("WeatherWebPageHelper", 1, paramWaterfallArk, new Object[0]);
    }
    return "";
  }
  
  @Nullable
  public static final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append("mqqapi://forward/url?src_type=web&version=1&url_prefix=");
      Charset localCharset = Charset.forName("UTF-8");
      Intrinsics.checkExpressionValueIsNotNull(localCharset, "Charset.forName(charsetName)");
      paramString = paramString.getBytes(localCharset);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
      paramString = Base64Util.encode(paramString, 0);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "Base64Util.encode(url.to…8\")), Base64Util.DEFAULT)");
      paramString = new String(paramString, Charsets.UTF_8);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.i("WeatherWebPageHelper", 1, "transFormUrlToScheme", paramString);
    }
    return null;
  }
  
  @NotNull
  public static final String a(@Nullable String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      str = "0";
    }
    paramString = "https://weather.mp.qq.com/pages/aio?_wv=1090533159&_wwv=196612&not_short=1&height=" + paramInt + "&adcode=" + str;
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebPageHelper", 2, "getWeatherWebUrl -> url: " + paramString);
    }
    return paramString;
  }
  
  public static final void a()
  {
    ThreadManager.getSubThreadHandler().post((Runnable)WeatherWebPageHelperKt.asyncInitGdtDeviceInfo.1.a);
  }
  
  public static final void a(@NotNull Context paramContext, @NotNull QQAppInterface paramQQAppInterface, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    a(paramQQAppInterface, (Function1)new WeatherWebPageHelperKt.startNewWeatherWebPageActivityByFollowState.1(paramContext, paramQQAppInterface, paramInt, paramString));
  }
  
  public static final void a(@NotNull Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "scheme");
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.setData(Uri.parse(paramString));
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    paramContext.startActivity(localIntent);
  }
  
  public static final void a(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString1, "adCode");
    Intrinsics.checkParameterIsNotNull(paramString2, "businessId");
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebPageHelper", 2, "openWeatherWebPage: adcode, " + paramString1 + ", businessId, " + paramString2);
    }
    String str1 = a(paramString1, 0, 2, null);
    String str2 = "{\"qq_weather\": {\"adcode\": " + paramString1 + ",\"scene\": 1}}";
    boolean bool = ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist();
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str1);
    localIntent.putExtra("isTransparentTitle", true);
    localIntent.putExtra("fragment_class", WebViewFragmentWithArk.class.getCanonicalName());
    localIntent.putExtra("appName", "com.tencent.weather_v2");
    localIntent.putExtra("appView", "qq_weather");
    localIntent.putExtra("appVersion", "1.0.0.1");
    localIntent.putExtra("appMeta", str2);
    localIntent.putExtra("adCode", paramString1);
    localIntent.putExtra("start_click_time", System.currentTimeMillis());
    localIntent.putExtra("webProcessExist", bool);
    localIntent.putExtra("is_from_share", true);
    localIntent.putExtra("is_to_ark", true);
    localIntent.putExtra("big_brother_source_key", "biz_src_gzh_weather");
    paramContext.startActivity(localIntent);
    WeatherDCReportHelper.a().a("new_folder_apicall", new String[] { "AND", "", paramString2 });
  }
  
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    paramQQAppInterface = paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.PublicAccountDataManager");
    }
    paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface;
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = paramQQAppInterface.b("2658655094");
    if ((AccountDetail)localObjectRef.element == null)
    {
      ThreadManager.excute((Runnable)new WeatherWebPageHelperKt.hasFollowWeather.1(localObjectRef, paramQQAppInterface, paramFunction1), 32, null, true);
      return;
    }
    if (((AccountDetail)localObjectRef.element).followType == 1)
    {
      paramFunction1.invoke(Integer.valueOf(1));
      return;
    }
    paramFunction1.invoke(Integer.valueOf(2));
  }
  
  public static final boolean a(@NotNull Context paramContext, @NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    return a(paramContext, paramQQAppInterface, false, "", false, "");
  }
  
  public static final boolean a(@NotNull Context paramContext, @Nullable QQAppInterface paramQQAppInterface, boolean paramBoolean1, @Nullable String paramString1, boolean paramBoolean2, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    long l1 = System.currentTimeMillis();
    Object localObject1 = URLUtil.a(paramString1);
    String str2 = (String)((Map)localObject1).get("adcode");
    String str1 = (String)((Map)localObject1).get("businessId");
    boolean bool = paramBoolean1;
    if (paramBoolean1)
    {
      bool = paramBoolean1;
      if (b(paramString1)) {
        bool = false;
      }
    }
    Object localObject3 = a(paramQQAppInterface);
    Object localObject4 = a((MessageRecord)localObject3);
    Object localObject2;
    if (bool)
    {
      localObject1 = a((WaterfallArk)localObject4, paramString1);
      localObject2 = localObject3;
      if (localObject1 == null) {
        break label618;
      }
      paramBoolean1 = ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist();
      localObject3 = new Intent(paramContext, QQBrowserActivity.class);
      localObject4 = a((WaterfallArk)localObject1);
      if (!bool) {
        break label549;
      }
      paramString1 = b(paramString1, 0, 2, null);
      label150:
      ((Intent)localObject3).putExtra("url", paramString1);
      ((Intent)localObject3).putExtra("isTransparentTitle", true);
      ((Intent)localObject3).putExtra("fragment_class", WebViewFragmentWithArk.class.getCanonicalName());
      ((Intent)localObject3).putExtra("appName", ((WaterfallArk)localObject1).a());
      ((Intent)localObject3).putExtra("appView", ((WaterfallArk)localObject1).d());
      ((Intent)localObject3).putExtra("appVersion", ((WaterfallArk)localObject1).c());
      ((Intent)localObject3).putExtra("appMeta", ((WaterfallArk)localObject1).b());
      ((Intent)localObject3).putExtra("adCode", (String)localObject4);
      ((Intent)localObject3).putExtra("start_click_time", l1);
      ((Intent)localObject3).putExtra("webProcessExist", paramBoolean1);
      ((Intent)localObject3).putExtra("is_from_share", bool);
      ((Intent)localObject3).putExtra("is_from_drawer", paramBoolean2);
      ((Intent)localObject3).putExtra("is_to_ark", true);
      ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_gzh_weather");
      paramContext.startActivity((Intent)localObject3);
      if (localObject2 != null) {
        b(((MessageRecord)localObject2).selfuin);
      }
      if (paramQQAppInterface != null) {
        SharedPreUtils.a(paramContext, paramQQAppInterface.getCurrentAccountUin(), true, "key_last_open_weather_page", Long.valueOf(System.currentTimeMillis()));
      }
      WeatherPreloadHelperKt.a(2, "isWebProcessExist = " + paramBoolean1 + " isFromShare = " + bool + " isFromDrawer " + paramBoolean2 + " url = " + paramString1);
      if (!paramBoolean1) {
        break label578;
      }
      WeatherDCReportHelper.a().a(paramQQAppInterface, "new_folder_prestart_open", "1");
    }
    for (;;)
    {
      if (str1 != null) {
        WeatherDCReportHelper.a().a("new_folder_apicall", new String[] { "AND", "", str1 });
      }
      if (localObject2 != null)
      {
        l1 = NetConnInfoCenter.getServerTime();
        long l2 = ((MessageRecord)localObject2).time;
        WeatherDCReportHelper.a().a(paramQQAppInterface, "new_folder_push_open_timegap", Long.valueOf(l1 - l2));
      }
      return true;
      if (paramBoolean2)
      {
        localObject1 = b(paramString2);
        localObject2 = (MessageRecord)null;
        break;
      }
      localObject1 = localObject4;
      localObject2 = localObject3;
      if (localObject4 != null) {
        break;
      }
      localObject1 = a(str2);
      localObject2 = localObject3;
      break;
      label549:
      if (paramBoolean2)
      {
        paramString1 = c(paramString2, 0, 2, null);
        break label150;
      }
      paramString1 = a((String)localObject4, 0, 2, null);
      break label150;
      label578:
      int i = WeatherPreloadHelperKt.a(paramQQAppInterface);
      WeatherDCReportHelper.a().a(paramQQAppInterface, "new_folder_noprestart_open", i + "|1");
    }
    label618:
    return false;
  }
  
  public static final boolean a(@Nullable MessageRecord paramMessageRecord)
  {
    paramMessageRecord = a(paramMessageRecord);
    if (paramMessageRecord != null) {
      return (!TextUtils.isEmpty((CharSequence)paramMessageRecord.a())) && (!TextUtils.isEmpty((CharSequence)paramMessageRecord.d())) && (!TextUtils.isEmpty((CharSequence)paramMessageRecord.c())) && (!TextUtils.isEmpty((CharSequence)paramMessageRecord.b()));
    }
    return false;
  }
  
  public static final boolean a(@Nullable String paramString)
  {
    return (paramString != null) && (StringsKt.startsWith$default(paramString, "https://weather.mp.qq.com/pages/aio", false, 2, null) == true);
  }
  
  @NotNull
  public static final WaterfallArk b(@Nullable String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      str = "0";
    }
    paramString = "{\"qq_weather\": {\"area_id\": " + str + ",\"scene\": 3}}";
    QLog.i("WeatherWebPageHelper", 1, "buildDrawerArk appMeta == " + paramString);
    return new WaterfallArk("com.tencent.weather_v2", paramString, "1.0.0.1", "qq_weather");
  }
  
  @NotNull
  public static final String b(@Nullable String paramString, int paramInt)
  {
    paramString = paramString + "&height=" + paramInt;
    QLog.i("WeatherWebPageHelper", 1, "buildShareWeatherWebUrl " + paramString);
    return paramString;
  }
  
  public static final void b(@NotNull Context paramContext, @NotNull QQAppInterface paramQQAppInterface, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    if (!a(paramContext, paramQQAppInterface, true, paramString, false, ""))
    {
      paramQQAppInterface = new Intent();
      paramString = new Bundle();
      paramQQAppInterface.setComponent(new ComponentName(paramContext, ChatActivity.class));
      paramString.putString("uin", "2658655094");
      paramString.putInt("uintype", 1008);
      paramString.putString("uinname", "QQ天气");
      paramQQAppInterface.putExtras(paramString);
      paramQQAppInterface.setFlags(67108864);
      paramQQAppInterface.putExtra("isforceRequestDetail", false);
      paramQQAppInterface.putExtra("jump_from", paramInt);
      paramContext.startActivity(paramQQAppInterface);
    }
  }
  
  private static final void b(String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = BaseApplicationImpl.getApplication().getAppRuntime(paramString);
      if ((paramString instanceof QQAppInterface))
      {
        FightMsgReporter.a(1, 0, 1008, ((QQAppInterface)paramString).getConversationFacade().a("2658655094", 1008));
        ((QQAppInterface)paramString).getMessageFacade().a("2658655094", 1008, true, true);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d("WeatherWebPageHelper", 1, paramString, new Object[0]);
    }
  }
  
  public static final boolean b(@Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.i("WeatherWebPageHelper", 1, "checkShareUrlParam false shareUrl == null");
      return true;
    }
    Object localObject = URLUtil.a(paramString);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "URLUtil.getArgumentsFromURL(shareUrl)");
    String str = (String)((Map)localObject).get("adcode");
    localObject = (String)((Map)localObject).get("scene");
    if ((TextUtils.isEmpty((CharSequence)str)) || ("0".equals(str)) || (TextUtils.isEmpty((CharSequence)localObject)))
    {
      QLog.i("WeatherWebPageHelper", 1, "checkShareUrlParam false  shareUrl == " + paramString + ' ');
      return true;
    }
    return false;
  }
  
  @NotNull
  public static final String c(@Nullable String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      str = "0";
    }
    return "https://weather.mp.qq.com/pages/aio?_wv=1090533159&_wwv=196612&not_short=1&height=" + paramInt + "&area_id=" + str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt
 * JD-Core Version:    0.7.0.1
 */