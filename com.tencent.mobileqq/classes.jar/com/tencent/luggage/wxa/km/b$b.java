package com.tencent.luggage.wxa.km;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class b$b
  implements BluetoothAdapter.LeScanCallback
{
  private final List<f> a;
  private final WeakReference<e> b;
  
  b$b(List<f> paramList, e parame)
  {
    this.a = paramList;
    this.b = new WeakReference(parame);
  }
  
  public void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    e locale = (e)this.b.get();
    if (locale == null) {
      return;
    }
    paramBluetoothDevice = new h(paramBluetoothDevice, g.a(paramArrayOfByte), paramInt, System.currentTimeMillis());
    paramArrayOfByte = this.a;
    if (paramArrayOfByte == null)
    {
      locale.a(1, paramBluetoothDevice);
      return;
    }
    paramArrayOfByte = paramArrayOfByte.iterator();
    while (paramArrayOfByte.hasNext()) {
      if (((f)paramArrayOfByte.next()).a(paramBluetoothDevice)) {
        locale.a(1, paramBluetoothDevice);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.b.b
 * JD-Core Version:    0.7.0.1
 */