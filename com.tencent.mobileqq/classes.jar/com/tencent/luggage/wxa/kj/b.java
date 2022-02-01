package com.tencent.luggage.wxa.kj;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ki.d;
import com.tencent.luggage.wxa.kl.f;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.kn.c;

@TargetApi(18)
public class b
  extends com.tencent.luggage.wxa.kl.a
{
  public String a;
  public boolean b;
  public String c = "LE";
  public long d = 0L;
  @Nullable
  public String e = null;
  
  public b(String paramString)
  {
    this.a = paramString;
  }
  
  private j a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail:connection fail");
    localStringBuilder.append(" ");
    localStringBuilder.append("status:");
    localStringBuilder.append(paramInt);
    return new j(10003, localStringBuilder.toString());
  }
  
  @Nullable
  private Integer e()
  {
    String str = this.e;
    if (str == null) {
      return null;
    }
    int i = -1;
    int j = str.hashCode();
    if (j != -1924829944)
    {
      if (j != -1837176303)
      {
        if ((j == 3202466) && (str.equals("high"))) {
          i = 1;
        }
      }
      else if (str.equals("lowPower")) {
        i = 2;
      }
    }
    else if (str.equals("balanced")) {
      i = 0;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return null;
        }
        return Integer.valueOf(2);
      }
      return Integer.valueOf(1);
    }
    return Integer.valueOf(0);
  }
  
  public void a()
  {
    Object localObject = c.b();
    boolean bool2 = false;
    boolean bool1 = false;
    if (localObject == null)
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.ConnectAction", "action:%s, bluetoothGatt is null", new Object[] { this });
      b(j.i);
      d();
      return;
    }
    String str = this.a;
    if ((str != null) && (BluetoothAdapter.checkBluetoothAddress(str)))
    {
      if (!c.f())
      {
        com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.ConnectAction", "bluetooth is not enable.", new Object[0]);
        b(j.d);
        d();
        return;
      }
      if (this.f.c() != null)
      {
        com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.ConnectAction", "already connect, please close", new Object[0]);
        b(j.q);
        d();
        return;
      }
      localObject = ((BluetoothAdapter)localObject).getRemoteDevice(this.a);
      if (localObject != null)
      {
        com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.ConnectAction", "autoConnect:%b transport:%s", new Object[] { Boolean.valueOf(this.b), this.c });
        if (Build.VERSION.SDK_INT >= 23)
        {
          str = this.c.toUpperCase();
          int i = -1;
          int j = str.hashCode();
          if (j != 2425)
          {
            if (j != 2020783)
            {
              if ((j == 63463747) && (str.equals("BREDR"))) {
                i = 2;
              }
            }
            else if (str.equals("AUTO")) {
              i = 1;
            }
          }
          else if (str.equals("LE")) {
            i = 0;
          }
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2) {
                localObject = ((BluetoothDevice)localObject).connectGatt(this.f.d(), this.b, new com.tencent.luggage.wxa.ki.a(this.f), 2);
              } else {
                localObject = ((BluetoothDevice)localObject).connectGatt(this.f.d(), this.b, new com.tencent.luggage.wxa.ki.a(this.f), 1);
              }
            }
            else {
              localObject = ((BluetoothDevice)localObject).connectGatt(this.f.d(), this.b, new com.tencent.luggage.wxa.ki.a(this.f), 0);
            }
          }
          else {
            localObject = ((BluetoothDevice)localObject).connectGatt(this.f.d(), this.b, new com.tencent.luggage.wxa.ki.a(this.f), 2);
          }
        }
        else
        {
          localObject = ((BluetoothDevice)localObject).connectGatt(this.f.d(), this.b, new com.tencent.luggage.wxa.ki.a(this.f));
        }
        if (localObject != null)
        {
          com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.ConnectAction", "mBluetoothGatt:%s", new Object[] { localObject });
          str = this.a;
          if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            bool1 = true;
          }
          com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.ConnectAction", "create a new connection deviceId=%s mainthread:%b", new Object[] { str, Boolean.valueOf(bool1) });
          this.f.a((BluetoothGatt)localObject);
          return;
        }
        localObject = this.a;
        bool1 = bool2;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          bool1 = true;
        }
        com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.ConnectAction", "Get Gatt fail!, deviceId=%s mainthread:%b", new Object[] { localObject, Boolean.valueOf(bool1) });
      }
      else
      {
        com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.ConnectAction", "Device not found, deviceId=%s", new Object[] { this.a });
      }
      b(j.b);
      d();
      return;
    }
    com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.ConnectAction", "action:%s, unspecified deviceId", new Object[] { this });
    b(j.r);
    d();
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.ConnectAction", "[onServicesDiscovered] status:%s", new Object[] { f.a(paramInt) });
    this.f.a(paramBluetoothGatt);
    if (paramInt == 0) {
      b(j.a);
    } else {
      b(j.s);
    }
    d();
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramBluetoothGatt != null) {
      localObject = paramBluetoothGatt.toString();
    } else {
      localObject = "";
    }
    String str2 = f.a(paramInt1);
    String str1;
    if (paramInt2 == 2) {
      str1 = "CONNECTED";
    } else {
      str1 = "DISCONNECTED";
    }
    com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange]gatt:%s gattStatus:%s, newState:%s", new Object[] { localObject, str2, str1 });
    this.f.a(paramBluetoothGatt);
    if (paramInt2 == 2)
    {
      if (paramBluetoothGatt == null)
      {
        com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.ConnectAction", "[onConnectionStateChange] gatt is null", new Object[0]);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onConnectionStateChange] discoverServicesDelayMills: ");
      ((StringBuilder)localObject).append(this.d);
      com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.ConnectAction", ((StringBuilder)localObject).toString(), new Object[0]);
      this.h.postDelayed(new b.1(this, paramBluetoothGatt), this.d);
      return;
    }
    if (paramInt2 == 0) {
      this.h.post(new b.2(this, paramInt1));
    }
  }
  
  public void a(j paramj)
  {
    if (paramj.u != 10012) {
      return;
    }
    this.f.a(false);
  }
  
  public String b()
  {
    return "ConnectAction";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConnectAction#");
    localStringBuilder.append(this.p);
    localStringBuilder.append("{deviceId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", debug=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", mainThread=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", serial=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kj.b
 * JD-Core Version:    0.7.0.1
 */