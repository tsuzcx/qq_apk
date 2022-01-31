package com.tencent.mobileqq.activity;

import bbig;
import com.tencent.qphone.base.util.QLog;

class QQLSActivity$2
  implements Runnable
{
  QQLSActivity$2(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSSensor", 2, "====shutSensor===" + Thread.currentThread().getId());
    }
    if (this.this$0.a != null)
    {
      this.this$0.a.b();
      this.this$0.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.2
 * JD-Core Version:    0.7.0.1
 */