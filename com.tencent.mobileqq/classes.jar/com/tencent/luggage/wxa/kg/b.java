package com.tencent.luggage.wxa.kg;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/GattServerCallbackImpl;", "Landroid/bluetooth/BluetoothGattServerCallback;", "()V", "bluetoothDevices", "Ljava/util/HashSet;", "Landroid/bluetooth/BluetoothDevice;", "getBluetoothDevices", "()Ljava/util/HashSet;", "pendingWriteReqList", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PendingRespStructure;", "getPendingWriteReqList", "()Ljava/util/Map;", "server", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "getServer", "()Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "setServer", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;)V", "deviceNotExist", "", "device", "onCharacteristicReadRequest", "", "requestId", "offset", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "onCharacteristicWriteRequest", "preparedWrite", "responseNeeded", "value", "", "onConnectionStateChange", "status", "newState", "onDescriptorReadRequest", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onDescriptorWriteRequest", "onNotificationSent", "onServiceAdded", "service", "Landroid/bluetooth/BluetoothGattService;", "Companion", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class b
  extends BluetoothGattServerCallback
{
  public static final b.a b = new b.a(null);
  @NotNull
  public n a;
  @NotNull
  private final HashSet<BluetoothDevice> c = new HashSet();
  @NotNull
  private final Map<Integer, m> d = (Map)new ConcurrentHashMap();
  
  private final boolean a(BluetoothDevice paramBluetoothDevice)
  {
    if (paramBluetoothDevice == null)
    {
      o.d("MicroMsg.BLE.GattServerCallbackImpl", "deviceNotExist: device == null");
      return true;
    }
    Object localObject = (Iterable)this.c;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((BluetoothDevice)((Iterator)localObject).next()).getAddress());
    }
    if (!((List)localCollection).contains(paramBluetoothDevice.getAddress()))
    {
      o.d("MicroMsg.BLE.GattServerCallbackImpl", "deviceNotExist: is not contain device");
      return true;
    }
    return false;
  }
  
  @NotNull
  public final HashSet<BluetoothDevice> a()
  {
    return this.c;
  }
  
  public final void a(@NotNull n paramn)
  {
    Intrinsics.checkParameterIsNotNull(paramn, "<set-?>");
    this.a = paramn;
  }
  
  @NotNull
  public final Map<Integer, m> b()
  {
    return this.d;
  }
  
  public void onCharacteristicReadRequest(@Nullable BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2, @NotNull BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    Intrinsics.checkParameterIsNotNull(paramBluetoothGattCharacteristic, "characteristic");
    super.onCharacteristicReadRequest(paramBluetoothDevice, paramInt1, paramInt2, paramBluetoothGattCharacteristic);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Device tried to read characteristic: ");
    ((StringBuilder)localObject1).append(paramBluetoothGattCharacteristic.getUuid());
    o.d("MicroMsg.BLE.GattServerCallbackImpl", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Value: ");
    ((StringBuilder)localObject1).append(Arrays.toString(paramBluetoothGattCharacteristic.getValue()));
    o.d("MicroMsg.BLE.GattServerCallbackImpl", ((StringBuilder)localObject1).toString());
    if (a(paramBluetoothDevice)) {
      return;
    }
    if (paramInt2 != 0)
    {
      localObject1 = this.a;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("server");
      }
      ((n)localObject1).b().sendResponse(paramBluetoothDevice, paramInt1, 7, paramInt2, paramBluetoothGattCharacteristic.getValue());
      return;
    }
    for (int i = com.tencent.luggage.wxa.kn.b.b(); this.d.containsKey(Integer.valueOf(i)); i = com.tencent.luggage.wxa.kn.b.b()) {}
    o.d("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicReadRequest: callbackId = %d", new Object[] { Integer.valueOf(i) });
    localObject1 = this.a;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("server");
    }
    localObject1 = ((n)localObject1).c();
    Object localObject2 = this.a;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("server");
    }
    int j = ((n)localObject2).d();
    localObject2 = paramBluetoothGattCharacteristic.getService();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "characteristic.service");
    localObject2 = ((BluetoothGattService)localObject2).getUuid().toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "characteristic.service.uuid.toString()");
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString();
    Intrinsics.checkExpressionValueIsNotNull(paramBluetoothGattCharacteristic, "characteristic.uuid.toString()");
    if (a.a((c)localObject1, j, (String)localObject2, paramBluetoothGattCharacteristic, i))
    {
      if (paramBluetoothDevice == null) {
        Intrinsics.throwNpe();
      }
      paramBluetoothDevice = new m(paramBluetoothDevice, paramInt1, paramInt2);
      paramBluetoothDevice = (m)this.d.put(Integer.valueOf(i), paramBluetoothDevice);
      paramBluetoothGattCharacteristic = new StringBuilder();
      paramBluetoothGattCharacteristic.append("onCharacteristicReadRequest: pendingWriteReqList ret = ");
      paramBluetoothGattCharacteristic.append(paramBluetoothDevice);
      paramBluetoothGattCharacteristic.append(" id = ");
      paramBluetoothGattCharacteristic.append(i);
      o.d("MicroMsg.BLE.GattServerCallbackImpl", paramBluetoothGattCharacteristic.toString());
    }
  }
  
  public void onCharacteristicWriteRequest(@NotNull BluetoothDevice paramBluetoothDevice, int paramInt1, @NotNull BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramBluetoothDevice, "device");
    Intrinsics.checkParameterIsNotNull(paramBluetoothGattCharacteristic, "characteristic");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "value");
    super.onCharacteristicWriteRequest(paramBluetoothDevice, paramInt1, paramBluetoothGattCharacteristic, paramBoolean1, paramBoolean2, paramInt2, paramArrayOfByte);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Characteristic Write request: ");
    Object localObject2 = Arrays.toString(paramArrayOfByte);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.util.Arrays.toString(this)");
    ((StringBuilder)localObject1).append((String)localObject2);
    o.f("MicroMsg.BLE.GattServerCallbackImpl", ((StringBuilder)localObject1).toString());
    if (a(paramBluetoothDevice)) {
      return;
    }
    if (paramInt2 != 0)
    {
      paramArrayOfByte = this.a;
      if (paramArrayOfByte == null) {
        Intrinsics.throwUninitializedPropertyAccessException("server");
      }
      paramArrayOfByte.b().sendResponse(paramBluetoothDevice, paramInt1, 7, paramInt2, paramBluetoothGattCharacteristic.getValue());
      return;
    }
    for (int i = com.tencent.luggage.wxa.kn.b.b(); this.d.containsKey(Integer.valueOf(i)); i = com.tencent.luggage.wxa.kn.b.b()) {}
    o.d("MicroMsg.BLE.GattServerCallbackImpl", "onCharacteristicWriteRequest: callbackId = %d", new Object[] { Integer.valueOf(i) });
    paramArrayOfByte = Base64.encode(paramArrayOfByte, 2);
    localObject1 = this.a;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("server");
    }
    localObject1 = ((n)localObject1).c();
    localObject2 = this.a;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("server");
    }
    int j = ((n)localObject2).d();
    localObject2 = paramBluetoothGattCharacteristic.getService();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "characteristic.service");
    localObject2 = ((BluetoothGattService)localObject2).getUuid().toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "characteristic.service.uuid.toString()");
    paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString();
    Intrinsics.checkExpressionValueIsNotNull(paramBluetoothGattCharacteristic, "characteristic.uuid.toString()");
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "base64Value");
    if (a.a((c)localObject1, j, (String)localObject2, paramBluetoothGattCharacteristic, i, new String(paramArrayOfByte, Charsets.UTF_8)))
    {
      paramBluetoothDevice = new m(paramBluetoothDevice, paramInt1, paramInt2);
      paramBluetoothDevice = (m)this.d.put(Integer.valueOf(i), paramBluetoothDevice);
      paramBluetoothGattCharacteristic = new StringBuilder();
      paramBluetoothGattCharacteristic.append("onCharacteristicWriteRequest: pendingWriteReqList res = ");
      paramBluetoothGattCharacteristic.append(paramBluetoothDevice);
      paramBluetoothGattCharacteristic.append(", id = ");
      paramBluetoothGattCharacteristic.append(i);
      o.d("MicroMsg.BLE.GattServerCallbackImpl", paramBluetoothGattCharacteristic.toString());
    }
  }
  
  public void onConnectionStateChange(@NotNull BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramBluetoothDevice, "device");
    super.onConnectionStateChange(paramBluetoothDevice, paramInt1, paramInt2);
    if (paramInt1 == 0)
    {
      Object localObject1;
      Object localObject2;
      if (paramInt2 == 2)
      {
        this.c.add(paramBluetoothDevice);
        localObject1 = this.a;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("server");
        }
        localObject1 = ((n)localObject1).c();
        localObject2 = paramBluetoothDevice.getAddress();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "device.address");
        n localn = this.a;
        if (localn == null) {
          Intrinsics.throwUninitializedPropertyAccessException("server");
        }
        a.a((c)localObject1, (String)localObject2, String.valueOf(localn.d()), true);
        localObject1 = this.a;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("server");
        }
        ((n)localObject1).a(p.c);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Connected to device: ");
        ((StringBuilder)localObject1).append(paramBluetoothDevice.getAddress());
        o.f("MicroMsg.BLE.GattServerCallbackImpl", ((StringBuilder)localObject1).toString());
        return;
      }
      if (paramInt2 == 0)
      {
        this.c.remove(paramBluetoothDevice);
        localObject1 = this.a;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("server");
        }
        localObject1 = ((n)localObject1).c();
        paramBluetoothDevice = paramBluetoothDevice.getAddress();
        Intrinsics.checkExpressionValueIsNotNull(paramBluetoothDevice, "device.address");
        localObject2 = this.a;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("server");
        }
        a.a((c)localObject1, paramBluetoothDevice, String.valueOf(((n)localObject2).d()), false);
        paramBluetoothDevice = this.a;
        if (paramBluetoothDevice == null) {
          Intrinsics.throwUninitializedPropertyAccessException("server");
        }
        paramBluetoothDevice.a(p.b);
        o.f("MicroMsg.BLE.GattServerCallbackImpl", "Disconnected from device");
      }
    }
    else
    {
      this.c.remove(paramBluetoothDevice);
      paramBluetoothDevice = new StringBuilder();
      paramBluetoothDevice.append("Error when connecting: ");
      paramBluetoothDevice.append(paramInt1);
      o.b("MicroMsg.BLE.GattServerCallbackImpl", paramBluetoothDevice.toString());
    }
  }
  
  public void onDescriptorReadRequest(@Nullable BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2, @NotNull BluetoothGattDescriptor paramBluetoothGattDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramBluetoothGattDescriptor, "descriptor");
    super.onDescriptorReadRequest(paramBluetoothDevice, paramInt1, paramInt2, paramBluetoothGattDescriptor);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Device tried to read descriptor: ");
    ((StringBuilder)localObject).append(paramBluetoothGattDescriptor.getUuid());
    o.d("MicroMsg.BLE.GattServerCallbackImpl", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Value: ");
    ((StringBuilder)localObject).append(Arrays.toString(paramBluetoothGattDescriptor.getValue()));
    o.d("MicroMsg.BLE.GattServerCallbackImpl", ((StringBuilder)localObject).toString());
    if (paramInt2 != 0)
    {
      paramBluetoothGattDescriptor = this.a;
      if (paramBluetoothGattDescriptor == null) {
        Intrinsics.throwUninitializedPropertyAccessException("server");
      }
      paramBluetoothGattDescriptor.b().sendResponse(paramBluetoothDevice, paramInt1, 7, paramInt2, null);
      return;
    }
    localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("server");
    }
    ((n)localObject).b().sendResponse(paramBluetoothDevice, paramInt1, 0, paramInt2, paramBluetoothGattDescriptor.getValue());
  }
  
  public void onDescriptorWriteRequest(@Nullable BluetoothDevice paramBluetoothDevice, int paramInt1, @NotNull BluetoothGattDescriptor paramBluetoothGattDescriptor, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramBluetoothGattDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "value");
    super.onDescriptorWriteRequest(paramBluetoothDevice, paramInt1, paramBluetoothGattDescriptor, paramBoolean1, paramBoolean2, paramInt2, paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Descriptor Write Request ");
    localStringBuilder.append(paramBluetoothGattDescriptor.getUuid());
    localStringBuilder.append(" ");
    localStringBuilder.append(Arrays.toString(paramArrayOfByte));
    o.f("MicroMsg.BLE.GattServerCallbackImpl", localStringBuilder.toString());
    if (paramBoolean2)
    {
      paramBluetoothGattDescriptor = this.a;
      if (paramBluetoothGattDescriptor == null) {
        Intrinsics.throwUninitializedPropertyAccessException("server");
      }
      paramBluetoothGattDescriptor.b().sendResponse(paramBluetoothDevice, paramInt1, 0, 0, null);
    }
  }
  
  public void onNotificationSent(@Nullable BluetoothDevice paramBluetoothDevice, int paramInt)
  {
    super.onNotificationSent(paramBluetoothDevice, paramInt);
    paramBluetoothDevice = new StringBuilder();
    paramBluetoothDevice.append("Notification sent. Status: ");
    paramBluetoothDevice.append(paramInt);
    o.f("MicroMsg.BLE.GattServerCallbackImpl", paramBluetoothDevice.toString());
  }
  
  public void onServiceAdded(int paramInt, @Nullable BluetoothGattService paramBluetoothGattService)
  {
    super.onServiceAdded(paramInt, paramBluetoothGattService);
    if (paramBluetoothGattService == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onServiceAdded: ");
    ((StringBuilder)localObject).append(paramBluetoothGattService.getUuid());
    o.d("MicroMsg.BLE.GattServerCallbackImpl", ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("server");
    }
    localObject = (Pair)((n)localObject).f().get(paramBluetoothGattService.getUuid());
    if (localObject != null)
    {
      localObject = (Timer)((Pair)localObject).getSecond();
      if (localObject != null) {
        ((Timer)localObject).cancel();
      }
    }
    localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("server");
    }
    localObject = (Pair)((n)localObject).f().get(paramBluetoothGattService.getUuid());
    if (localObject != null)
    {
      localObject = (Function1)((Pair)localObject).getFirst();
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(Boolean.valueOf(true));
      }
    }
    localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("server");
    }
    ((n)localObject).f().remove(paramBluetoothGattService.getUuid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.b
 * JD-Core Version:    0.7.0.1
 */