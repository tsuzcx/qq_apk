package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.utils.QQLSSensor;
import com.tencent.qphone.base.util.QLog;

class QQLSActivity$11
  implements Runnable
{
  QQLSActivity$11(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    if (this.this$0.j == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("====openSensor===");
        ((StringBuilder)localObject).append(Thread.currentThread().getId());
        QLog.d("QQLSSensor", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.this$0;
      ((QQLSActivity)localObject).j = new QQLSSensor(((QQLSActivity)localObject).getApplicationContext(), this.this$0);
      this.this$0.j.a();
      if (QQLSActivity.f(this.this$0).hasMessages(8)) {
        QQLSActivity.f(this.this$0).removeMessages(8);
      }
      localObject = QQLSActivity.f(this.this$0).obtainMessage(8);
      QQLSActivity.f(this.this$0).sendMessageDelayed((Message)localObject, 1500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.11
 * JD-Core Version:    0.7.0.1
 */