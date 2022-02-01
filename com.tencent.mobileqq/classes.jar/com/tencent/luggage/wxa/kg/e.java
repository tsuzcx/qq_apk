package com.tencent.luggage.wxa.kg;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.kn.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiCreateBlePeripheralServer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class e
  extends a<com.tencent.luggage.wxa.jx.c>
{
  private static final int CTRL_INDEX = 721;
  private static final String NAME = "createBLEPeripheralServer";
  public static final e.a a = new e.a(null);
  
  static
  {
    NAME = "createBLEPeripheralServer";
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "env");
    if (!com.tencent.luggage.wxa.kn.c.f())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", "invoke: Ble is not available");
      return;
    }
    paramJSONObject = new HashMap();
    if (o.a.a())
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", "invoke: out of bound");
      b.a(this, paramInt, paramc, 10008, "fail: servers count overflow");
      return;
    }
    int i = o.a.a(paramc);
    Object localObject = o.a.b(i);
    if ((localObject != null) && (((n)localObject).a() == p.b))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invoke: serverId = ");
      ((StringBuilder)localObject).append(i);
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiCreateBLEPeripheralServer", ((StringBuilder)localObject).toString());
      ((Map)paramJSONObject).put("serverId", Integer.valueOf(i));
      b.a(this, paramInt, paramc, paramJSONObject);
      return;
    }
    b.a(this, paramInt, paramc, 10001, "fail:not available");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.e
 * JD-Core Version:    0.7.0.1
 */