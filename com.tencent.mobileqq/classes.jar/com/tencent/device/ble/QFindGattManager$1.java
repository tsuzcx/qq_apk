package com.tencent.device.ble;

import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class QFindGattManager$1
  extends MqqHandler
{
  QFindGattManager$1(QFindGattManager paramQFindGattManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE2", 2, "QFindGattManager write data timeout bleSN " + (String)paramMessage.obj);
      }
      QFindGattManager.a(this.a, paramMessage.arg1);
      this.a.a((String)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.ble.QFindGattManager.1
 * JD-Core Version:    0.7.0.1
 */