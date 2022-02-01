package com.tencent.luggage.wxa.cg;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/device/JsApiGetOAID;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class e
  extends a<com.tencent.luggage.wxa.jx.c>
{
  public static final int CTRL_INDEX = 711;
  @NotNull
  public static final String NAME = "getOAID";
  public static final e.a a = new e.a(null);
  
  public void a(@Nullable com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = com.tencent.luggage.wxa.hd.c.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getOAID oaid=");
    ((StringBuilder)localObject).append(paramJSONObject);
    o.d("Luggage.JsApiGetOAID", ((StringBuilder)localObject).toString());
    localObject = (Map)new HashMap();
    if (paramJSONObject == null) {
      Intrinsics.throwNpe();
    }
    ((Map)localObject).put("result", paramJSONObject);
    if (paramc == null) {
      Intrinsics.throwNpe();
    }
    paramc.a(paramInt, a("ok", (Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cg.e
 * JD-Core Version:    0.7.0.1
 */