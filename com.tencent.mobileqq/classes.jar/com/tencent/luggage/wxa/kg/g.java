package com.tencent.luggage.wxa.kg;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseData.Builder;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.AdvertiseSettings.Builder;
import android.os.ParcelUuid;
import android.util.Base64;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.kn.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiStartBlePeripheralAdvertising;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "connectable", "", "deviceName", "", "manufacturerData", "", "Lkotlin/Pair;", "", "powerLevel", "serverId", "getServerId", "()I", "setServerId", "(I)V", "serviceUuids", "Landroid/os/ParcelUuid;", "getAdvertiseReqData", "Landroid/bluetooth/le/AdvertiseData;", "getAdvertiseRespData", "getAdvertiseSettings", "Landroid/bluetooth/le/AdvertiseSettings;", "getPowerInfo", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "parseData", "reset", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class g
  extends a<com.tencent.luggage.wxa.jx.c>
{
  private static final int CTRL_INDEX = 725;
  private static final String NAME = "startBLEPeripheralAdvertising";
  public static final g.a a = new g.a(null);
  private int b = -1;
  private boolean c = true;
  private final List<ParcelUuid> d = (List)new ArrayList();
  private final List<Pair<Integer, String>> e = (List)new ArrayList();
  private String f = "medium";
  private String g = "";
  
  static
  {
    NAME = "startBLEPeripheralAdvertising";
  }
  
  private final boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    for (;;)
    {
      try
      {
        this.b = paramJSONObject.optInt("serverId");
        localObject1 = paramJSONObject.optString("powerLevel", "medium");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "data.optString(\"powerLevel\", \"medium\")");
        this.f = ((String)localObject1);
        paramJSONObject = paramJSONObject.optJSONObject("advertiseRequest");
        this.c = paramJSONObject.optBoolean("connectable", true);
        localObject1 = paramJSONObject.optString("deviceName", "");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "jAdvertiseRequest.optString(\"deviceName\", \"\")");
        this.g = ((String)localObject1);
        Object localObject2 = paramJSONObject.optJSONArray("serviceUuids");
        if (localObject2 != null)
        {
          j = ((JSONArray)localObject2).length();
          localObject1 = new String[j];
          i = 0;
          if (i < j)
          {
            localObject3 = ((JSONArray)localObject2).get(i);
            if (localObject3 != null)
            {
              localObject1[i] = ((String)localObject3);
              i += 1;
              continue;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
          }
          localObject2 = (Collection)new ArrayList(localObject1.length);
          j = localObject1.length;
          i = 0;
          if (i < j)
          {
            ((Collection)localObject2).add(new ParcelUuid(UUID.fromString(localObject1[i])));
            i += 1;
            continue;
          }
          localObject1 = ((Iterable)localObject2).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ParcelUuid)((Iterator)localObject1).next();
            this.d.add(localObject2);
            continue;
          }
        }
        paramJSONObject = paramJSONObject.optJSONArray("manufacturerData");
        if (paramJSONObject != null)
        {
          j = paramJSONObject.length();
          localObject2 = new JSONObject[j];
          i = 0;
          if (i < j)
          {
            localObject1 = paramJSONObject.get(i);
            if (localObject1 != null)
            {
              localObject2[i] = ((JSONObject)localObject1);
              i += 1;
              continue;
            }
            throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
          }
          int k = localObject2.length;
          i = 0;
          if (i < k)
          {
            localObject3 = localObject2[i];
            localObject1 = localObject3.optString("manufacturerId");
            j = 10;
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "manufacturerIdString");
            paramJSONObject = (JSONObject)localObject1;
            if (StringsKt.startsWith$default((String)localObject1, "0x", false, 2, null))
            {
              paramJSONObject = StringsKt.replace$default((String)localObject1, "0x", "", false, 4, null);
              j = 16;
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        Object localObject1;
        int j;
        int i;
        Object localObject3;
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "parseData: error ", new Object[] { paramJSONObject });
        return false;
      }
      try
      {
        j = Integer.parseInt(paramJSONObject, j);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        continue;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("NumberFormatException: input = ");
      ((StringBuilder)localObject1).append(paramJSONObject);
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", ((StringBuilder)localObject1).toString());
      j = 0;
      paramJSONObject = localObject3.optString("manufacturerSpecificData", "");
      this.e.add(new Pair(Integer.valueOf(j), paramJSONObject));
      i += 1;
    }
    return true;
  }
  
  private final void c()
  {
    this.e.clear();
    this.d.clear();
    this.f = "medium";
    this.g = "";
    this.c = true;
    this.b = -1;
  }
  
  private final AdvertiseSettings f()
  {
    Object localObject = g();
    int i = ((Number)((Pair)localObject).component1()).intValue();
    int j = ((Number)((Pair)localObject).component2()).intValue();
    localObject = new AdvertiseSettings.Builder().setAdvertiseMode(i).setTxPowerLevel(j).setTimeout(0).setConnectable(this.c).build();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "AdvertiseSettings.Builde…ble)\n            .build()");
    return localObject;
  }
  
  private final Pair<Integer, Integer> g()
  {
    String str = this.f;
    int k = str.hashCode();
    int i = 3;
    int j = 2;
    if (k != -1078030475)
    {
      if (k != 107348)
      {
        if (k == 3202466) {
          str.equals("high");
        }
      }
      else if (str.equals("low"))
      {
        i = 1;
        j = 0;
      }
    }
    else if (str.equals("medium"))
    {
      i = 2;
      j = 1;
    }
    return new Pair(Integer.valueOf(j), Integer.valueOf(i));
  }
  
  private final AdvertiseData h()
  {
    boolean bool = StringsKt.isBlank((CharSequence)this.g);
    Object localObject = new AdvertiseData.Builder().setIncludeDeviceName(bool ^ true);
    Iterator localIterator = ((Iterable)this.e).iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      byte[] arrayOfByte = Base64.decode((String)localPair.getSecond(), 2);
      ((AdvertiseData.Builder)localObject).addManufacturerData(((Number)localPair.getFirst()).intValue(), com.tencent.luggage.wxa.kn.c.a(arrayOfByte));
    }
    localIterator = ((Iterable)this.d).iterator();
    while (localIterator.hasNext()) {
      ((AdvertiseData.Builder)localObject).addServiceUuid((ParcelUuid)localIterator.next());
    }
    localObject = ((AdvertiseData.Builder)localObject).build();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "builder.build()");
    return localObject;
  }
  
  private final AdvertiseData i()
  {
    AdvertiseData localAdvertiseData = new AdvertiseData.Builder().setIncludeDeviceName(false).build();
    Intrinsics.checkExpressionValueIsNotNull(localAdvertiseData, "AdvertiseData.Builder()\n…lse)\n            .build()");
    return localAdvertiseData;
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "env");
    c();
    if (!com.tencent.luggage.wxa.kn.c.f())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: Ble is not available");
      return;
    }
    if (!a(paramJSONObject))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "createBLEPeripheralServer data is invalid");
      b.a(this, paramInt, paramc, 10013, "fail:invalid data");
      return;
    }
    paramJSONObject = o.a.b(this.b);
    if ((paramJSONObject != null) && (paramJSONObject.a() == p.b))
    {
      BluetoothAdapter localBluetoothAdapter = com.tencent.luggage.wxa.kn.c.b();
      if (localBluetoothAdapter == null)
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: adapter is null");
        b.a(this, paramInt, paramc, 10001, "fail:not available");
        return;
      }
      paramJSONObject.a(paramc);
      paramJSONObject.a(f(), h(), i(), this.g, localBluetoothAdapter, (AdvertiseCallback)new g.b(this, paramInt, paramc));
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiStartBlePeripheralAdvertising", "invoke: retrieve a null server");
    if ((paramJSONObject != null) && (paramJSONObject.a() == p.c))
    {
      b.a(this, paramInt, paramc, 10000, "fail:not init:already connected");
      return;
    }
    b.a(this, paramInt, paramc, 10020, "fail: no server");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.g
 * JD-Core Version:    0.7.0.1
 */