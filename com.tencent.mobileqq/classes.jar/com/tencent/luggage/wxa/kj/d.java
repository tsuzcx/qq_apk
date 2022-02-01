package com.tencent.luggage.wxa.kj;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.kl.f;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.kn.c;
import java.util.UUID;

@TargetApi(18)
public class d
  extends com.tencent.luggage.wxa.kl.a
{
  private final String a;
  private final String b;
  private final boolean c;
  
  public d(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
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
    if (!c.e(((BluetoothGattCharacteristic)localObject).getProperties()))
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s, not support indicate", new Object[] { this });
      b(j.j);
      d();
      return;
    }
    if (!localBluetoothGatt.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, this.c))
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s bluetoothGatt.setCharacteristicNotification fail", new Object[] { this });
      b(j.k);
      d();
      return;
    }
    BluetoothGattDescriptor localBluetoothGattDescriptor = ((BluetoothGattCharacteristic)localObject).getDescriptor(com.tencent.luggage.wxa.kk.a.a);
    if (localBluetoothGattDescriptor == null)
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s gattCharacteristic.getDescriptor fail", new Object[] { this });
      b(j.m);
      d();
      return;
    }
    if (this.c) {
      localObject = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
    } else {
      localObject = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
    }
    if (!localBluetoothGattDescriptor.setValue((byte[])localObject))
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s gattDescriptor.setValue fail", new Object[] { this });
      b(j.n);
      d();
      return;
    }
    if (!localBluetoothGatt.writeDescriptor(localBluetoothGattDescriptor))
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeDescriptor fail", new Object[] { this });
      b(j.o);
      d();
      return;
    }
    b(j.a);
  }
  
  public String b()
  {
    return "IndicateCharacteristicAction";
  }
  
  public void b(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.Action", "action:%s onDescriptorWrite status:%s", new Object[] { this, f.a(paramInt) });
    d();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IndicateCharacteristicAction#");
    localStringBuilder.append(this.p);
    localStringBuilder.append("{serviceId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", characteristicId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", enable=");
    localStringBuilder.append(this.c);
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
 * Qualified Name:     com.tencent.luggage.wxa.kj.d
 * JD-Core Version:    0.7.0.1
 */