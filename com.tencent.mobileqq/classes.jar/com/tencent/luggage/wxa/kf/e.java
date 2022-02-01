package com.tencent.luggage.wxa.kf;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiGetBLEDeviceRSSI;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class e
  extends com.tencent.luggage.wxa.jx.a<com.tencent.luggage.wxa.jx.c>
{
  public static final int CTRL_INDEX = 777;
  @NotNull
  public static final String NAME = "getBLEDeviceRSSI";
  public static final e.a a = new e.a(null);
  
  public void a(@Nullable com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null)
    {
      com.tencent.luggage.wxa.kn.a.b("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "env is null", new Object[0]);
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.has("deviceId")))
    {
      String str = paramc.getAppId();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("appId: ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(", data: ");
      ((StringBuilder)localObject).append(paramJSONObject);
      com.tencent.luggage.wxa.kn.a.c("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", ((StringBuilder)localObject).toString(), new Object[0]);
      localObject = com.tencent.luggage.wxa.ke.a.a(str);
      if (localObject == null)
      {
        com.tencent.luggage.wxa.kn.a.b("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "bleWorker is null", new Object[0]);
        paramc.a(paramInt, a("fail:not init", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(10000)) })));
        return;
      }
      paramJSONObject = paramJSONObject.optString("deviceId");
      if (paramJSONObject == null)
      {
        com.tencent.luggage.wxa.kn.a.b("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "deviceId is null", new Object[0]);
        paramc.a(paramInt, a("fail:invalid data", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(10013)) })));
        return;
      }
      ((com.tencent.luggage.wxa.ke.b)localObject).a(paramJSONObject, (com.tencent.luggage.wxa.kl.a)new com.tencent.luggage.wxa.kj.c(), (com.tencent.luggage.wxa.kl.b)new e.b(this, str, paramInt, paramc));
      return;
    }
    com.tencent.luggage.wxa.kn.a.b("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", "data is null or do not have key: deviceId", new Object[0]);
    paramc.a(paramInt, a("fail:invalid data", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(10013)) })));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.e
 * JD-Core Version:    0.7.0.1
 */