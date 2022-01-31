package com.tencent.device.ble;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.qfind.BluetoothLeService;
import com.tencent.device.qfind.PeerInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import qba;
import qbb;
import qbc;

@TargetApi(18)
public class QFindGattManager
{
  static int jdField_a_of_type_Int = 1000;
  private static QFindGattManager jdField_a_of_type_ComTencentDeviceBleQFindGattManager;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new qbc(this);
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new qbb(this);
  private BluetoothLeService jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService;
  public PeerInfo a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  public MqqHandler a;
  private boolean jdField_a_of_type_Boolean;
  private List b = new ArrayList();
  private List c = new ArrayList();
  
  public QFindGattManager()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new qba(this, Looper.getMainLooper());
    Object localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, BluetoothLeService.class);
    this.jdField_a_of_type_AndroidContentContext.bindService((Intent)localObject, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_CONNECTED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_DISCONNECTED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_SET_NOTIFICATION_FAILED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_NOT_QQ");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_DATA_AVAILABLE");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_DATA_WRITE_RST");
    ((IntentFilter)localObject).addAction("onDeviceVerifyRsp");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static QFindGattManager a()
  {
    if ((jdField_a_of_type_ComTencentDeviceBleQFindGattManager == null) && (BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))) {
      jdField_a_of_type_ComTencentDeviceBleQFindGattManager = new QFindGattManager();
    }
    return jdField_a_of_type_ComTencentDeviceBleQFindGattManager;
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent("QFIND_BLE_CONNECT_ERROR");
    Bundle localBundle = new Bundle();
    localBundle.putInt("bleId", paramInt);
    localIntent.putExtras(localBundle);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  public static void b()
  {
    if (jdField_a_of_type_ComTencentDeviceBleQFindGattManager != null) {
      jdField_a_of_type_ComTencentDeviceBleQFindGattManager.a();
    }
  }
  
  public PeerInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo != null) && (this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo.jdField_a_of_type_Int == paramInt)) {
      return this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    PeerInfo localPeerInfo;
    while (localIterator.hasNext())
    {
      localPeerInfo = (PeerInfo)localIterator.next();
      if (localPeerInfo.jdField_a_of_type_Int == paramInt) {
        return localPeerInfo;
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      localPeerInfo = (PeerInfo)localIterator.next();
      if (localPeerInfo.jdField_a_of_type_Int == paramInt) {
        return localPeerInfo;
      }
    }
    return null;
  }
  
  public PeerInfo a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo != null) && (this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo.a().equals(paramString))) {
      return this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    PeerInfo localPeerInfo;
    while (localIterator.hasNext())
    {
      localPeerInfo = (PeerInfo)localIterator.next();
      if (localPeerInfo.a().equals(paramString)) {
        return localPeerInfo;
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      localPeerInfo = (PeerInfo)localIterator.next();
      if (localPeerInfo.a().equals(paramString)) {
        return localPeerInfo;
      }
    }
    localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      localPeerInfo = (PeerInfo)localIterator.next();
      if (localPeerInfo.a().equals(paramString)) {
        return localPeerInfo;
      }
    }
    return null;
  }
  
  public void a()
  {
    if ((BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentServiceConnection = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService = null;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService != null) {
      this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.a(paramInt, paramArrayOfByte);
    }
    paramArrayOfByte = a(paramInt);
    if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (paramArrayOfByte != null))
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(100);
      localMessage.arg1 = paramInt;
      localMessage.obj = paramArrayOfByte.a();
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 100000L);
    }
  }
  
  public void a(PeerInfo paramPeerInfo)
  {
    QLog.i("DeviceBLE2", 2, "disConnectPeer " + paramPeerInfo.a());
    if (this.jdField_a_of_type_JavaUtilList.contains(paramPeerInfo))
    {
      this.jdField_a_of_type_JavaUtilSet.add(paramPeerInfo);
      this.jdField_a_of_type_JavaUtilList.remove(paramPeerInfo);
      this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.a(paramPeerInfo.jdField_a_of_type_Int);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(100);
      }
      return;
      if (paramPeerInfo == this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo)
      {
        this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo = null;
        this.jdField_a_of_type_JavaUtilSet.add(paramPeerInfo);
        this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.a(paramPeerInfo.jdField_a_of_type_Int);
      }
      else if (this.c.contains(paramPeerInfo))
      {
        this.c.remove(paramPeerInfo);
      }
    }
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      a(paramString);
    }
  }
  
  public boolean a(PeerInfo paramPeerInfo)
  {
    boolean bool = false;
    if (((this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo != null) && (this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo.b.equals(paramPeerInfo.b))) || (this.jdField_a_of_type_JavaUtilList.contains(paramPeerInfo))) {
      bool = true;
    }
    do
    {
      do
      {
        do
        {
          return bool;
          if (this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo == null) {
            break;
          }
        } while (this.c.contains(paramPeerInfo));
        this.c.add(paramPeerInfo);
        return false;
        if (this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService == null) {
          break;
        }
      } while (!this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.a(paramPeerInfo.jdField_a_of_type_Int, paramPeerInfo.b));
      this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo = paramPeerInfo;
      return true;
    } while (this.c.contains(paramPeerInfo));
    this.c.add(paramPeerInfo);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.ble.QFindGattManager
 * JD-Core Version:    0.7.0.1
 */