package com.tencent.mobileqq.activity.weather.webpage;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebViewPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "()V", "callJsOnFail", "", "callback", "", "errMsg", "handleJsRequest", "", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "method", "args", "", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "handleOpenWeatherPage", "jsonArgs", "onWebCallArk", "argument", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WeatherWebViewPlugin
  extends WebViewPlugin
{
  public static final WeatherWebViewPlugin.Companion a = new WeatherWebViewPlugin.Companion(null);
  
  public WeatherWebViewPlugin()
  {
    this.mPluginNameSpace = "weather";
  }
  
  private final void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebViewPlugin", 2, "onWebCallArk -> argument : " + paramString);
    }
    try
    {
      ark.arkNotify("com.tencent.weather_v2", "receive_web_msg", paramString, "json");
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d("WeatherWebViewPlugin", 1, "arkNotify", paramString);
    }
  }
  
  private final void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString1))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", -1);
      localJSONObject.put("message", paramString2);
      callJs(paramString1, new String[] { localJSONObject.toString(0) });
    }
  }
  
  private final void b(String paramString)
  {
    Object localObject1 = this.mRuntime;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mRuntime");
    Object localObject2 = ((WebViewPlugin.PluginRuntime)localObject1).a();
    if (localObject2 != null)
    {
      Object localObject3 = new JSONObject(paramString);
      localObject1 = ((JSONObject)localObject3).optString("callback");
      try
      {
        String str = ((JSONObject)localObject3).optString("adcode");
        localObject3 = ((JSONObject)localObject3).optString("businessId");
        if ((!TextUtils.isEmpty((CharSequence)str)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          localObject2 = (Context)localObject2;
          Intrinsics.checkExpressionValueIsNotNull(str, "adCode");
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "businessId");
          WeatherWebPageHelperKt.a((Context)localObject2, str, (String)localObject3);
          return;
        }
        str = "adcode=" + str + ", businessId=" + (String)localObject3 + ", can't be empty";
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "callback");
        a((String)localObject1, str);
        QLog.d("WeatherWebViewPlugin", 1, str);
        return;
      }
      catch (Throwable localThrowable)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "callback");
        a((String)localObject1, localThrowable.getMessage());
        QLog.e("WeatherWebViewPlugin", 1, "handleOpenWeatherPage, jsonArgs: " + paramString, localThrowable);
      }
    }
  }
  
  public boolean handleJsRequest(@Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebViewPlugin", 2, "handleJsRequest -> url : " + paramString1 + ",pkgName : " + paramString2 + ",method : " + paramString3 + ",args[0 : " + paramVarArgs[0]);
    }
    if ((Intrinsics.areEqual("weather", paramString2) ^ true)) {
      return false;
    }
    String str = (String)ArraysKt.firstOrNull(paramVarArgs);
    if (str != null)
    {
      boolean bool;
      if (paramString3 == null) {
        bool = false;
      }
      for (;;)
      {
        return bool;
        switch (paramString3.hashCode())
        {
        default: 
          break;
        case -1708620807: 
          if (!paramString3.equals("openWeatherPage")) {
            break;
          }
          b(str);
          bool = true;
          break;
        case -798394074: 
          if (!paramString3.equals("notify_ark_msg")) {
            break;
          }
          a(str);
          bool = true;
        }
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */