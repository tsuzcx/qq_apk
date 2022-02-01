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
      if (QQLSActivity.z(this.this$0) == 1)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.this$0.s);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("unRegisterScreenListener real mScreenReceiver:");
          localStringBuilder1.append(this.this$0.s.hashCode());
          localStringBuilder1.append("context :");
          localStringBuilder1.append(BaseApplicationImpl.getContext().hashCode());
          QLog.d("QQLSActivity", 2, localStringBuilder1.toString());
        }
        QQLSActivity.a(this.this$0, 0);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("QQLSActivity", 2, "unRegisterScreenListener");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("unRegisterScreenListener:");
        localStringBuilder2.append(localException.toString());
        QLog.e("QQLSActivity", 2, localStringBuilder2.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.16
 * JD-Core Version:    0.7.0.1
 */