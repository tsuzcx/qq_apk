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
import zzh;
import zzi;
import zzm;

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
  private BluetoothAdapter jdField_a_of_type_AndroidBluetoothBluetoothAdapter;
  private final BluetoothGattCallback jdField_a_of_type_AndroidBluetoothBluetoothGattCallback = new zzh(this);
  private BluetoothManager jdField_a_of_type_AndroidBluetoothBluetoothManager;
  private List<zzm> jdField_a_of_type_JavaUtilList = new ArrayList();
  zzi jdField_a_of_type_Zzi = new zzi(this);
  
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
  
  private zzm a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      zzm localzzm = (zzm)localIterator.next();
      if (localzzm.jdField_a_of_type_Int == paramInt) {
        return localzzm;
      }
    }
    return null;
  }
  
  private zzm a(BluetoothGatt paramBluetoothGatt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      zzm localzzm = (zzm)localIterator.next();
      if (localzzm.jdField_a_of_type_AndroidBluetoothBluetoothGatt == paramBluetoothGatt) {
        return localzzm;
      }
    }
    return null;
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
  
  private void a(zzm paramzzm)
  {
    int i = 20;
    int j = paramzzm.jdField_a_of_type_ArrayOfByte.length - paramzzm.c;
    if (j > 0) {
      if (j <= 20) {
        break label173;
      }
    }
    for (;;)
    {
      paramzzm.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic.setWriteType(2);
      byte[] arrayOfByte = Arrays.copyOfRange(paramzzm.jdField_a_of_type_ArrayOfByte, paramzzm.c, paramzzm.c + i);
      paramzzm.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic.setValue(arrayOfByte);
      boolean bool = paramzzm.jdField_a_of_type_AndroidBluetoothBluetoothGatt.writeCharacteristic(paramzzm.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic);
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "writeCharacteristic result=" + bool + ", len=" + i + ",sent=" + paramzzm.c + ", toSend=" + paramzzm.jdField_a_of_type_ArrayOfByte.length);
      }
      paramzzm.c = (i + paramzzm.c);
      if (paramzzm.c >= paramzzm.jdField_a_of_type_ArrayOfByte.length)
      {
        paramzzm.jdField_a_of_type_ArrayOfByte = null;
        paramzzm.c = 0;
      }
      return;
      label173:
      i = j;
    }
  }
  
  public void a(int paramInt)
  {
    zzm localzzm = a(paramInt);
    if (localzzm == null) {
      if (QLog.isColorLevel()) {
        QLog.e("DeviceBLE_EX", 2, "gattInfo is null for bleid=" + paramInt);
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null) && (localzzm.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("DeviceBLE_EX", 2, "BluetoothAdapter not initialized");
    return;
    if (QLog.isColorLevel()) {
      QLog.e("DeviceBLE_EX", 2, "disconnect " + localzzm.jdField_a_of_type_JavaLangString + ", bleId=" + paramInt);
    }
    localzzm.jdField_a_of_type_AndroidBluetoothBluetoothGatt.disconnect();
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
      zzm localzzm = a(paramInt);
      if ((localzzm != null) && (localzzm.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceBLE_EX", 2, "Trying to use an existing mBluetoothGatt for connection.");
        }
        if (localzzm.jdField_a_of_type_AndroidBluetoothBluetoothGatt.connect())
        {
          localzzm.jdField_b_of_type_Int = 1;
          return true;
        }
        return false;
      }
      localzzm = new zzm();
      localzzm.jdField_a_of_type_Int = paramInt;
      localzzm.jdField_a_of_type_JavaLangString = paramString;
      paramString = this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.getRemoteDevice(paramString);
      localzzm.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilList.add(localzzm);
      localzzm.jdField_a_of_type_AndroidBluetoothBluetoothGatt = paramString.connectGatt(this, false, this.jdField_a_of_type_AndroidBluetoothBluetoothGattCallback);
      if (localzzm.jdField_a_of_type_AndroidBluetoothBluetoothGatt == null)
      {
        this.jdField_a_of_type_JavaUtilList.remove(localzzm);
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
    zzm localzzm = a(paramInt);
    if (localzzm != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "blewrite(" + localzzm.jdField_a_of_type_JavaLangString + ")=" + paramArrayOfByte);
      }
      if (localzzm.jdField_a_of_type_ArrayOfByte == null) {
        break label79;
      }
      if (QLog.isColorLevel()) {
        QLog.e("DeviceBLE_EX", 2, "ble cannot send until the last one finish!");
      }
    }
    return false;
    label79:
    localzzm.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    a(localzzm);
    return true;
  }
  
  public void b(int paramInt)
  {
    zzm localzzm = a(paramInt);
    if (localzzm != null)
    {
      if (localzzm.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null)
      {
        localzzm.jdField_a_of_type_AndroidBluetoothBluetoothGatt.close();
        localzzm.jdField_a_of_type_AndroidBluetoothBluetoothGatt = null;
      }
      this.jdField_a_of_type_JavaUtilList.remove(localzzm);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DeviceBLE_EX", 2, "close gattInfo failed bleId:" + paramInt);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.jdField_a_of_type_Zzi;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      zzm localzzm = (zzm)localIterator.next();
      if (localzzm.jdField_a_of_type_AndroidBluetoothBluetoothGatt != null)
      {
        localzzm.jdField_a_of_type_AndroidBluetoothBluetoothGatt.close();
        localzzm.jdField_a_of_type_AndroidBluetoothBluetoothGatt = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.qfind.BluetoothLeService
 * JD-Core Version:    0.7.0.1
 */