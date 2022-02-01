package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.kj.h;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/central/JsApiSetBLEMtu;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class n
  extends com.tencent.luggage.wxa.jx.a<com.tencent.luggage.wxa.jx.c>
{
  private static final int CTRL_INDEX = 738;
  private static final String NAME = "setBLEMTU";
  public static final n.a a = new n.a(null);
  
  public void a(@NotNull com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "service");
    if ((paramJSONObject != null) && (paramJSONObject.has("deviceId")) && (paramJSONObject.has("mtu")))
    {
      String str1 = paramc.getAppId();
      Intrinsics.checkExpressionValueIsNotNull(str1, "service.appId");
      o.d("MicroMsg.JsApiSetBLEMtu", "appId:%s createBLEConnection data %s", new Object[] { str1, paramJSONObject.toString() });
      com.tencent.luggage.wxa.ke.b localb = com.tencent.luggage.wxa.ke.a.a(paramc.getAppId());
      if (localb == null)
      {
        o.b("MicroMsg.JsApiSetBLEMtu", "bleWorker is null, may not open ble");
        paramJSONObject = (Map)new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(10000));
        paramc.a(paramInt, a("fail:not init", paramJSONObject));
        com.tencent.luggage.wxa.ke.c.a(27, 30);
        return;
      }
      if (!localb.j())
      {
        o.b("MicroMsg.JsApiSetBLEMtu", "bleWorker is disable, may not open ble");
        paramJSONObject = (Map)new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(10001));
        paramc.a(paramInt, a("fail:not available", paramJSONObject));
        com.tencent.luggage.wxa.ke.c.a(27, 32);
        return;
      }
      String str2 = paramJSONObject.optString("deviceId");
      localb.a(str2, (com.tencent.luggage.wxa.kl.a)new h(Integer.valueOf(paramJSONObject.optInt("mtu")), str2), (com.tencent.luggage.wxa.kl.b)new n.b(this, str1, paramInt, paramc));
      return;
    }
    o.b("MicroMsg.JsApiSetBLEMtu", "createBLEConnection data is null, err");
    paramJSONObject = (Map)new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(10013));
    paramc.a(paramInt, a("fail:invalid data", paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.n
 * JD-Core Version:    0.7.0.1
 */