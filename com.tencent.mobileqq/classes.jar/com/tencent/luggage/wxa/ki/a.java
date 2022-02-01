package com.tencent.luggage.wxa.ki;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.annotation.NonNull;

@TargetApi(18)
public class a
  extends BluetoothGattCallback
{
  @NonNull
  private final e a;
  
  public a(@NonNull e parame)
  {
    this.a = parame;
  }
  
  public void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    this.a.a(paramBluetoothGatt, paramBluetoothGattCharacteristic);
  }
  
  public void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    this.a.a(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
  }
  
  public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    this.a.b(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
  }
  
  public void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    this.a.a(paramBluetoothGatt, paramInt1, paramInt2);
  }
  
  public void onDescriptorRead(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    this.a.a(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
  }
  
  public void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    this.a.b(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
  }
  
  public void onMtuChanged(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    this.a.c(paramBluetoothGatt, paramInt1, paramInt2);
  }
  
  public void onReadRemoteRssi(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    this.a.b(paramBluetoothGatt, paramInt1, paramInt2);
  }
  
  public void onReliableWriteCompleted(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    this.a.b(paramBluetoothGatt, paramInt);
  }
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    this.a.a(paramBluetoothGatt, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ki.a
 * JD-Core Version:    0.7.0.1
 */