package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.m.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadWAFile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class u
  extends a<b>
{
  private static final int CTRL_INDEX = 908;
  private static final String NAME = "loadWAFile";
  @Deprecated
  public static final u.a a = new u.a(null);
  
  public void a(@NotNull b paramb, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "env");
    paramJSONObject = v.a.a(paramb, "Luggage.JsApiLoadWAFile", paramJSONObject);
    if (Intrinsics.areEqual(paramJSONObject.b, "ok")) {
      paramJSONObject = a((c)paramb, paramJSONObject.b, paramJSONObject.a);
    } else {
      paramJSONObject = a(paramJSONObject.b, paramJSONObject.a);
    }
    paramb.a(paramInt, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.u
 * JD-Core Version:    0.7.0.1
 */