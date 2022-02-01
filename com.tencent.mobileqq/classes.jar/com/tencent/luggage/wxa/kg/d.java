package com.tencent.luggage.wxa.kg;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.kn.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiCloseBlePeripheralServer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class d
  extends a<com.tencent.luggage.wxa.jx.c>
{
  private static final int CTRL_INDEX = 722;
  private static final String NAME = "closeBLEPeripheralServer";
  public static final d.a a = new d.a(null);
  
  static
  {
    NAME = "closeBLEPeripheralServer";
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "env");
    if (!com.tencent.luggage.wxa.kn.c.f())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiCloseBlePeripheralServer", "invoke: Ble is not available");
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.has("serverId")))
    {
      int i = paramJSONObject.optInt("serverId");
      if (o.a.a(i))
      {
        b.a(this, paramInt, paramc, null, 4, null);
        return;
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("invoke: fail: #");
      paramJSONObject.append(i);
      paramJSONObject.append(" server is not exists");
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiCloseBlePeripheralServer", paramJSONObject.toString());
      b.a(this, paramInt, paramc, 10020, "fail: no server");
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.BLE.JsApiCloseBlePeripheralServer", "createBLEPeripheralServer data is invalid");
    b.a(this, paramInt, paramc, 10013, "fail:invalid data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.d
 * JD-Core Version:    0.7.0.1
 */