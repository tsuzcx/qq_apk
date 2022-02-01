package com.tencent.luggage.wxa.hd;

import android.bluetooth.BluetoothAdapter;
import androidx.annotation.RequiresPermission;

final class c$8
  extends c.b
{
  c$8(c.a parama)
  {
    super(parama);
  }
  
  @RequiresPermission("android.permission.BLUETOOTH")
  String a()
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if ((localBluetoothAdapter != null) && (localBluetoothAdapter.isEnabled())) {
      return localBluetoothAdapter.getAddress();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c.8
 * JD-Core Version:    0.7.0.1
 */