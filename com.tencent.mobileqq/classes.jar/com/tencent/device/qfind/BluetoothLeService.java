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
  public static String b = "0000fec7-0000-1000-8000-00805f9b34fb";
  public static String c = "0000fec8-0000-1000-8000-00805f9b34fb";
  public static String d = "0000fec9-0000-1000-8000-00805f9b34fb";
  public static String e = "0000fec7-feba-f1f1-99c0-7e0ce07d0c03";
  public static String f = "0000fec8-feba-f1f1-99c0-7e0ce07d0c03";
  public static String g = "0000fec9-feba-f1f1-99c0-7e0ce07d0c03";
  public static final UUID h = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
  BluetoothLeService.LocalBinder i = new BluetoothLeService.LocalBinder(this);
  private BluetoothManager j;
  private BluetoothAdapter k;
  private List<GattInfo> l = new ArrayList();
  private final BluetoothGattCallback m = new BluetoothLeService.1(this);
  
  private GattInfo a(BluetoothGatt paramBluetoothGatt)
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      GattInfo localGattInfo = (GattInfo)localIterator.next();
      if (localGattInfo.c == paramBluetoothGatt) {
        return localGattInfo;
      }
    }
    return null;
  }
  
  private void a(GattInfo paramGattInfo)
  {
    int i1 = paramGattInfo.i.length - paramGattInfo.j;
    if (i1 > 0)
    {
      int n = i1;
      if (i1 > 20) {
        n = 20;
      }
      paramGattInfo.e.setWriteType(2);
      Object localObject = Arrays.copyOfRange(paramGattInfo.i, paramGattInfo.j, paramGattInfo.j + n);
      paramGattInfo.e.setValue((byte[])localObject);
      boolean bool = paramGattInfo.c.writeCharacteristic(paramGattInfo.e);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("writeCharacteristic result=");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", len=");
        ((StringBuilder)localObject).append(n);
        ((StringBuilder)localObject).append(",sent=");
        ((StringBuilder)localObject).append(paramGattInfo.j);
        ((StringBuilder)localObject).append(", toSend=");
        ((StringBuilder)localObject).append(paramGattInfo.i.length);
        QLog.i("DeviceBLE_EX", 2, ((StringBuilder)localObject).toString());
      }
      paramGattInfo.j += n;
      if (paramGattInfo.j >= paramGattInfo.i.length)
      {
        paramGattInfo.i = null;
        paramGattInfo.j = 0;
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
    paramString.putExtra("com.tencent.device.ble.EXTRA_BLEID", paramBluetoothGatt.a);
    paramString.putExtra("com.tencent.device.ble.EXTRA_STATUS", paramInt);
    paramString.putExtra("com.tencent.device.ble.EXRTA_RESULT", paramBoolean);
    if ((paramBluetoothGattCharacteristic != null) && (paramBluetoothGattCharacteristic == paramBluetoothGatt.f)) {
      paramString.putExtra("com.tencent.device.ble.EXTRA_DATA", paramBluetoothGatt.f.getValue());
    }
    super.sendBroadcast(paramString);
  }
  
  private GattInfo c(int paramInt)
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      GattInfo localGattInfo = (GattInfo)localIterator.next();
      if (localGattInfo.a == paramInt) {
        return localGattInfo;
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    Object localObject = c(paramInt);
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
    if ((this.k != null) && (((GattInfo)localObject).c != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("disconnect ");
        localStringBuilder.append(((GattInfo)localObject).b);
        localStringBuilder.append(", bleId=");
        localStringBuilder.append(paramInt);
        QLog.e("DeviceBLE_EX", 2, localStringBuilder.toString());
      }
      ((GattInfo)localObject).c.disconnect();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("DeviceBLE_EX", 2, "BluetoothAdapter not initialized");
    }
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean)
  {
    if ((this.k != null) && (paramBluetoothGatt != null))
    {
      paramBoolean = paramBluetoothGatt.setCharacteristicNotification(paramBluetoothGattCharacteristic, paramBoolean);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCharacteristicNotification result=");
        localStringBuilder.append(paramBoolean);
        QLog.i("DeviceBLE_EX", 2, localStringBuilder.toString());
      }
      paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getDescriptor(h);
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
    if (this.j == null)
    {
      this.j = ((BluetoothManager)super.getSystemService("bluetooth"));
      if (this.j == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DeviceBLE_EX", 2, "Unable to initialize BluetoothManager.");
        }
        return false;
      }
    }
    this.k = this.j.getAdapter();
    if (this.k == null)
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
    Object localObject = this.k;
    if ((localObject != null) && (paramString != null) && (((BluetoothAdapter)localObject).isEnabled()))
    {
      localObject = c(paramInt);
      if ((localObject != null) && (((GattInfo)localObject).c != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceBLE_EX", 2, "Trying to use an existing mBluetoothGatt for connection.");
        }
        if (((GattInfo)localObject).c.connect())
        {
          ((GattInfo)localObject).h = 1;
          return true;
        }
        return false;
      }
      localObject = new GattInfo();
      ((GattInfo)localObject).a = paramInt;
      ((GattInfo)localObject).b = paramString;
      paramString = this.k.getRemoteDevice(paramString);
      ((GattInfo)localObject).h = 1;
      this.l.add(localObject);
      ((GattInfo)localObject).c = paramString.connectGatt(this, false, this.m);
      if (((GattInfo)localObject).c == null)
      {
        this.l.remove(localObject);
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
    GattInfo localGattInfo = c(paramInt);
    if (localGattInfo != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("blewrite(");
        localStringBuilder.append(localGattInfo.b);
        localStringBuilder.append(")=");
        localStringBuilder.append(paramArrayOfByte);
        QLog.i("DeviceBLE_EX", 2, localStringBuilder.toString());
      }
      if (localGattInfo.i != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DeviceBLE_EX", 2, "ble cannot send until the last one finish!");
        }
        return false;
      }
      localGattInfo.i = paramArrayOfByte;
      a(localGattInfo);
      return true;
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    Object localObject = c(paramInt);
    if (localObject != null)
    {
      if (((GattInfo)localObject).c != null)
      {
        ((GattInfo)localObject).c.close();
        ((GattInfo)localObject).c = null;
      }
      this.l.remove(localObject);
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
    return this.i;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      GattInfo localGattInfo = (GattInfo)localIterator.next();
      if (localGattInfo.c != null)
      {
        localGattInfo.c.close();
        localGattInfo.c = null;
      }
    }
    this.l.clear();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.BluetoothLeService
 * JD-Core Version:    0.7.0.1
 */