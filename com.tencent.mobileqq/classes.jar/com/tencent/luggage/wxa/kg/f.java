package com.tencent.luggage.wxa.kg;

import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.kn.b;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiRemoveBlePeripheralService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class f
  extends a<com.tencent.luggage.wxa.jx.c>
{
  private static final int CTRL_INDEX = 724;
  private static final String NAME = "removeBLEPeripheralService";
  public static final f.a a = new f.a(null);
  
  static
  {
    NAME = "removeBLEPeripheralService";
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "env");
    if (!com.tencent.luggage.wxa.kn.c.f())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke: Ble is not available");
      return;
    }
    Object localObject;
    if ((paramJSONObject != null) && (paramJSONObject.has("serverId")) && (paramJSONObject.has("serviceId")))
    {
      int i = paramJSONObject.optInt("serverId");
      localObject = o.a.b(i);
      if (localObject == null)
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke: retrieve a null server");
        b.a(this, paramInt, paramc, 10020, "fail: no server");
        return;
      }
    }
    try
    {
      paramJSONObject = UUID.fromString(paramJSONObject.optString("serviceId"));
      Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "UUID.fromString(data.optString(PARAMS_SERVICE_ID))");
      BluetoothGattService localBluetoothGattService = ((n)localObject).b().getService(paramJSONObject);
      if (localBluetoothGattService == null)
      {
        b.a(this, paramInt, paramc, 10004, "fail:no service");
        return;
      }
      if (((n)localObject).b().removeService(localBluetoothGattService))
      {
        b.a(this, paramInt, paramc, null, 4, null);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fail: remove #");
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append(" service fail");
      b.a(this, paramInt, paramc, 10008, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramJSONObject)
    {
      label212:
      break label212;
    }
    b.a(this, paramInt, paramc, 10013, "fail:invalid data");
    return;
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.BLE.JsApiRemoveBlePeripheralService", "invoke data is invalid");
    b.a(this, paramInt, paramc, 10013, "fail:invalid data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.f
 * JD-Core Version:    0.7.0.1
 */