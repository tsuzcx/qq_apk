package com.tencent.device.qfind;

import android.annotation.TargetApi;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public class BluetoothLeService
  extends Service
{
  public static String a = "0000feba-0000-1000-8000-00805f9b34fb";
  public static final UUID a;
  public static String b = "0000fec7-0000-1000-8000-00805f9b34fb";
  public static String c = "0000fec8-0000-1000-8000-00805f9b34fb";
  public static String d = "0000fec9-0000-1000-8000-00805f9b34fb";
  public static String e = "0000fec7-feba-f1f1-99c0-7e0ce07d0c03";
  public static String f = "0000fec8-feba-f1f1-99c0-7e0ce07d0c03";
  public static String g = "0000fec9-feba-f1f1-99c0-7e0ce07d0c03";
  private BluetoothAdapter jdField_a_of_type_AndroidBluetoothBluetoothAdapter;
  private final BluetoothGattCallback jdField_a_of_type_AndroidBluetoothBluetoothGattCallback = new BluetoothLeService.1(this);
  private BluetoothManager jdField_a_of_type_AndroidBluetoothBluetoothManager;
  BluetoothLeService.LocalBinder jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService$LocalBinder = new BluetoothLeService.LocalBinder(this);
  private List<GattInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilUUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
  }
  
  private GattInfo a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      GattInfo localGattInfo = (GattInfo)localIterator.next();
      if (localGattInfo.jdField_a_of_type_Int == paramInt) {
        return localGattInfo;
      }
    }
    return null;
  }
  
  private GattInfo a(BluetoothGatt paramBluetoothGatt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      GattInfo localGattInfo = (GattInfo)localIterator.next();
      if (localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt == paramBluetoothGatt) {
        return localGattInfo;
      }
    }
    return null;
  }
  
  private void a(GattInfo paramGattInfo)
  {
    int j = paramGattInfo.jdField_a_of_type_ArrayOfByte.length - paramGattInfo.c;
    if (j > 0)
    {
      int i = j;
      if (j > 20) {
        i = 20;
      }
      paramGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic.setWriteType(2);
      Object localObject = Arrays.copyOfRange(paramGattInfo.jdField_a_of_type_ArrayOfByte, paramGattInfo.c, paramGattInfo.c + i);
      paramGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic.setValue((byte[])localObject);
      boolean bool = paramGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt.writeCharacteristic(paramGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("writeCharacteristic result=");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", len=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(",sent=");
        ((StringBuilder)localObject).append(paramGattInfo.c);
        ((StringBuilder)localObject).append(", toSend=");
        ((StringBuilder)localObject).append(paramGattInfo.jdField_a_of_type_ArrayOfByte.length);
        QLog.i("DeviceBLE_EX", 2, ((StringBuilder)localObject).toString());
      }
      paramGattInfo.c += i;
      if (paramGattInfo.c >= paramGattInfo.jdField_a_of_type_ArrayOfByte.length)
      {
        paramGattInfo.jdField_a_of_type_ArrayOfByte = null;
        paramGattInfo.c = 0;
      }
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = new Intent(paramString);
    paramString.putExtra("com.tencent.device.ble.EXTRA_BLEID", paramInt2);
    paramString.putExtra("com.tencent.device.ble.EXTRA_STATUS", paramInt1);
    super.sendBroadcast(paramString);
  }
  
  private void a(String paramString, int paramInt, BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean)
  {
    paramString = new Intent(paramString);
    paramBluetoothGatt = a(paramBluetoothGatt);
    if (paramBluetoothGatt == null) {
      return;
    }
    paramString.putExtra("com.tencent.device.ble.EXTRA_BLEID", paramBluetoothGatt.jdField_a_of_type_Int);
    paramString.putExtra("com.tencent.device.ble.EXTRA_STATUS", paramInt);
    paramString.putExtra("com.tencent.device.ble.EXRTA_RESULT", paramBoolean);
    if ((paramBluetoothGattCharacteristic != null) && (paramBluetoothGattCharacteristic == paramBluetoothGatt.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic)) {
      paramString.putExtra("com.tencent.device.ble.EXTRA_DATA", paramBluetoothGatt.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic.getValue());
    }
    super.sendBroadcast(paramString);
  }
  
  public void a(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("gattInfo is null for bleid=");
        ((StringBuilder)localObject).append(paramInt);
        QLog.e("DeviceBLE_EX", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if ((this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null) && (((GattInfo)localObject).jdField_a_of_type_AndroidBluetoothBluetoothGatt != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("disconnect ");
        localStringBuilder.append(((GattInfo)localObject).jdField_a_of_type_JavaLangString);
        localStringBuilder.append(", bleId=");
        localStringBuilder.append(paramInt);
        QLog.e("DeviceBLE_EX", 2, localStringBuilder.toString());
      }
      ((GattInfo)localObject).jdField_a_of_type_AndroidBluetoothBluetoothGatt.disconnect();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("DeviceBLE_EX", 2, "BluetoothAdapter not initialized");
    }
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null) && (paramBluetoothGatt != null))
    {
      paramBoolean = paramBluetoothGatt.setCharacteristicNotification(paramBluetoothGattCharacteristic, paramBoolean);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCharacteristicNotification result=");
        localStringBuilder.append(paramBoolean);
        QLog.i("DeviceBLE_EX", 2, localStringBuilder.toString());
      }
      paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getDescriptor(jdField_a_of_type_JavaUtilUUID);
      if (paramBluetoothGattCharacteristic == null) {
        return;
      }
      if (!paramBluetoothGattCharacteristic.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE)) {
        return;
      }
      if (!paramBluetoothGatt.writeDescriptor(paramBluetoothGattCharacteristic)) {
        a("com.tencent.device.ble.ACTION_GATT_SET_NOTIFICATION_FAILED", 0, paramBluetoothGatt, null, false);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("DeviceBLE_EX", 2, "BluetoothAdapter not initialized");
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothManager == null)
    {
      this.jdField_a_of_type_AndroidBluetoothBluetoothManager = ((BluetoothManager)super.getSystemService("bluetooth"));
      if (this.jdField_a_of_type_AndroidBluetoothBluetoothManager == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DeviceBLE_EX", 2, "Unable to initialize BluetoothManager.");
        }
        return false;
      }
    }
    this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter = this.jdField_a_of_type_AndroidBluetoothBluetoothManager.getAdapter();
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DeviceBLE_EX", 2, "Unable to obtain a BluetoothAdapter.");
      }
      return false;
    }
    return true;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter;
    if ((localObject != null) && (paramString != null) && (((BluetoothAdapter)localObject).isEnabled()))
    {
      localObject = a(paramInt);
      if ((localObject != null) && (((GattInfo)localObject).jdField_a_of_type_AndroidBluetoothBluetoothGatt != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceBLE_EX", 2, "Trying to use an existing mBluetoothGatt for connection.");
        }
        if (((GattInfo)localObject).jdField_a_of_type_AndroidBluetoothBluetoothGatt.connect())
        {
          ((GattInfo)localObject).jdField_b_of_type_Int = 1;
          return true;
        }
        return false;
      }
      localObject = new GattInfo();
      ((GattInfo)localObject).jdField_a_of_type_Int = paramInt;
      ((GattInfo)localObject).jdField_a_of_type_JavaLangString = paramString;
      paramString = this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.getRemoteDevice(paramString);
      ((GattInfo)localObject).jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      ((GattInfo)localObject).jdField_a_of_type_AndroidBluetoothBluetoothGatt = paramString.connectGatt(this, false, this.jdField_a_of_type_AndroidBluetoothBluetoothGattCallback);
      if (((GattInfo)localObject).jdField_a_of_type_AndroidBluetoothBluetoothGatt == null)
      {
        this.jdField_a_of_type_JavaUtilList.remove(localObject);
        if (QLog.isColorLevel()) {
          QLog.d("DeviceBLE_EX", 2, "connectGatt failed");
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DeviceBLE_EX", 2, "Trying to create a new connection.");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.w("DeviceBLE_EX", 2, "BluetoothAdapter not initialized or unspecified address.");
    }
    return false;
  }
  
  public boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    GattInfo localGattInfo = a(paramInt);
    if (localGattInfo != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("blewrite(");
        localStringBuilder.append(localGattInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(")=");
        localStringBuilder.append(paramArrayOfByte);
        QLog.i("DeviceBLE_EX", 2, localStringBuilder.toString());
      }
      if (localGattInfo.jdField_a_of_type_ArrayOfByte != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DeviceBLE_EX", 2, "ble cannot send until the last one finish!");
        }
        return false;
      }
      localGattInfo.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      a(localGattInfo);
      return true;
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      if (((GattInfo)localObject).jdField_a_of_type_AndroidBluetoothBluetoothGatt != null)
      {
        ((GattInfo)localObject).jdField_a_of_type_AndroidBluetoothBluetoothGatt.close();
        ((GattInfo)localObject).jdField_a_of_type_AndroidBluetoothBluetoothGatt = null;
      }
      this.jdField_a_of_type_JavaUtilList.remove(localObject);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("close gattInfo failed bleId:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("DeviceBLE_EX", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService$LocalBinder;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      GattInfo localGattInfo = (GattInfo)localIterator.next();
      if (localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null)
      {
        localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt.close();
        localGattInfo.jdField_a_of_type_AndroidBluetoothBluetoothGatt = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.qfind.BluetoothLeService
 * JD-Core Version:    0.7.0.1
 */