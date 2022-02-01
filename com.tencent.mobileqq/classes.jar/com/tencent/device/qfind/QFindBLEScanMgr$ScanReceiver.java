package com.tencent.device.qfind;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class QFindBLEScanMgr$ScanReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("QFindBLEScanMgr alarm is coming ");
      paramContext.append(paramIntent.getAction());
      QLog.i("QFindBLE", 2, paramContext.toString());
    }
    if (this.a.a != null)
    {
      if (System.currentTimeMillis() - QFindBLEScanMgr.a(this.a) < this.a.h) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE", 2, "QFindBLEScanMgr startScan");
      }
      this.a.a.post(new QFindBLEScanMgr.ScanReceiver.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.ScanReceiver
 * JD-Core Version:    0.7.0.1
 */