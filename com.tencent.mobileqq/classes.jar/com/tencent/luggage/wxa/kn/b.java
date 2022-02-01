package com.tencent.luggage.wxa.kn;

import android.bluetooth.BluetoothAdapter;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"HEX", "", "TAG", "", "byteArrayToHexString", "bytes", "", "getRandomId", "", "isPeripheralBleSupported", "", "callbackFail", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "env", "errCode", "errMsg", "callbackSuccess", "params", "Ljava/util/HashMap;", "", "toArray", "", "T", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)[Ljava/lang/Object;", "luggage-commons-jsapi-connectivity-ext_release"}, k=2, mv={1, 1, 16})
public final class b
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static final void a(@NotNull a<com.tencent.luggage.wxa.jx.c> parama, int paramInt1, @NotNull com.tencent.luggage.wxa.jx.c paramc, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(parama, "$this$callbackFail");
    Intrinsics.checkParameterIsNotNull(paramc, "env");
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    o.e("MicroMsg.BLE.BleHelpExt", "callbackFail: api = %s, reason = %s", new Object[] { parama.getClass().getSimpleName(), paramString });
    Map localMap = (Map)new HashMap();
    localMap.put("errCode", Integer.valueOf(paramInt2));
    paramc.a(paramInt1, parama.a(paramString, localMap));
  }
  
  public static final void a(@NotNull a<com.tencent.luggage.wxa.jx.c> parama, int paramInt, @NotNull com.tencent.luggage.wxa.jx.c paramc, @Nullable HashMap<String, Object> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(parama, "$this$callbackSuccess");
    Intrinsics.checkParameterIsNotNull(paramc, "env");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("callbackSuccess: api = ");
    localStringBuilder.append(parama.getClass().getSimpleName());
    o.e("MicroMsg.BLE.BleHelpExt", localStringBuilder.toString());
    if (paramHashMap == null) {
      paramHashMap = new HashMap();
    }
    paramHashMap = (Map)paramHashMap;
    paramHashMap.put("errCode", Integer.valueOf(0));
    paramc.a(paramInt, parama.a("ok", paramHashMap));
  }
  
  public static final boolean a()
  {
    Ref.BooleanRef localBooleanRef = new Ref.BooleanRef();
    BluetoothAdapter localBluetoothAdapter = c.b();
    boolean bool2 = false;
    if (localBluetoothAdapter != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localBluetoothAdapter, "getBleAdapter() ?: return false");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPeripheralBleSupported: ");
      localStringBuilder.append("isMultipleAdvertisementSupported = ");
      localStringBuilder.append(localBluetoothAdapter.isMultipleAdvertisementSupported());
      localStringBuilder.append('\n');
      localStringBuilder.append("isOffloadedFilteringSupported = ");
      localStringBuilder.append(localBluetoothAdapter.isOffloadedFilteringSupported());
      localStringBuilder.append('\n');
      localStringBuilder.append("isOffloadedScanBatchingSupported = ");
      localStringBuilder.append(localBluetoothAdapter.isOffloadedScanBatchingSupported());
      localStringBuilder.append('\n');
      localStringBuilder.append("bluetoothLeAdvertiser != null? = ");
      if (localBluetoothAdapter.getBluetoothLeAdvertiser() != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      localStringBuilder.append('\n');
      o.e("MicroMsg.BLE.BleHelpExt", localStringBuilder.toString());
      boolean bool1 = bool2;
      if (localBluetoothAdapter.getBluetoothLeAdvertiser() != null) {
        bool1 = true;
      }
      localBooleanRef.element = bool1;
      return localBooleanRef.element;
    }
    return false;
  }
  
  public static final int b()
  {
    return RandomKt.Random(System.currentTimeMillis()).nextInt(1, 2147483647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kn.b
 * JD-Core Version:    0.7.0.1
 */