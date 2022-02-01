package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.utils.QQLSSensor;
import com.tencent.qphone.base.util.QLog;

class QQLSActivity$2
  implements Runnable
{
  QQLSActivity$2(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("====shutSensor===");
      localStringBuilder.append(Thread.currentThread().getId());
      QLog.d("QQLSSensor", 2, localStringBuilder.toString());
    }
    if (this.this$0.j != null)
    {
      this.this$0.j.b();
      this.this$0.j = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.2
 * JD-Core Version:    0.7.0.1
 */