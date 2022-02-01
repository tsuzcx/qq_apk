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

@TargetApi(18)
public class QFindGattManager
{
  static int jdField_a_of_type_Int = 1000;
  private static QFindGattManager jdField_a_of_type_ComTencentDeviceBleQFindGattManager;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QFindGattManager.3(this);
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new QFindGattManager.2(this);
  private BluetoothLeService jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService;
  PeerInfo jdField_a_of_type_ComTencentDeviceQfindPeerInfo;
  private List<PeerInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<PeerInfo> jdField_a_of_type_JavaUtilSet = new HashSet();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new QFindGattManager.1(this, Looper.getMainLooper());
  private boolean jdField_a_of_type_Boolean = false;
  private List<PeerInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private List<PeerInfo> c = new ArrayList();
  
  public QFindGattManager()
  {
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
    this.jdField_b_of_type_Boolean = true;
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
    QFindGattManager localQFindGattManager = jdField_a_of_type_ComTencentDeviceBleQFindGattManager;
    if (localQFindGattManager != null) {
      localQFindGattManager.a();
    }
  }
  
  public PeerInfo a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo;
    if ((localObject != null) && (((PeerInfo)localObject).a == paramInt)) {
      return this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo;
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    PeerInfo localPeerInfo;
    while (((Iterator)localObject).hasNext())
    {
      localPeerInfo = (PeerInfo)((Iterator)localObject).next();
      if (localPeerInfo.a == paramInt) {
        return localPeerInfo;
      }
    }
    localObject = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localPeerInfo = (PeerInfo)((Iterator)localObject).next();
      if (localPeerInfo.a == paramInt) {
        return localPeerInfo;
      }
    }
    return null;
  }
  
  public PeerInfo a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo;
    if ((localObject != null) && (((PeerInfo)localObject).a().equals(paramString))) {
      return this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo;
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    PeerInfo localPeerInfo;
    while (((Iterator)localObject).hasNext())
    {
      localPeerInfo = (PeerInfo)((Iterator)localObject).next();
      if (localPeerInfo.a().equals(paramString)) {
        return localPeerInfo;
      }
    }
    localObject = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localPeerInfo = (PeerInfo)((Iterator)localObject).next();
      if (localPeerInfo.a().equals(paramString)) {
        return localPeerInfo;
      }
    }
    localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localPeerInfo = (PeerInfo)((Iterator)localObject).next();
      if (localPeerInfo.a().equals(paramString)) {
        return localPeerInfo;
      }
    }
    return null;
  }
  
  public void a()
  {
    if ((BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentServiceConnection = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService = null;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService;
    if (localObject != null) {
      ((BluetoothLeService)localObject).a(paramInt, paramArrayOfByte);
    }
    paramArrayOfByte = a(paramInt);
    localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if ((localObject != null) && (paramArrayOfByte != null))
    {
      localObject = ((MqqHandler)localObject).obtainMessage(100);
      ((Message)localObject).arg1 = paramInt;
      ((Message)localObject).obj = paramArrayOfByte.a();
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, 100000L);
    }
  }
  
  public void a(PeerInfo paramPeerInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("disConnectPeer ");
    localStringBuilder.append(paramPeerInfo.a());
    QLog.i("DeviceBLE2", 2, localStringBuilder.toString());
    if (this.jdField_a_of_type_JavaUtilList.contains(paramPeerInfo))
    {
      this.jdField_a_of_type_JavaUtilSet.add(paramPeerInfo);
      this.jdField_a_of_type_JavaUtilList.remove(paramPeerInfo);
      this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.a(paramPeerInfo.a);
    }
    else if (paramPeerInfo == this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo)
    {
      this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo = null;
      this.jdField_a_of_type_JavaUtilSet.add(paramPeerInfo);
      this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService.a(paramPeerInfo.a);
    }
    else if (this.c.contains(paramPeerInfo))
    {
      this.c.remove(paramPeerInfo);
    }
    paramPeerInfo = this.jdField_a_of_type_MqqOsMqqHandler;
    if (paramPeerInfo != null) {
      paramPeerInfo.removeMessages(100);
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
    Object localObject = this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo;
    if (((localObject != null) && (((PeerInfo)localObject).b.equals(paramPeerInfo.b))) || (this.jdField_a_of_type_JavaUtilList.contains(paramPeerInfo))) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo != null)
    {
      if (!this.c.contains(paramPeerInfo))
      {
        this.c.add(paramPeerInfo);
        return false;
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentDeviceQfindBluetoothLeService;
      if (localObject != null)
      {
        if (((BluetoothLeService)localObject).a(paramPeerInfo.a, paramPeerInfo.b))
        {
          this.jdField_a_of_type_ComTencentDeviceQfindPeerInfo = paramPeerInfo;
          return true;
        }
      }
      else if (!this.c.contains(paramPeerInfo)) {
        this.c.add(paramPeerInfo);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.ble.QFindGattManager
 * JD-Core Version:    0.7.0.1
 */