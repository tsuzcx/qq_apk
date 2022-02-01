package com.tencent.device.qfind;

import abme;
import abmf;
import abmj;
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
  public static String a;
  public static final UUID a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  abmf jdField_a_of_type_Abmf = new abmf(this);
  private BluetoothAdapter jdField_a_of_type_AndroidBluetoothBluetoothAdapter;
  private final BluetoothGattCallback jdField_a_of_type_AndroidBluetoothBluetoothGattCallback = new abme(this);
  private BluetoothManager jdField_a_of_type_AndroidBluetoothBluetoothManager;
  private List<abmj> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = "0000feba-0000-1000-8000-00805f9b34fb";
    b = "0000fec7-0000-1000-8000-00805f9b34fb";
    c = "0000fec8-0000-1000-8000-00805f9b34fb";
    d = "0000fec9-0000-1000-8000-00805f9b34fb";
    e = "0000fec7-feba-f1f1-99c0-7e0ce07d0c03";
    f = "0000fec8-feba-f1f1-99c0-7e0ce07d0c03";
    g = "0000fec9-feba-f1f1-99c0-7e0ce07d0c03";
    jdField_a_of_type_JavaUtilUUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
  }
  
  private abmj a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      abmj localabmj = (abmj)localIterator.next();
      if (localabmj.jdField_a_of_type_Int == paramInt) {
        return localabmj;
      }
    }
    return null;
  }
  
  private abmj a(BluetoothGatt paramBluetoothGatt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      abmj localabmj = (abmj)localIterator.next();
      if (localabmj.jdField_a_of_type_AndroidBluetoothBluetoothGatt == paramBluetoothGatt) {
        return localabmj;
      }
    }
    return null;
  }
  
  private void a(abmj paramabmj)
  {
    int i = 20;
    int j = paramabmj.jdField_a_of_type_ArrayOfByte.length - paramabmj.c;
    if (j > 0) {
      if (j <= 20) {
        break label173;
      }
    }
    for (;;)
    {
      paramabmj.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic.setWriteType(2);
      byte[] arrayOfByte = Arrays.copyOfRange(paramabmj.jdField_a_of_type_ArrayOfByte, paramabmj.c, paramabmj.c + i);
      paramabmj.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic.setValue(arrayOfByte);
      boolean bool = paramabmj.jdField_a_of_type_AndroidBluetoothBluetoothGatt.writeCharacteristic(paramabmj.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic);
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "writeCharacteristic result=" + bool + ", len=" + i + ",sent=" + paramabmj.c + ", toSend=" + paramabmj.jdField_a_of_type_ArrayOfByte.length);
      }
      paramabmj.c = (i + paramabmj.c);
      if (paramabmj.c >= paramabmj.jdField_a_of_type_ArrayOfByte.length)
      {
        paramabmj.jdField_a_of_type_ArrayOfByte = null;
        paramabmj.c = 0;
      }
      return;
      label173:
      i = j;
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
    abmj localabmj = a(paramInt);
    if (localabmj == null) {
      if (QLog.isColorLevel()) {
        QLog.e("DeviceBLE_EX", 2, "gattInfo is null for bleid=" + paramInt);
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null) && (localabmj.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("DeviceBLE_EX", 2, "BluetoothAdapter not initialized");
    return;
    if (QLog.isColorLevel()) {
      QLog.e("DeviceBLE_EX", 2, "disconnect " + localabmj.jdField_a_of_type_JavaLangString + ", bleId=" + paramInt);
    }
    localabmj.jdField_a_of_type_AndroidBluetoothBluetoothGatt.disconnect();
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter == null) || (paramBluetoothGatt == null)) {
      if (QLog.isColorLevel()) {
        QLog.w("DeviceBLE_EX", 2, "BluetoothAdapter not initialized");
      }
    }
    do
    {
      return;
      paramBoolean = paramBluetoothGatt.setCharacteristicNotification(paramBluetoothGattCharacteristic, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "setCharacteristicNotification result=" + paramBoolean);
      }
      paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getDescriptor(jdField_a_of_type_JavaUtilUUID);
    } while ((paramBluetoothGattCharacteristic == null) || (!paramBluetoothGattCharacteristic.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE)) || (paramBluetoothGatt.writeDescriptor(paramBluetoothGattCharacteristic)));
    a("com.tencent.device.ble.ACTION_GATT_SET_NOTIFICATION_FAILED", 0, paramBluetoothGatt, null, false);
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
    boolean bool = true;
    if ((this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter == null) || (paramString == null) || (!this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.isEnabled()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("DeviceBLE_EX", 2, "BluetoothAdapter not initialized or unspecified address.");
      }
      bool = false;
    }
    do
    {
      return bool;
      abmj localabmj = a(paramInt);
      if ((localabmj != null) && (localabmj.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceBLE_EX", 2, "Trying to use an existing mBluetoothGatt for connection.");
        }
        if (localabmj.jdField_a_of_type_AndroidBluetoothBluetoothGatt.connect())
        {
          localabmj.jdField_b_of_type_Int = 1;
          return true;
        }
        return false;
      }
      localabmj = new abmj();
      localabmj.jdField_a_of_type_Int = paramInt;
      localabmj.jdField_a_of_type_JavaLangString = paramString;
      paramString = this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.getRemoteDevice(paramString);
      localabmj.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilList.add(localabmj);
      localabmj.jdField_a_of_type_AndroidBluetoothBluetoothGatt = paramString.connectGatt(this, false, this.jdField_a_of_type_AndroidBluetoothBluetoothGattCallback);
      if (localabmj.jdField_a_of_type_AndroidBluetoothBluetoothGatt == null)
      {
        this.jdField_a_of_type_JavaUtilList.remove(localabmj);
        if (QLog.isColorLevel()) {
          QLog.d("DeviceBLE_EX", 2, "connectGatt failed");
        }
        return false;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DeviceBLE_EX", 2, "Trying to create a new connection.");
    return true;
  }
  
  public boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    abmj localabmj = a(paramInt);
    if (localabmj != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "blewrite(" + localabmj.jdField_a_of_type_JavaLangString + ")=" + paramArrayOfByte);
      }
      if (localabmj.jdField_a_of_type_ArrayOfByte == null) {
        break label79;
      }
      if (QLog.isColorLevel()) {
        QLog.e("DeviceBLE_EX", 2, "ble cannot send until the last one finish!");
      }
    }
    return false;
    label79:
    localabmj.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    a(localabmj);
    return true;
  }
  
  public void b(int paramInt)
  {
    abmj localabmj = a(paramInt);
    if (localabmj != null)
    {
      if (localabmj.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null)
      {
        localabmj.jdField_a_of_type_AndroidBluetoothBluetoothGatt.close();
        localabmj.jdField_a_of_type_AndroidBluetoothBluetoothGatt = null;
      }
      this.jdField_a_of_type_JavaUtilList.remove(localabmj);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DeviceBLE_EX", 2, "close gattInfo failed bleId:" + paramInt);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.jdField_a_of_type_Abmf;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      abmj localabmj = (abmj)localIterator.next();
      if (localabmj.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null)
      {
        localabmj.jdField_a_of_type_AndroidBluetoothBluetoothGatt.close();
        localabmj.jdField_a_of_type_AndroidBluetoothBluetoothGatt = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.qfind.BluetoothLeService
 * JD-Core Version:    0.7.0.1
 */