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
  static int b = 1000;
  private static QFindGattManager l;
  PeerInfo a;
  MqqHandler c = new QFindGattManager.1(this, Looper.getMainLooper());
  private BluetoothLeService d;
  private Context e = BaseApplicationImpl.getContext();
  private boolean f = false;
  private List<PeerInfo> g = new ArrayList();
  private Set<PeerInfo> h = new HashSet();
  private List<PeerInfo> i = new ArrayList();
  private List<PeerInfo> j = new ArrayList();
  private boolean k = false;
  private ServiceConnection m = new QFindGattManager.2(this);
  private BroadcastReceiver n = new QFindGattManager.3(this);
  
  public QFindGattManager()
  {
    Object localObject = new Intent(this.e, BluetoothLeService.class);
    this.e.bindService((Intent)localObject, this.m, 1);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_CONNECTED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_DISCONNECTED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_SET_NOTIFICATION_FAILED");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_GATT_NOT_QQ");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_DATA_AVAILABLE");
    ((IntentFilter)localObject).addAction("com.tencent.device.ble.ACTION_DATA_WRITE_RST");
    ((IntentFilter)localObject).addAction("onDeviceVerifyRsp");
    this.e.registerReceiver(this.n, (IntentFilter)localObject);
    this.k = true;
  }
  
  public static QFindGattManager a()
  {
    if ((l == null) && (BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))) {
      l = new QFindGattManager();
    }
    return l;
  }
  
  private void b(int paramInt)
  {
    Intent localIntent = new Intent("QFIND_BLE_CONNECT_ERROR");
    Bundle localBundle = new Bundle();
    localBundle.putInt("bleId", paramInt);
    localIntent.putExtras(localBundle);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  public static void c()
  {
    QFindGattManager localQFindGattManager = l;
    if (localQFindGattManager != null) {
      localQFindGattManager.b();
    }
  }
  
  public PeerInfo a(int paramInt)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((PeerInfo)localObject).a == paramInt)) {
      return this.a;
    }
    localObject = this.g.iterator();
    PeerInfo localPeerInfo;
    while (((Iterator)localObject).hasNext())
    {
      localPeerInfo = (PeerInfo)((Iterator)localObject).next();
      if (localPeerInfo.a == paramInt) {
        return localPeerInfo;
      }
    }
    localObject = this.h.iterator();
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
    Object localObject = this.a;
    if ((localObject != null) && (((PeerInfo)localObject).a().equals(paramString))) {
      return this.a;
    }
    localObject = this.g.iterator();
    PeerInfo localPeerInfo;
    while (((Iterator)localObject).hasNext())
    {
      localPeerInfo = (PeerInfo)((Iterator)localObject).next();
      if (localPeerInfo.a().equals(paramString)) {
        return localPeerInfo;
      }
    }
    localObject = this.h.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localPeerInfo = (PeerInfo)((Iterator)localObject).next();
      if (localPeerInfo.a().equals(paramString)) {
        return localPeerInfo;
      }
    }
    localObject = this.j.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localPeerInfo = (PeerInfo)((Iterator)localObject).next();
      if (localPeerInfo.a().equals(paramString)) {
        return localPeerInfo;
      }
    }
    return null;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((BluetoothLeService)localObject).a(paramInt, paramArrayOfByte);
    }
    paramArrayOfByte = a(paramInt);
    localObject = this.c;
    if ((localObject != null) && (paramArrayOfByte != null))
    {
      localObject = ((MqqHandler)localObject).obtainMessage(100);
      ((Message)localObject).arg1 = paramInt;
      ((Message)localObject).obj = paramArrayOfByte.a();
      this.c.sendMessageDelayed((Message)localObject, 100000L);
    }
  }
  
  public boolean a(PeerInfo paramPeerInfo)
  {
    Object localObject = this.a;
    if (((localObject != null) && (((PeerInfo)localObject).c.equals(paramPeerInfo.c))) || (this.g.contains(paramPeerInfo))) {
      return true;
    }
    if (this.a != null)
    {
      if (!this.j.contains(paramPeerInfo))
      {
        this.j.add(paramPeerInfo);
        return false;
      }
    }
    else
    {
      localObject = this.d;
      if (localObject != null)
      {
        if (((BluetoothLeService)localObject).a(paramPeerInfo.a, paramPeerInfo.c))
        {
          this.a = paramPeerInfo;
          return true;
        }
      }
      else if (!this.j.contains(paramPeerInfo)) {
        this.j.add(paramPeerInfo);
      }
    }
    return false;
  }
  
  public void b()
  {
    if ((BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) && (this.k))
    {
      this.e.unregisterReceiver(this.n);
      this.e.unbindService(this.m);
    }
    this.k = false;
    this.m = null;
    this.n = null;
    this.d = null;
  }
  
  public void b(PeerInfo paramPeerInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("disConnectPeer ");
    localStringBuilder.append(paramPeerInfo.a());
    QLog.i("DeviceBLE2", 2, localStringBuilder.toString());
    if (this.g.contains(paramPeerInfo))
    {
      this.h.add(paramPeerInfo);
      this.g.remove(paramPeerInfo);
      this.d.a(paramPeerInfo.a);
    }
    else if (paramPeerInfo == this.a)
    {
      this.a = null;
      this.h.add(paramPeerInfo);
      this.d.a(paramPeerInfo.a);
    }
    else if (this.j.contains(paramPeerInfo))
    {
      this.j.remove(paramPeerInfo);
    }
    paramPeerInfo = this.c;
    if (paramPeerInfo != null) {
      paramPeerInfo.removeMessages(100);
    }
  }
  
  public void b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.ble.QFindGattManager
 * JD-Core Version:    0.7.0.1
 */