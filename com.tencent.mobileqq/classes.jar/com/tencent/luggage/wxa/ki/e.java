package com.tencent.luggage.wxa.ki;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

public abstract interface e
{
  public abstract void a(BluetoothGatt paramBluetoothGatt, int paramInt);
  
  public abstract void a(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2);
  
  public abstract void a(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic);
  
  public abstract void a(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt);
  
  public abstract void a(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt);
  
  public abstract void b(BluetoothGatt paramBluetoothGatt, int paramInt);
  
  public abstract void b(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2);
  
  public abstract void b(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt);
  
  public abstract void b(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt);
  
  public abstract void c(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ki.e
 * JD-Core Version:    0.7.0.1
 */