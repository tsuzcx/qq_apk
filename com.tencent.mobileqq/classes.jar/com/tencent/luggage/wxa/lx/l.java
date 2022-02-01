package com.tencent.luggage.wxa.lx;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoSync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class l
  extends u<b>
{
  private static final int CTRL_INDEX = 918;
  private static final String NAME = "getSystemInfoSync";
  @Deprecated
  public static final l.a a = new l.a(null);
  
  @NotNull
  public String a(@Nullable b paramb, @Nullable JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (paramb != null) {
      paramJSONObject = paramb.d("getSystemInfo");
    } else {
      paramJSONObject = null;
    }
    if (!(paramJSONObject instanceof i)) {
      paramJSONObject = localObject;
    }
    paramJSONObject = (i)paramJSONObject;
    if (paramJSONObject != null)
    {
      paramb = a("ok", paramJSONObject.a((c)paramb));
      Intrinsics.checkExpressionValueIsNotNull(paramb, "makeReturnJson(\"ok\", legacyImpl.getInfo(env))");
      return paramb;
    }
    paramb = b("fail:not supported");
    Intrinsics.checkExpressionValueIsNotNull(paramb, "makeReturnJson(Constants…ApiMsg.API_NOT_SUPPORTED)");
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.l
 * JD-Core Version:    0.7.0.1
 */