package com.tencent.luggage.wxa.kj;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import com.tencent.luggage.wxa.ki.d;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.kn.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.luggage.wxa.qz.v.a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/SetMtuAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "mtuSize", "", "deviceId", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "isTimeOut", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/Integer;", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "doActionImpl", "", "getName", "onMtuChanged", "gatt", "Landroid/bluetooth/BluetoothGatt;", "mtu", "status", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class h
  extends com.tencent.luggage.wxa.kl.a
{
  private final v a;
  private final AtomicBoolean b;
  private final Integer c;
  @Nullable
  private final String d;
  
  public h(@Nullable Integer paramInteger, @Nullable String paramString)
  {
    this.c = paramInteger;
    this.d = paramString;
    this.a = new v((v.a)new h.a(this), false);
    this.b = new AtomicBoolean(false);
  }
  
  public void a()
  {
    if (c.b() == null)
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      b(j.i);
      d();
      return;
    }
    Object localObject = this.d;
    if ((localObject != null) && (BluetoothAdapter.checkBluetoothAddress((String)localObject)) && (this.c != null))
    {
      if (!c.f())
      {
        com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "bluetooth is not enable.", new Object[0]);
        b(j.d);
        d();
        return;
      }
      localObject = this.f;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "worker");
      localObject = ((d)localObject).c();
      if (localObject == null)
      {
        b(j.i);
        d();
        return;
      }
      if (this.c.intValue() > 512)
      {
        b(new j(10013, "fail:invalid data, DEFAULT_MAX_MTU = 512"));
        d();
        return;
      }
      if (this.c.intValue() < 23)
      {
        b(new j(10013, "fail:invalid data, DEFAULT_MIN_MTU = 23"));
        d();
        return;
      }
      if (!((BluetoothGatt)localObject).requestMtu(this.c.intValue()))
      {
        b(j.k);
        d();
        return;
      }
      this.a.a(500L, 9223372036854775807L);
      return;
    }
    com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.Action", "action:%s, unspecified deviceId", new Object[] { this });
    b(j.r);
    d();
  }
  
  @NotNull
  public String b()
  {
    return "SetMtuAction";
  }
  
  public void c(@NotNull BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramBluetoothGatt, "gatt");
    super.c(paramBluetoothGatt, paramInt1, paramInt2);
    if (this.b.get())
    {
      this.b.set(false);
      return;
    }
    o.e("MicroMsg.Ble.Action", "onMtuChanged: mtu = %d, status = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramBluetoothGatt = this.c;
    if ((paramBluetoothGatt != null) && (paramInt1 == paramBluetoothGatt.intValue()) && (paramInt2 == 0))
    {
      b(j.a);
      d();
      return;
    }
    b(j.b);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kj.h
 * JD-Core Version:    0.7.0.1
 */