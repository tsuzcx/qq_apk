package com.tencent.luggage.wxa.cg;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/device/JsApiGetDeviceInfo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class d
  extends com.tencent.luggage.wxa.jx.a<com.tencent.luggage.wxa.jx.c>
{
  public static final int CTRL_INDEX = 867;
  @NotNull
  public static final String NAME = "getDeviceInfo";
  public static final d.a a = new d.a(null);
  
  public void a(@Nullable com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    String str1 = com.tencent.luggage.wxa.hd.c.a();
    try
    {
      paramJSONObject = com.tencent.luggage.wxa.hd.c.a(false);
    }
    catch (Exception paramJSONObject)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getIMEI fail: ");
      ((StringBuilder)localObject1).append(paramJSONObject);
      o.c("Luggage.JsApiGetDeviceInfo", ((StringBuilder)localObject1).toString());
      paramJSONObject = "";
    }
    String str2 = a.a();
    if (paramc != null)
    {
      localObject1 = (com.tencent.luggage.wxa.nz.a)paramc.b(com.tencent.luggage.wxa.nz.a.class);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.luggage.wxa.nz.a)localObject1).u;
        break label91;
      }
    }
    Object localObject1 = null;
    label91:
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getDeviceInfo, oaid:");
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append(", imei:");
    ((StringBuilder)localObject2).append(paramJSONObject);
    ((StringBuilder)localObject2).append(", waid:");
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ua:");
    localStringBuilder.append((String)localObject1);
    o.d("Luggage.JsApiGetDeviceInfo", (String)localObject2, new Object[] { localStringBuilder.toString() });
    paramJSONObject = MapsKt.mapOf(new Pair[] { TuplesKt.to("oaid", str1), TuplesKt.to("imei", paramJSONObject), TuplesKt.to("waid", ""), TuplesKt.to("devIdInfo", str2), TuplesKt.to("ua", localObject1) });
    if (paramc != null) {
      paramc.a(paramInt, a("ok", paramJSONObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cg.d
 * JD-Core Version:    0.7.0.1
 */