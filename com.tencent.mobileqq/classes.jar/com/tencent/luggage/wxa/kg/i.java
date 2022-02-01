package com.tencent.luggage.wxa.kg;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.kn.b;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiWriteBlePeripheralCharacteristicValue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class i
  extends a<com.tencent.luggage.wxa.jx.c>
{
  private static final int CTRL_INDEX = 727;
  private static final String NAME = "writeBLEPeripheralCharacteristicValue";
  public static final i.a a = new i.a(null);
  
  static
  {
    NAME = "writeBLEPeripheralCharacteristicValue";
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "env");
    if (!com.tencent.luggage.wxa.kn.c.f())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", "invoke: Ble is not available");
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.has("serverId")))
    {
      int i = paramJSONObject.optInt("serverId");
      Object localObject1 = o.a.b(i);
      if (localObject1 == null)
      {
        b.a(this, paramInt, paramc, 10020, "fail: no server");
        return;
      }
      if (((n)localObject1).a() != p.c)
      {
        b.a(this, paramInt, paramc, 10000, "fail:not init");
        return;
      }
      try
      {
        Object localObject3 = paramJSONObject.optString("serviceId", "");
        Object localObject2 = paramJSONObject.optString("characteristicId", "");
        boolean bool = paramJSONObject.optBoolean("needNotify", false);
        i = paramJSONObject.optInt("callbackId", -1);
        paramJSONObject = paramJSONObject.optString("value");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("invoke: write = ");
        localStringBuilder.append(paramJSONObject);
        localStringBuilder.append(" serviceId = %s, characteristicId = %s, needNotify = %s, jCallbackId = %s");
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", localStringBuilder.toString(), new Object[] { localObject3, localObject2, String.valueOf(bool), String.valueOf(i) });
        localObject3 = UUID.fromString((String)localObject3);
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "UUID.fromString(serviceId)");
        localObject2 = UUID.fromString((String)localObject2);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "UUID.fromString(characteristicId)");
        Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "base64Value");
        ((n)localObject1).a((UUID)localObject3, (UUID)localObject2, bool, i, paramJSONObject);
        b.a(this, paramInt, paramc, null, 4, null);
        return;
      }
      catch (IllegalArgumentException paramJSONObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("invoke: fail: ");
        ((StringBuilder)localObject1).append(paramJSONObject);
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", ((StringBuilder)localObject1).toString());
        b.a(this, paramInt, paramc, 10013, "fail:invalid data");
        return;
      }
      catch (JSONException paramJSONObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("invoke: fail: ");
        ((StringBuilder)localObject1).append(paramJSONObject);
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.BLE.JsApiWriteBlePeripheralCharacteristicValue", ((StringBuilder)localObject1).toString());
        b.a(this, paramInt, paramc, 10013, "fail:invalid data");
        return;
      }
    }
    b.a(this, paramInt, paramc, 10013, "fail:invalid data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.i
 * JD-Core Version:    0.7.0.1
 */