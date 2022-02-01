package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiSystemLog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "PREFIX", "", "PREFIX$annotations", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "getPREFIX", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)Ljava/lang/String;", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class au
  extends a<c>
{
  public static final int CTRL_INDEX = 65;
  @NotNull
  public static final String NAME = "systemLog";
  public static final au.a a = new au.a(null);
  
  private final String a(@NotNull c paramc)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("appId[");
    ((StringBuilder)localObject).append(paramc.getAppId());
    ((StringBuilder)localObject).append(']');
    String str = ((StringBuilder)localObject).toString();
    if ((paramc instanceof h))
    {
      paramc = new StringBuilder();
      paramc.append("Service ");
      paramc.append(str);
      localObject = paramc.toString();
    }
    else
    {
      localObject = str;
      if ((paramc instanceof u))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Page ");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" url[");
        ((StringBuilder)localObject).append(((u)paramc).an());
        ((StringBuilder)localObject).append(']');
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    paramc = new StringBuilder();
    paramc.append((String)localObject);
    paramc.append(" print:");
    return paramc.toString();
  }
  
  public void a(@NotNull c paramc, @NotNull JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "service");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "data");
    paramJSONObject = paramJSONObject.optString("message");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramc));
    localStringBuilder.append(paramJSONObject);
    o.d("AppBrandLog", localStringBuilder.toString());
    paramc.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.au
 * JD-Core Version:    0.7.0.1
 */