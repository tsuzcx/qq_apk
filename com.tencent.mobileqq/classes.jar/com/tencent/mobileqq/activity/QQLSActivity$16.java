package com.tencent.mobileqq.activity;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QQLSActivity$16
  implements Runnable
{
  QQLSActivity$16(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    try
    {
      if (QQLSActivity.a(this.this$0) == 1)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.this$0.a);
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "unRegisterScreenListener real mScreenReceiver:" + this.this$0.a.hashCode() + "context :" + BaseApplicationImpl.getContext().hashCode());
        }
        QQLSActivity.a(this.this$0, 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "unRegisterScreenListener");
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("QQLSActivity", 2, "unRegisterScreenListener:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.16
 * JD-Core Version:    0.7.0.1
 */