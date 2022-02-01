package com.tencent.luggage.wxa.kg;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.util.Base64;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.concurrent.TimersKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "", "()V", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "setComponent", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "gattServer", "Landroid/bluetooth/BluetoothGattServer;", "getGattServer", "()Landroid/bluetooth/BluetoothGattServer;", "setGattServer", "(Landroid/bluetooth/BluetoothGattServer;)V", "gattServerCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl;", "isPostingAdvertising", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "jsCallbacks", "", "Ljava/util/UUID;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/JsCallback;", "Ljava/util/Timer;", "getJsCallbacks", "()Ljava/util/Map;", "realAdvertiseCallback", "Landroid/bluetooth/le/AdvertiseCallback;", "serverId", "", "getServerId", "()I", "setServerId", "(I)V", "status", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "getStatus", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "setStatus", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;)V", "userCallbackLock", "addService", "service", "Landroid/bluetooth/BluetoothGattService;", "callback", "checkBleIsWork", "handleCharacteristicWriteAction", "serviceId", "characteristicId", "needNotify", "callbackId", "base64Value", "", "isAdvertising", "offAdvertising", "onAdvertising", "onCreate", "onDestroy", "startBLEPeripheralAdvertising", "settings", "Landroid/bluetooth/le/AdvertiseSettings;", "advertiseData", "Landroid/bluetooth/le/AdvertiseData;", "scanResponse", "deviceName", "adapter", "Landroid/bluetooth/BluetoothAdapter;", "userCallback", "stopBLEPeripheralAdvertising", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class n
{
  public static final n.a c = new n.a(null);
  @NotNull
  public BluetoothGattServer a;
  @NotNull
  public com.tencent.luggage.wxa.jx.c b;
  @NotNull
  private p d = p.a;
  private int e = -1;
  @NotNull
  private final Map<UUID, Pair<Function1<Boolean, Unit>, Timer>> f = (Map)new HashMap();
  private final AdvertiseCallback g = (AdvertiseCallback)new n.c(this);
  private AdvertiseCallback h;
  @NotNull
  private final AtomicBoolean i = new AtomicBoolean(false);
  private b j;
  
  private final void a(AdvertiseCallback paramAdvertiseCallback)
  {
    this.h = paramAdvertiseCallback;
  }
  
  private final boolean h()
  {
    return com.tencent.luggage.wxa.kn.c.c() & true & com.tencent.luggage.wxa.kn.b.a() & com.tencent.luggage.wxa.kn.c.f();
  }
  
  private final boolean i()
  {
    return this.h != null;
  }
  
  private final void j()
  {
    this.h = ((AdvertiseCallback)null);
  }
  
  @NotNull
  public final p a()
  {
    return this.d;
  }
  
  public final void a(@NotNull BluetoothAdapter paramBluetoothAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramBluetoothAdapter, "adapter");
    paramBluetoothAdapter = paramBluetoothAdapter.getBluetoothLeAdvertiser();
    if (paramBluetoothAdapter != null)
    {
      paramBluetoothAdapter.stopAdvertising(this.g);
      j();
    }
  }
  
  public final void a(@NotNull BluetoothGattService paramBluetoothGattService, @NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramBluetoothGattService, "service");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    Object localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("gattServer");
    }
    if (!((BluetoothGattServer)localObject).addService(paramBluetoothGattService)) {
      paramFunction1.invoke(Boolean.valueOf(false));
    }
    localObject = this.f;
    paramBluetoothGattService = paramBluetoothGattService.getUuid();
    Intrinsics.checkExpressionValueIsNotNull(paramBluetoothGattService, "service.uuid");
    Timer localTimer = TimersKt.timer((String)null, false);
    localTimer.schedule((TimerTask)new n.b(paramFunction1), 3000L, 9223372036854775807L);
    ((Map)localObject).put(paramBluetoothGattService, new Pair(paramFunction1, localTimer));
  }
  
  public final void a(@NotNull AdvertiseSettings paramAdvertiseSettings, @NotNull AdvertiseData paramAdvertiseData1, @NotNull AdvertiseData paramAdvertiseData2, @NotNull String paramString, @NotNull BluetoothAdapter paramBluetoothAdapter, @NotNull AdvertiseCallback paramAdvertiseCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramAdvertiseSettings, "settings");
    Intrinsics.checkParameterIsNotNull(paramAdvertiseData1, "advertiseData");
    Intrinsics.checkParameterIsNotNull(paramAdvertiseData2, "scanResponse");
    Intrinsics.checkParameterIsNotNull(paramString, "deviceName");
    Intrinsics.checkParameterIsNotNull(paramBluetoothAdapter, "adapter");
    Intrinsics.checkParameterIsNotNull(paramAdvertiseCallback, "userCallback");
    if (i())
    {
      paramAdvertiseCallback.onStartFailure(3);
      return;
    }
    a(paramAdvertiseCallback);
    this.i.set(true);
    f.a.c((Runnable)new n.d(this, paramBluetoothAdapter, paramString, paramAdvertiseSettings, paramAdvertiseData1, paramAdvertiseData2));
  }
  
  public final void a(@NotNull com.tencent.luggage.wxa.jx.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "<set-?>");
    this.b = paramc;
  }
  
  public final void a(@NotNull com.tencent.luggage.wxa.jx.c paramc, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "component");
    BluetoothManager localBluetoothManager = com.tencent.luggage.wxa.kn.c.a();
    if ((h()) && (localBluetoothManager != null))
    {
      this.d = p.b;
      this.b = paramc;
      this.e = paramInt;
      this.j = new b();
      paramc = localBluetoothManager.openGattServer(r.a(), (BluetoothGattServerCallback)this.j);
      Intrinsics.checkExpressionValueIsNotNull(paramc, "bluetoothManager.openGat…xt(), gattServerCallback)");
      this.a = paramc;
      paramc = this.j;
      if (paramc == null) {
        Intrinsics.throwNpe();
      }
      paramc.a((n)this);
      return;
    }
    paramc = p.e;
  }
  
  public final void a(@NotNull p paramp)
  {
    Intrinsics.checkParameterIsNotNull(paramp, "<set-?>");
    this.d = paramp;
  }
  
  public final void a(@NotNull UUID paramUUID1, @NotNull UUID paramUUID2, boolean paramBoolean, int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramUUID1, "serviceId");
    Intrinsics.checkParameterIsNotNull(paramUUID2, "characteristicId");
    Intrinsics.checkParameterIsNotNull(paramString, "base64Value");
    BluetoothGattServer localBluetoothGattServer = this.a;
    if (localBluetoothGattServer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("gattServer");
    }
    paramUUID1 = localBluetoothGattServer.getService(paramUUID1);
    if (paramUUID1 == null)
    {
      o.d("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: server == null");
      return;
    }
    paramUUID1 = paramUUID1.getCharacteristic(paramUUID2);
    if (paramUUID1 == null)
    {
      o.d("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: characteristic == null");
      return;
    }
    paramUUID1.setValue(com.tencent.luggage.wxa.kn.c.a(Base64.decode(paramString, 2)));
    if (paramBoolean)
    {
      paramUUID2 = this.j;
      if (paramUUID2 == null) {
        Intrinsics.throwNpe();
      }
      paramUUID2 = ((Iterable)paramUUID2.a()).iterator();
      while (paramUUID2.hasNext())
      {
        paramString = (BluetoothDevice)paramUUID2.next();
        localBluetoothGattServer = this.a;
        if (localBluetoothGattServer == null) {
          Intrinsics.throwUninitializedPropertyAccessException("gattServer");
        }
        o.d("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(localBluetoothGattServer.notifyCharacteristicChanged(paramString, paramUUID1, false)) });
      }
    }
    paramUUID2 = this.j;
    if (paramUUID2 == null) {
      Intrinsics.throwNpe();
    }
    paramUUID2 = ((Iterable)paramUUID2.a()).iterator();
    while (paramUUID2.hasNext())
    {
      paramString = (BluetoothDevice)paramUUID2.next();
      localBluetoothGattServer = this.a;
      if (localBluetoothGattServer == null) {
        Intrinsics.throwUninitializedPropertyAccessException("gattServer");
      }
      o.d("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: notifyCharacteristicChanged res = %s", new Object[] { String.valueOf(localBluetoothGattServer.notifyCharacteristicChanged(paramString, paramUUID1, true)) });
    }
    paramUUID2 = this.j;
    if (paramUUID2 == null) {
      Intrinsics.throwNpe();
    }
    paramUUID2 = (m)paramUUID2.b().get(Integer.valueOf(paramInt));
    if (paramUUID2 == null)
    {
      paramUUID1 = new StringBuilder();
      paramUUID1.append("handleCharacteristicWriteAction: #");
      paramUUID1.append(paramInt);
      paramUUID1.append(" callbackId -> pendingResp is null");
      o.d("MicroMsg.BLE.PeripheralBleServer", paramUUID1.toString());
      return;
    }
    o.d("MicroMsg.BLE.PeripheralBleServer", "handleCharacteristicWriteAction: device = %s, requestId = %s", new Object[] { paramUUID2.a().toString(), String.valueOf(paramUUID2.b()) });
    paramString = this.a;
    if (paramString == null) {
      Intrinsics.throwUninitializedPropertyAccessException("gattServer");
    }
    if (!paramString.sendResponse(paramUUID2.a(), paramUUID2.b(), 0, paramUUID2.c(), paramUUID1.getValue())) {
      o.b("MicroMsg.BLE.PeripheralBleServer", "sendPendingRespFail");
    }
    paramUUID1 = this.j;
    if (paramUUID1 == null) {
      Intrinsics.throwNpe();
    }
    paramUUID1.b().remove(Integer.valueOf(paramInt));
  }
  
  @NotNull
  public final BluetoothGattServer b()
  {
    BluetoothGattServer localBluetoothGattServer = this.a;
    if (localBluetoothGattServer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("gattServer");
    }
    return localBluetoothGattServer;
  }
  
  @NotNull
  public final com.tencent.luggage.wxa.jx.c c()
  {
    com.tencent.luggage.wxa.jx.c localc = this.b;
    if (localc == null) {
      Intrinsics.throwUninitializedPropertyAccessException("component");
    }
    return localc;
  }
  
  public final int d()
  {
    return this.e;
  }
  
  public final void e()
  {
    this.f.clear();
    Object localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("gattServer");
    }
    ((BluetoothGattServer)localObject).close();
    localObject = com.tencent.luggage.wxa.kn.c.b();
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
      a((BluetoothAdapter)localObject);
    }
    localObject = this.j;
    if (localObject != null)
    {
      localObject = ((b)localObject).b();
      if (localObject != null) {
        ((Map)localObject).clear();
      }
    }
    this.j = ((b)null);
    this.d = p.d;
  }
  
  @NotNull
  public final Map<UUID, Pair<Function1<Boolean, Unit>, Timer>> f()
  {
    return this.f;
  }
  
  @NotNull
  public final AtomicBoolean g()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.n
 * JD-Core Version:    0.7.0.1
 */