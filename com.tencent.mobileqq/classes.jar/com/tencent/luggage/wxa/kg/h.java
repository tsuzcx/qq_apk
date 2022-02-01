package com.tencent.luggage.wxa.kg;

import android.bluetooth.BluetoothAdapter;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.kn.b;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStopBlePeripheralAdvertising;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class h
  extends a<com.tencent.luggage.wxa.jx.c>
{
  private static final int CTRL_INDEX = 726;
  private static final String NAME = "stopBLEPeripheralAdvertising";
  public static final h.a a = new h.a(null);
  
  static
  {
    NAME = "stopBLEPeripheralAdvertising";
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "env");
    if (!com.tencent.luggage.wxa.kn.c.f())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "invoke: Ble is not available");
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.has("serverId")))
    {
      int i = paramJSONObject.optInt("serverId");
      paramJSONObject = o.a.b(i);
      if (paramJSONObject == null)
      {
        b.a(this, paramInt, paramc, 10020, "fail: no server");
        return;
      }
      BluetoothAdapter localBluetoothAdapter = com.tencent.luggage.wxa.kn.c.b();
      if (localBluetoothAdapter == null)
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "invoke: adapter is null");
        b.a(this, paramInt, paramc, 10001, "fail:not available");
        return;
      }
      paramJSONObject.a(localBluetoothAdapter);
      if (paramJSONObject.g().get())
      {
        b.a(this, paramInt, paramc, 10008, "invoke stop before start response, may occur unexpected error!");
        return;
      }
      b.a(this, paramInt, paramc, null, 4, null);
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.BLE.JsApiStopBlePeripheralAdvertising", "createBLEPeripheralServer data is invalid");
    b.a(this, paramInt, paramc, 10013, "fail:invalid data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.h
 * JD-Core Version:    0.7.0.1
 */