package com.tencent.device.qfind;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class BluetoothLeService$1
  extends BluetoothGattCallback
{
  BluetoothLeService$1(BluetoothLeService paramBluetoothLeService) {}
  
  public void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCharacteristicChanged uuid=");
      ((StringBuilder)localObject).append(paramBluetoothGattCharacteristic.getUuid());
      QLog.i("DeviceBLE_EX", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BluetoothLeService.a(this.a, paramBluetoothGatt);
    if ((localObject != null) && (paramBluetoothGattCharacteristic == ((GattInfo)localObject).f))
    {
      BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_DATA_AVAILABLE", 0, paramBluetoothGatt, ((GattInfo)localObject).f, false);
      if (QLog.isColorLevel())
      {
        paramBluetoothGatt = new StringBuilder();
        paramBluetoothGatt.append("btvalue=");
        paramBluetoothGatt.append(HexUtil.bytes2HexStr(paramBluetoothGattCharacteristic.getValue()));
        QLog.i("DeviceBLE_EX", 2, paramBluetoothGatt.toString());
      }
    }
  }
  
  public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCharacteristicWrite status=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",uuid=");
      ((StringBuilder)localObject).append(paramBluetoothGattCharacteristic.getUuid());
      QLog.i("DeviceBLE_EX", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BluetoothLeService.a(this.a, paramBluetoothGatt);
    if (paramInt == 0)
    {
      if ((localObject != null) && (paramBluetoothGattCharacteristic == ((GattInfo)localObject).e))
      {
        if (((GattInfo)localObject).i != null)
        {
          BluetoothLeService.a(this.a, (GattInfo)localObject);
          return;
        }
        BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_DATA_WRITE_RST", paramInt, paramBluetoothGatt, null, true);
      }
    }
    else {
      BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_DATA_WRITE_RST", paramInt, paramBluetoothGatt, null, false);
    }
  }
  
  public void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    GattInfo localGattInfo = BluetoothLeService.a(this.a, paramBluetoothGatt);
    if (localGattInfo == null)
    {
      if (QLog.isColorLevel())
      {
        paramBluetoothGatt = new StringBuilder();
        paramBluetoothGatt.append("onConnectionStateChange but no gattInfo newState=");
        paramBluetoothGatt.append(paramInt2);
        QLog.i("DeviceBLE_EX", 2, paramBluetoothGatt.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnectionStateChange status=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" newState=");
      localStringBuilder.append(paramInt2);
      QLog.i("DeviceBLE_EX", 2, localStringBuilder.toString());
    }
    if ((paramInt1 == 0) && (paramInt2 != 0))
    {
      if (paramInt2 != 2) {
        break label273;
      }
      localGattInfo.h = 2;
      BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_CONNECTED", paramInt1, paramBluetoothGatt, null, false);
    }
    try
    {
      Thread.sleep(200L);
      label150:
      boolean bool = localGattInfo.c.discoverServices();
      if (QLog.isColorLevel())
      {
        QLog.i("DeviceBLE_EX", 2, "Connected to GATT server.");
        paramBluetoothGatt = new StringBuilder();
        paramBluetoothGatt.append("Attempting to start service discovery:");
        paramBluetoothGatt.append(bool);
        QLog.i("DeviceBLE_EX", 2, paramBluetoothGatt.toString());
        return;
        if (QLog.isColorLevel())
        {
          paramBluetoothGatt = new StringBuilder();
          paramBluetoothGatt.append("Disconnected from GATT server. status:");
          paramBluetoothGatt.append(paramInt1);
          QLog.i("DeviceBLE_EX", 2, paramBluetoothGatt.toString());
        }
        paramInt2 = localGattInfo.a;
        this.a.b(localGattInfo.a);
        BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_DISCONNECTED", paramInt1, paramInt2);
      }
      label273:
      return;
    }
    catch (Throwable paramBluetoothGatt)
    {
      break label150;
    }
  }
  
  public void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDescriptorWrite uuid=");
      localStringBuilder.append(paramBluetoothGattDescriptor.getUuid());
      localStringBuilder.append(",status=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",value=");
      localStringBuilder.append(paramBluetoothGattDescriptor.getValue());
      QLog.i("DeviceBLE_EX", 2, localStringBuilder.toString());
    }
    BluetoothLeService.a(this.a, paramBluetoothGatt);
    if (paramInt == 0)
    {
      BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED", paramInt, paramBluetoothGatt, null, false);
      return;
    }
    BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_SET_NOTIFICATION_FAILED", paramInt, paramBluetoothGatt, null, false);
  }
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    GattInfo localGattInfo;
    if (paramInt == 0)
    {
      localGattInfo = BluetoothLeService.a(this.a, paramBluetoothGatt);
      if (localGattInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("DeviceBLE_EX", 2, "onServicesDiscovered gattInfo is null");
        }
        return;
      }
      localGattInfo.d = localGattInfo.c.getService(UUID.fromString(BluetoothLeService.a));
      if (localGattInfo.d != null)
      {
        localGattInfo.e = localGattInfo.d.getCharacteristic(UUID.fromString(BluetoothLeService.e));
        if (localGattInfo.e == null) {
          localGattInfo.e = localGattInfo.d.getCharacteristic(UUID.fromString(BluetoothLeService.b));
        }
        localGattInfo.f = localGattInfo.d.getCharacteristic(UUID.fromString(BluetoothLeService.f));
        if (localGattInfo.f == null) {
          localGattInfo.f = localGattInfo.d.getCharacteristic(UUID.fromString(BluetoothLeService.c));
        }
        localGattInfo.g = localGattInfo.d.getCharacteristic(UUID.fromString(BluetoothLeService.g));
        if (localGattInfo.g == null) {
          localGattInfo.g = localGattInfo.d.getCharacteristic(UUID.fromString(BluetoothLeService.d));
        }
        if ((localGattInfo.e == null) || ((localGattInfo.e.getProperties() & 0x8) == 0) || (localGattInfo.f == null) || ((localGattInfo.f.getProperties() & 0x20) == 0) || (localGattInfo.g == null) || ((localGattInfo.g.getProperties() & 0x2) == 0)) {}
      }
    }
    try
    {
      Thread.sleep(1000L);
      label247:
      this.a.a(paramBluetoothGatt, localGattInfo.f, true);
      return;
      BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_NOT_QQ", paramInt, paramBluetoothGatt, null, false);
      return;
      BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_NOT_QQ", paramInt, paramBluetoothGatt, null, false);
      return;
      if (QLog.isColorLevel())
      {
        paramBluetoothGatt = new StringBuilder();
        paramBluetoothGatt.append("onServicesDiscovered received: ");
        paramBluetoothGatt.append(paramInt);
        QLog.w("DeviceBLE_EX", 2, paramBluetoothGatt.toString());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label247;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.BluetoothLeService.1
 * JD-Core Version:    0.7.0.1
 */