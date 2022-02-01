package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "execute"}, k=3, mv={1, 1, 16})
final class b$b
  implements c
{
  public static final b a = new b();
  
  public final void a(@NotNull g paramg, @NotNull com.tencent.luggage.wxa.iu.b paramb, @NotNull JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramg, "api");
    Intrinsics.checkParameterIsNotNull(paramb, "component");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "data");
    b.c();
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("dummy execute name[");
    paramJSONObject.append(paramg.d());
    paramJSONObject.append("], callbackId[");
    paramJSONObject.append(paramInt);
    paramJSONObject.append("], appId[");
    paramJSONObject.append(paramb.getAppId());
    paramJSONObject.append(']');
    o.b("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.b.b
 * JD-Core Version:    0.7.0.1
 */