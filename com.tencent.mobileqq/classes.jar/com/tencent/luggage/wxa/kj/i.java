package com.tencent.luggage.wxa.kj;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ki.d;
import com.tencent.luggage.wxa.kl.f;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.kn.c;
import java.util.Arrays;
import java.util.UUID;

@TargetApi(18)
public class i
  extends com.tencent.luggage.wxa.kl.a
{
  private final String a;
  private final String b;
  private final String c;
  
  public i(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
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
    if ((!c.b(((BluetoothGattCharacteristic)localObject).getProperties())) && (!c.c(((BluetoothGattCharacteristic)localObject).getProperties())))
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s, not support write & writeNoResponse", new Object[] { this });
      b(j.j);
      d();
      return;
    }
    byte[] arrayOfByte = c.a(Base64.decode(this.c, 2));
    ((BluetoothGattCharacteristic)localObject).setValue(arrayOfByte);
    int i;
    if (arrayOfByte != null) {
      i = arrayOfByte.length;
    } else {
      i = 0;
    }
    com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.Action", "dataToWrite's length:%d", new Object[] { Integer.valueOf(i) });
    if (this.i) {
      com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.Action", "dataToWrite:%s", new Object[] { Arrays.toString(arrayOfByte) });
    }
    if (!localBluetoothGatt.writeCharacteristic((BluetoothGattCharacteristic)localObject))
    {
      com.tencent.luggage.wxa.kn.a.a("MicroMsg.Ble.Action", "action:%s bluetoothGatt.writeCharacteristic fail", new Object[] { this });
      b(j.k);
      d();
      return;
    }
    if ((!c.b(((BluetoothGattCharacteristic)localObject).getProperties())) && (c.c(((BluetoothGattCharacteristic)localObject).getProperties())))
    {
      b(j.a);
      d();
    }
  }
  
  public String b()
  {
    return "WriteCharacteristicAction";
  }
  
  public void b(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.Action", "action:%s onCharacteristicWrite status:%s", new Object[] { this, f.a(paramInt) });
    if (paramInt == 0) {
      b(j.a);
    }
    d();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WriteCharacteristicAction#");
    localStringBuilder.append(this.p);
    localStringBuilder.append("{serviceId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", characteristicId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", value='");
    localStringBuilder.append(this.c);
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
 * Qualified Name:     com.tencent.luggage.wxa.kj.i
 * JD-Core Version:    0.7.0.1
 */