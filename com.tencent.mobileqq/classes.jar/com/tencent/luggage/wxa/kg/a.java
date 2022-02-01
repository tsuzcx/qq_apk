package com.tencent.luggage.wxa.kg;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "dispatchEvent", "", "event", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "data", "Lorg/json/JSONObject;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "jOnBLEPeripheralConnectionStateChanged", "deviceID", "serverID", "connected", "", "jOnCharacteristicReadRequest", "", "serviceUUID", "characteristicUUID", "callbackId", "jOnCharacteristicWriteRequest", "base64Value", "luggage-commons-jsapi-connectivity-ext_release"}, k=2, mv={1, 1, 16})
public final class a
{
  private static final void a(ah paramah, JSONObject paramJSONObject, c paramc)
  {
    paramah.b(paramJSONObject.toString());
    paramah.b(paramc);
    paramah.a();
  }
  
  public static final void a(@NotNull c paramc, @NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "component");
    Intrinsics.checkParameterIsNotNull(paramString1, "deviceID");
    Intrinsics.checkParameterIsNotNull(paramString2, "serverID");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("jOnBLEPeripheralConnectionStateChanged: connected = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", deviceID = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", serverID = ");
    ((StringBuilder)localObject).append(paramString2);
    o.d("MicroMsg.BLE.BlePeripheralPublishEventFuns", ((StringBuilder)localObject).toString());
    try
    {
      localObject = new j();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("deviceId", paramString1);
      localJSONObject.put("serverId", paramString2);
      localJSONObject.put("connected", paramBoolean);
      a((ah)localObject, localJSONObject, paramc);
      return;
    }
    catch (JSONException paramc)
    {
      o.b("MicroMsg.BLE.BlePeripheralPublishEventFuns", "BlePeripheralPublishEventFuns fail", new Object[] { paramc });
    }
  }
  
  public static final boolean a(@NotNull c paramc, int paramInt1, @NotNull String paramString1, @NotNull String paramString2, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "component");
    Intrinsics.checkParameterIsNotNull(paramString1, "serviceUUID");
    Intrinsics.checkParameterIsNotNull(paramString2, "characteristicUUID");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("jOnCharacteristicReadRequest: serverID = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", serviceUUID = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(",\" +\n");
    ((StringBuilder)localObject).append("        \" characteristicUUID = ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", callbackId = ");
    ((StringBuilder)localObject).append(paramInt2);
    o.d("MicroMsg.BLE.BlePeripheralPublishEventFuns", ((StringBuilder)localObject).toString());
    try
    {
      localObject = new k();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("serverId", paramInt1);
      localJSONObject.put("serviceId", paramString1);
      localJSONObject.put("characteristicId", paramString2);
      localJSONObject.put("callbackId", paramInt2);
      a((ah)localObject, localJSONObject, paramc);
      return true;
    }
    catch (JSONException paramc)
    {
      o.b("MicroMsg.BLE.BlePeripheralPublishEventFuns", "OnCharacteristicReadRequest: fail", new Object[] { paramc });
    }
    return false;
  }
  
  public static final boolean a(@NotNull c paramc, int paramInt1, @NotNull String paramString1, @NotNull String paramString2, int paramInt2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "component");
    Intrinsics.checkParameterIsNotNull(paramString1, "serviceUUID");
    Intrinsics.checkParameterIsNotNull(paramString2, "characteristicUUID");
    Intrinsics.checkParameterIsNotNull(paramString3, "base64Value");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("jOnCharacteristicWriteRequest: serverID = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", serviceUUID = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(',');
    ((StringBuilder)localObject).append(" characteristicUUID = ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", callbackId = ");
    ((StringBuilder)localObject).append(paramInt2);
    o.d("MicroMsg.BLE.BlePeripheralPublishEventFuns", ((StringBuilder)localObject).toString());
    try
    {
      localObject = new l();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("serverId", paramInt1);
      localJSONObject.put("serviceId", paramString1);
      localJSONObject.put("characteristicId", paramString2);
      localJSONObject.put("callbackId", paramInt2);
      localJSONObject.put("value", paramString3);
      a((ah)localObject, localJSONObject, paramc);
      return true;
    }
    catch (JSONException paramc)
    {
      o.b("MicroMsg.BLE.BlePeripheralPublishEventFuns", "BlePeripheralPublishEventFuns fail", new Object[] { paramc });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.a
 * JD-Core Version:    0.7.0.1
 */