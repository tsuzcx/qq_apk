package com.tencent.luggage.wxa.kj;

import android.bluetooth.BluetoothGatt;
import com.tencent.luggage.wxa.ki.d;
import com.tencent.luggage.wxa.kl.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/GetBLEDeviceRSSIAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "()V", "myTag", "", "doActionImpl", "", "getName", "onReadRemoteRssi", "gatt", "Landroid/bluetooth/BluetoothGatt;", "rssi", "", "status", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class c
  extends com.tencent.luggage.wxa.kl.a
{
  private final String a;
  
  public c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MicroMsg.AppBrand.GetBLEDeviceRSSIAction#");
    localStringBuilder.append(hashCode());
    this.a = localStringBuilder.toString();
  }
  
  public void a()
  {
    if (!com.tencent.luggage.wxa.kn.c.f())
    {
      com.tencent.luggage.wxa.kn.a.b(this.a, "Bluetooth is not enable.", new Object[0]);
      b(j.d);
      d();
      return;
    }
    Object localObject = this.f;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "worker");
    localObject = ((d)localObject).c();
    if (localObject == null)
    {
      com.tencent.luggage.wxa.kn.a.b(this.a, "bluetoothGatt is null", new Object[0]);
      b(j.i);
      d();
      return;
    }
    if (!((BluetoothGatt)localObject).readRemoteRssi())
    {
      b(j.k);
      d();
    }
  }
  
  @NotNull
  public String b()
  {
    return "GetBLEDeviceRSSIAction";
  }
  
  public void b(@Nullable BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    super.b(paramBluetoothGatt, paramInt1, paramInt2);
    com.tencent.luggage.wxa.kn.a.c(this.a, "onReadRemoteRssi, rssi: %d, status: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != 0)
    {
      b(j.b);
      d();
      return;
    }
    d locald = this.f;
    Intrinsics.checkExpressionValueIsNotNull(locald, "worker");
    if ((Intrinsics.areEqual(locald.c(), paramBluetoothGatt) ^ true))
    {
      com.tencent.luggage.wxa.kn.a.b(this.a, "bluetoothGatt is not match", new Object[0]);
      b(j.b);
      d();
      return;
    }
    b(j.a(Integer.valueOf(paramInt1)));
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kj.c
 * JD-Core Version:    0.7.0.1
 */