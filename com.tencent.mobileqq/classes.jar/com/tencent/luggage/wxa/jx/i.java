package com.tencent.luggage.wxa.jx;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.webkit.ValueCallback;
import androidx.annotation.CallSuper;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxaSharedKT;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWxConfigPart;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "TAG", "", "isPreloaded", "", "()Z", "isPreloading", "attachCommonConfig", "", "config", "Lorg/json/JSONObject;", "generatePreloadConfig", "getJsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "apiName", "injectWxConfig", "__wxConfig", "callback", "Landroid/webkit/ValueCallback;", "put", "obj", "key", "val", "", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "scheduleToUiThreadDelayed", "delayMs", "", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public abstract class i
  extends d
  implements h
{
  private final String b = "AppBrandComponentWxaSharedKT";
  
  public abstract boolean C();
  
  public abstract boolean D();
  
  @NotNull
  public JSONObject K()
  {
    JSONObject localJSONObject = new JSONObject();
    a(localJSONObject);
    a(localJSONObject, "preload", Boolean.valueOf(true));
    return localJSONObject;
  }
  
  public final void a(@Nullable Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      Object localObject = q();
      if (localObject != null)
      {
        ((com.tencent.luggage.wxa.iu.d)localObject).d(paramRunnable);
        return;
      }
      localObject = (i)this;
      if ((((i)localObject).D()) || (((i)localObject).C())) {
        t.a(paramRunnable);
      }
    }
  }
  
  @CallSuper
  public void a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    a(paramJSONObject, "platform", "android");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Android ");
    ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
    a(paramJSONObject, "system", ((StringBuilder)localObject).toString());
    a(paramJSONObject, "brand", Build.BRAND);
    a(paramJSONObject, "model", Build.MODEL);
    localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources");
    a(paramJSONObject, "pixelRatio", Float.valueOf(((Resources)localObject).getDisplayMetrics().density));
  }
  
  @JvmOverloads
  public final void a(@NotNull JSONObject paramJSONObject, @Nullable ValueCallback<String> paramValueCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "__wxConfig");
    com.tencent.mm.plugin.appbrand.jsruntime.i locali = getJsRuntime();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("var __wxConfig = ");
    localStringBuilder.append(paramJSONObject);
    locali.evaluateJavascript(localStringBuilder.toString(), paramValueCallback);
  }
  
  public final void a(@NotNull JSONObject paramJSONObject, @NotNull String paramString, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "obj");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    try
    {
      paramJSONObject.put(paramString, paramObject);
      return;
    }
    catch (Exception paramObject)
    {
      paramJSONObject = this.b;
      paramObject = (Throwable)paramObject;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("put with key(");
      localStringBuilder.append(paramString);
      localStringBuilder.append(')');
      o.a(paramJSONObject, paramObject, localStringBuilder.toString(), new Object[0]);
    }
  }
  
  public final void b(@Nullable Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable != null)
    {
      Object localObject = q();
      if (localObject != null)
      {
        ((com.tencent.luggage.wxa.iu.d)localObject).a(paramRunnable, paramLong);
        return;
      }
      localObject = (i)this;
      if ((((i)localObject).D()) || (((i)localObject).C())) {
        t.a(paramRunnable, paramLong);
      }
    }
  }
  
  @JvmOverloads
  public final void c(@NotNull JSONObject paramJSONObject)
  {
    a(this, paramJSONObject, null, 2, null);
  }
  
  @Nullable
  public final m d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "apiName");
    return (m)this.c_.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.i
 * JD-Core Version:    0.7.0.1
 */