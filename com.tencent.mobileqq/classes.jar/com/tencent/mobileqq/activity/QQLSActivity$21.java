package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

class QQLSActivity$21
  implements Runnable
{
  QQLSActivity$21(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("moveTaskToBack", 2, "moveTaskToBackInSubThread");
    }
    try
    {
      this.this$0.moveTaskToBack(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("moveTaskToBack e=");
        localStringBuilder.append(localThrowable.toString());
        QLog.d("moveTaskToBack", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.21
 * JD-Core Version:    0.7.0.1
 */