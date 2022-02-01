package com.tencent.device.qfind;

import android.bluetooth.BluetoothAdapter;
import com.tencent.qphone.base.util.QLog;

class QFindBLEScanMgr$2
  implements Runnable
{
  QFindBLEScanMgr$2(QFindBLEScanMgr paramQFindBLEScanMgr) {}
  
  public void run()
  {
    if (this.this$0.l)
    {
      Object localObject = this.this$0;
      ((QFindBLEScanMgr)localObject).l = false;
      try
      {
        if (((QFindBLEScanMgr)localObject).j != null)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("call native mBluetoothAdapter.stopLeScan with cb=");
            ((StringBuilder)localObject).append(this.this$0.k);
            ((StringBuilder)localObject).append(", mScanning=");
            ((StringBuilder)localObject).append(this.this$0.l);
            QLog.i("QFindBLE", 2, ((StringBuilder)localObject).toString());
          }
          this.this$0.j.stopLeScan(this.this$0.k);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.2
 * JD-Core Version:    0.7.0.1
 */