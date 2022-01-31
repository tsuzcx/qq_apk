package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import bdlz;
import com.tencent.qphone.base.util.QLog;

class QQLSActivity$11
  implements Runnable
{
  QQLSActivity$11(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    if (this.this$0.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSSensor", 2, "====openSensor===" + Thread.currentThread().getId());
      }
      this.this$0.a = new bdlz(this.this$0.getApplicationContext(), this.this$0);
      this.this$0.a.a();
      if (QQLSActivity.a(this.this$0).hasMessages(8)) {
        QQLSActivity.a(this.this$0).removeMessages(8);
      }
      Message localMessage = QQLSActivity.a(this.this$0).obtainMessage(8);
      QQLSActivity.a(this.this$0).sendMessageDelayed(localMessage, 1500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.11
 * JD-Core Version:    0.7.0.1
 */