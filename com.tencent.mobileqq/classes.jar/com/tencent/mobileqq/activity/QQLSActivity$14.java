package com.tencent.mobileqq.activity;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.qphone.base.util.QLog;

class QQLSActivity$14
  implements Runnable
{
  QQLSActivity$14(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)this.this$0.getSystemService("power");
      this.this$0.k = localPowerManager.newWakeLock(268435462, "QQLSActivity");
      this.this$0.k.acquire(10000L);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("acquireBrightWakeLock:");
        localStringBuilder.append(localException.toString());
        QLog.e("QQLSActivity", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.14
 * JD-Core Version:    0.7.0.1
 */