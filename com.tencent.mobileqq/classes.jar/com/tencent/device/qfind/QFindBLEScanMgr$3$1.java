package com.tencent.device.qfind;

import android.bluetooth.BluetoothDevice;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class QFindBLEScanMgr$3$1
  implements Runnable
{
  QFindBLEScanMgr$3$1(QFindBLEScanMgr.3 param3, BluetoothDevice paramBluetoothDevice, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    BlePeerInfo localBlePeerInfo = new BlePeerInfo();
    localBlePeerInfo.a = this.a.getName();
    localBlePeerInfo.b = this.a.getAddress();
    localBlePeerInfo.m = false;
    BlePeerInfo.a(this.b, localBlePeerInfo);
    StringBuilder localStringBuilder;
    if ((localBlePeerInfo.c != null) && (localBlePeerInfo.c.contains("0000feba-0000-1000-8000-00805f9b34fb")))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onLeScan name=");
        localStringBuilder.append(localBlePeerInfo.a);
        localStringBuilder.append(" pid:");
        localStringBuilder.append(localBlePeerInfo.e);
        localStringBuilder.append(" address:");
        localStringBuilder.append(localBlePeerInfo.b);
        localStringBuilder.append(" ; blePeerInfo.ble_id = ");
        localStringBuilder.append(localBlePeerInfo.i);
        QLog.i("QFindBLE_ex", 2, localStringBuilder.toString());
      }
      if ((localBlePeerInfo.e == 0) || (localBlePeerInfo.d == null) || (!this.c.a.q.contains(new Long(localBlePeerInfo.e)))) {}
    }
    try
    {
      QFindBLEScanMgr.c(this.c.a);
      boolean bool1 = QFindBLEScanMgr.a(this.c.a, localBlePeerInfo);
      boolean bool2 = QFindBLEScanMgr.a(this.c.a, localBlePeerInfo, bool1);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onLeScan blePeerInfo.ble_id = ");
        localStringBuilder.append(localBlePeerInfo.i);
        localStringBuilder.append(" ; needReportLoc = ");
        localStringBuilder.append(bool1);
        localStringBuilder.append(" ; needReport = ");
        localStringBuilder.append(bool2);
        QLog.i("QFindBLE_ex", 2, localStringBuilder.toString());
      }
      if ((bool2) && (bool1)) {
        QFindBLEScanMgr.a(this.c.a, localBlePeerInfo.e, localBlePeerInfo.a());
      } else if (bool2) {
        QFindBLEScanMgr.a(this.c.a, localBlePeerInfo, null, false);
      }
    }
    catch (Exception localException)
    {
      label359:
      break label359;
    }
    this.c.a.w.postDelayed(new QFindBLEScanMgr.3.1.1(this), this.c.a.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.3.1
 * JD-Core Version:    0.7.0.1
 */