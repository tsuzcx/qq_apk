package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.m.a;
import com.tencent.luggage.wxa.jx.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadWAFileSync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class v
  extends u<b>
{
  private static final int CTRL_INDEX = 909;
  private static final String NAME = "loadWAFileSync";
  public static final v.a a = new v.a(null);
  
  @NotNull
  public String a(@NotNull b paramb, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "env");
    paramJSONObject = a.a(paramb, "Luggage.JsApiLoadWAFileSync", paramJSONObject);
    if (Intrinsics.areEqual(paramJSONObject.b, "ok"))
    {
      paramb = a((c)paramb, paramJSONObject.b, paramJSONObject.a);
      Intrinsics.checkExpressionValueIsNotNull(paramb, "makeReturnJsonWithNative…, ret.errMsg, ret.values)");
      return paramb;
    }
    paramb = a(paramJSONObject.b, paramJSONObject.a);
    Intrinsics.checkExpressionValueIsNotNull(paramb, "makeReturnJson(ret.errMsg, ret.values)");
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.v
 * JD-Core Version:    0.7.0.1
 */