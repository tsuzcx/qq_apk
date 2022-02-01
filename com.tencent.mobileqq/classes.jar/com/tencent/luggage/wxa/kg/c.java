package com.tencent.luggage.wxa.kg;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.kn.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsApiAddBlePeripheralService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "parseData", "Landroid/bluetooth/BluetoothGattService;", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class c
  extends a<com.tencent.luggage.wxa.jx.c>
{
  private static final int CTRL_INDEX = 723;
  private static final String NAME = "addBLEPeripheralService";
  public static final c.a a = new c.a(null);
  
  static
  {
    NAME = "addBLEPeripheralService";
  }
  
  private final BluetoothGattService a(JSONObject paramJSONObject)
  {
    Object localObject3 = "value";
    Object localObject2 = new Ref.ObjectRef();
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject1 = localObject2;
    int j;
    int i;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    label373:
    int n;
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONObject("service");
        localObject1 = localObject2;
        ((Ref.ObjectRef)localObject2).element = new BluetoothGattService(UUID.fromString(paramJSONObject.optString("uuid")), 0);
        localObject1 = localObject2;
        paramJSONObject = paramJSONObject.optJSONArray("characteristics");
        if (paramJSONObject != null)
        {
          localObject1 = localObject2;
          j = paramJSONObject.length();
          localObject1 = localObject2;
          JSONObject[] arrayOfJSONObject = new JSONObject[j];
          i = 0;
          if (i < j)
          {
            localObject1 = localObject2;
            localObject4 = paramJSONObject.get(i);
            if (localObject4 != null)
            {
              localObject1 = localObject2;
              arrayOfJSONObject[i] = ((JSONObject)localObject4);
              i += 1;
              continue;
            }
            localObject1 = localObject2;
            throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
          }
          localObject1 = localObject2;
          localObject4 = (Collection)new ArrayList(arrayOfJSONObject.length);
          localObject1 = localObject2;
          int k = arrayOfJSONObject.length;
          m = 0;
          paramJSONObject = (JSONObject)localObject2;
          localObject2 = localObject3;
          if (m < k)
          {
            localObject3 = arrayOfJSONObject[m];
            localObject1 = paramJSONObject;
            localObject5 = ((JSONObject)localObject3).optString("uuid");
            localObject1 = paramJSONObject;
            localObject6 = ((JSONObject)localObject3).optJSONObject("properties");
            localObject1 = paramJSONObject;
            bool1 = ((JSONObject)localObject6).optBoolean("write", false);
            localObject1 = paramJSONObject;
            bool2 = ((JSONObject)localObject6).optBoolean("read", false);
            localObject1 = paramJSONObject;
            bool3 = ((JSONObject)localObject6).optBoolean("notify", false);
            localObject1 = paramJSONObject;
            bool4 = ((JSONObject)localObject6).optBoolean("indicate", false);
            localObject1 = paramJSONObject;
          }
        }
      }
      catch (Exception localException3)
      {
        Object localObject4;
        int m;
        Object localObject5;
        Object localObject6;
        Object localObject7;
        Object localObject8;
        int i1;
        label685:
        StringBuilder localStringBuilder;
        paramJSONObject = localException1;
        localException2 = localException3;
      }
      try
      {
        bool5 = ((JSONObject)localObject6).optBoolean("writeNoResponse", false);
        if (!bool1) {
          break label994;
        }
        j = 8;
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          paramJSONObject = localException2;
          localException2 = localException4;
        }
      }
      localObject1 = paramJSONObject;
      localObject6 = ((JSONObject)localObject3).optJSONObject("permission");
      localObject1 = paramJSONObject;
      bool1 = ((JSONObject)localObject6).optBoolean("readable", false);
      localObject1 = paramJSONObject;
      bool2 = ((JSONObject)localObject6).optBoolean("writeable", false);
      localObject1 = paramJSONObject;
      bool3 = ((JSONObject)localObject6).optBoolean("readEncryptionRequired", false);
      localObject1 = paramJSONObject;
      bool4 = ((JSONObject)localObject6).optBoolean("writeEncryptionRequired", false);
      if (!bool1) {
        break label1047;
      }
      j = 1;
      break label1049;
      localObject1 = paramJSONObject;
      localObject5 = new BluetoothGattCharacteristic(UUID.fromString((String)localObject5), n, i);
      localObject1 = paramJSONObject;
      localObject6 = ((JSONObject)localObject3).optString((String)localObject2);
      localObject1 = paramJSONObject;
      localObject7 = com.tencent.luggage.wxa.kn.c.a(Base64.decode((String)localObject6, 2));
      localObject1 = paramJSONObject;
      localObject8 = new StringBuilder();
      localObject1 = paramJSONObject;
      ((StringBuilder)localObject8).append("parseData characteristic : base64 = ");
      localObject1 = paramJSONObject;
      ((StringBuilder)localObject8).append((String)localObject6);
      localObject1 = paramJSONObject;
      ((StringBuilder)localObject8).append(", hex = ");
      localObject1 = paramJSONObject;
      ((StringBuilder)localObject8).append(localObject7);
      localObject1 = paramJSONObject;
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiAddBlePeripheralService", ((StringBuilder)localObject8).toString());
      localObject1 = paramJSONObject;
      ((BluetoothGattCharacteristic)localObject5).setValue((byte[])localObject7);
      localObject1 = paramJSONObject;
      localObject7 = ((JSONObject)localObject3).optJSONArray("descriptors");
      localObject3 = localObject2;
      if (localObject7 != null)
      {
        localObject1 = paramJSONObject;
        j = ((JSONArray)localObject7).length();
        localObject1 = paramJSONObject;
        localObject6 = new JSONObject[j];
        i = 0;
        if (i < j)
        {
          localObject1 = paramJSONObject;
          localObject3 = ((JSONArray)localObject7).get(i);
          if (localObject3 != null)
          {
            localObject1 = paramJSONObject;
            localObject6[i] = ((JSONObject)localObject3);
            i += 1;
            continue;
          }
          localObject1 = paramJSONObject;
          throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
        }
        localObject1 = paramJSONObject;
        i1 = localObject6.length;
        j = 0;
        localObject3 = localObject2;
        if (j < i1)
        {
          localObject3 = localObject6[j];
          localObject1 = paramJSONObject;
          localObject7 = ((JSONObject)localObject3).optString("uuid");
          localObject1 = paramJSONObject;
          localObject8 = ((JSONObject)localObject3).optJSONObject("permission");
          localObject1 = paramJSONObject;
          localObject3 = ((JSONObject)localObject3).optString((String)localObject2);
          localObject1 = paramJSONObject;
          bool1 = ((JSONObject)localObject8).optBoolean("write");
          localObject1 = paramJSONObject;
          if (!((JSONObject)localObject8).optBoolean("read")) {
            break label1092;
          }
          i = 1;
          break label1094;
          localObject1 = paramJSONObject;
          localObject7 = new BluetoothGattDescriptor(UUID.fromString((String)localObject7), n);
          localObject1 = paramJSONObject;
          localObject8 = com.tencent.luggage.wxa.kn.c.a(Base64.decode((String)localObject3, 2));
          localObject1 = paramJSONObject;
          localStringBuilder = new StringBuilder();
          localObject1 = paramJSONObject;
          localStringBuilder.append("parseData descriptor: base64 = ");
          localObject1 = paramJSONObject;
          localStringBuilder.append((String)localObject3);
          localObject1 = paramJSONObject;
          localStringBuilder.append(", hex = ");
          localObject1 = paramJSONObject;
          localStringBuilder.append(localObject8);
          localObject1 = paramJSONObject;
          com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiAddBlePeripheralService", localStringBuilder.toString());
          localObject1 = paramJSONObject;
          ((BluetoothGattDescriptor)localObject7).setValue((byte[])localObject8);
          localObject1 = paramJSONObject;
          ((BluetoothGattCharacteristic)localObject5).addDescriptor((BluetoothGattDescriptor)localObject7);
          j += 1;
          continue;
        }
      }
      localObject1 = paramJSONObject;
      ((Collection)localObject4).add(localObject5);
      m += 1;
      localObject2 = localObject3;
      continue;
      localObject1 = paramJSONObject;
      localObject2 = ((Iterable)localObject4).iterator();
      for (;;)
      {
        localObject1 = paramJSONObject;
        if (!((Iterator)localObject2).hasNext()) {
          break label1111;
        }
        localObject1 = paramJSONObject;
        localObject3 = (BluetoothGattCharacteristic)((Iterator)localObject2).next();
        localObject1 = paramJSONObject;
        paramJSONObject = (JSONObject)localObject1;
        try
        {
          localObject4 = (BluetoothGattService)((Ref.ObjectRef)localObject1).element;
          if (localObject4 == null)
          {
            paramJSONObject = (JSONObject)localObject1;
            Intrinsics.throwNpe();
          }
          paramJSONObject = (JSONObject)localObject1;
          ((BluetoothGattService)localObject4).addCharacteristic((BluetoothGattCharacteristic)localObject3);
          paramJSONObject = (JSONObject)localObject1;
        }
        catch (Exception localException1)
        {
          break label962;
        }
      }
      paramJSONObject = (JSONObject)localObject2;
      localObject1 = (BluetoothGattService)((Ref.ObjectRef)localObject2).element;
      return localObject1;
    }
    label962:
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.BLE.JsApiAddBlePeripheralService", "parseData: fail", new Object[] { localException2 });
    paramJSONObject.element = ((BluetoothGattService)null);
    label1047:
    label1049:
    label1092:
    label1094:
    label1111:
    for (;;)
    {
      return (BluetoothGattService)paramJSONObject.element;
      label994:
      j = 0;
      i = j;
      if (bool2) {
        i = j | 0x2;
      }
      j = i;
      if (bool3) {
        j = i | 0x10;
      }
      i = j;
      if (bool4) {
        i = j | 0x20;
      }
      n = i;
      if (!bool5) {
        break;
      }
      n = i | 0x4;
      break;
      j = 0;
      i = j;
      if (bool2) {
        i = j | 0x10;
      }
      j = i;
      if (bool4) {
        j = i | 0x20 | 0x40;
      }
      i = j;
      if (!bool3) {
        break label373;
      }
      i = j | 0x2 | 0x4;
      break label373;
      i = 0;
      n = i;
      if (!bool1) {
        break label685;
      }
      n = i | 0x10;
      break label685;
    }
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.jx.c paramc, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "env");
    if (!com.tencent.luggage.wxa.kn.c.f())
    {
      b.a(this, paramInt, paramc, 10001, "fail:not available");
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiAddBlePeripheralService", "invoke: Ble is not open");
      return;
    }
    BluetoothGattService localBluetoothGattService = a(paramJSONObject);
    if (localBluetoothGattService == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.BLE.JsApiAddBlePeripheralService", "createBLEPeripheralService data is invalid");
      b.a(this, paramInt, paramc, 10013, "fail:invalid data");
      return;
    }
    if (paramJSONObject == null) {
      Intrinsics.throwNpe();
    }
    int i = paramJSONObject.optInt("serverId");
    paramJSONObject = o.a.b(i);
    if (paramJSONObject == null)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("invoke: retrieve a null server by #");
      paramJSONObject.append(i);
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.JsApiAddBlePeripheralService", paramJSONObject.toString());
      b.a(this, paramInt, paramc, 10020, "fail: no server");
      return;
    }
    paramJSONObject.a(localBluetoothGattService, (Function1)new c.b(this, paramInt, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.c
 * JD-Core Version:    0.7.0.1
 */