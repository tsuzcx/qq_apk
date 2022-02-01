package com.tencent.luggage.wxa.kj;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ki.d;
import com.tencent.luggage.wxa.kl.f;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.kn.c;
import java.util.UUID;

@TargetApi(18)
public class g
  extends com.tencent.luggage.wxa.kl.a
{
  private final String a;
  private final String b;
  
  public g(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public void a()
  {
    BluetoothGatt localBluetoothGatt = this.f.c();
    if (localBluetoothGatt == null)
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s, bluetoothGatt is null", new Object[] { this });
      b(j.i);
      d();
      return;
    }
    if (!c.b(this.a))
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s, serviceId is illegal", new Object[] { this });
      b(j.g);
      d();
      return;
    }
    Object localObject = localBluetoothGatt.getService(UUID.fromString(this.a));
    if (localObject == null)
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s, gattService is null", new Object[] { this });
      b(j.g);
      d();
      return;
    }
    if (!c.b(this.b))
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s, characteristicId is illegal", new Object[] { this });
      b(j.h);
      d();
      return;
    }
    localObject = ((BluetoothGattService)localObject).getCharacteristic(UUID.fromString(this.b));
    if (localObject == null)
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s, gattCharacteristic is null", new Object[] { this });
      b(j.h);
      d();
      return;
    }
    if (!c.a(((BluetoothGattCharacteristic)localObject).getProperties()))
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s, not support read", new Object[] { this });
      b(j.j);
      d();
      return;
    }
    if (!localBluetoothGatt.readCharacteristic((BluetoothGattCharacteristic)localObject))
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s bluetoothGatt.readCharacteristic fail", new Object[] { this });
      b(j.k);
      d();
      return;
    }
    b(j.a);
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.Action", "action:%s onCharacteristicRead status:%s", new Object[] { this, f.a(paramInt) });
    d();
  }
  
  public String b()
  {
    return "ReadCharacteristicAction";
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadCharacteristicAction#");
    localStringBuilder.append(this.p);
    localStringBuilder.append("{serviceId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", characteristicId='");
    localStringBuilder.append(this.b);
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
 * Qualified Name:     com.tencent.luggage.wxa.kj.g
 * JD-Core Version:    0.7.0.1
 */