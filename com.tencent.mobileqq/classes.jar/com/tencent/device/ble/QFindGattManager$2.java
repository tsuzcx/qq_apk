package com.tencent.device.ble;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.device.qfind.BluetoothLeService;
import com.tencent.device.qfind.BluetoothLeService.LocalBinder;
import com.tencent.device.qfind.PeerInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QFindGattManager$2
  implements ServiceConnection
{
  QFindGattManager$2(QFindGattManager paramQFindGattManager) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QFindGattManager.a(this.a, ((BluetoothLeService.LocalBinder)paramIBinder).a());
    if ((!QFindGattManager.a(this.a).a()) && (QLog.isColorLevel())) {
      QLog.e("DeviceBLE2", 2, "Unable to initialize Bluetooth");
    }
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE2", 2, "ServiceConnection onServiceConnected ");
    }
    if (!QFindGattManager.b(this.a).isEmpty())
    {
      paramComponentName = this.a;
      paramComponentName.a = ((PeerInfo)QFindGattManager.b(paramComponentName).get(0));
      QFindGattManager.b(this.a).remove(0);
      QFindGattManager.a(this.a).a(this.a.a.a, this.a.a.c);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QFindGattManager.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.ble.QFindGattManager.2
 * JD-Core Version:    0.7.0.1
 */