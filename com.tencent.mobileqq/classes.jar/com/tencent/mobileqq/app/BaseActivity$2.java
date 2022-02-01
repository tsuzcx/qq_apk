package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;

class BaseActivity$2
  implements Runnable
{
  BaseActivity$2(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    if (this.this$0.runnableRemoveNotification != null)
    {
      this.this$0.runnableRemoveNotification = null;
      if (this.this$0.app != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("notification", 2, "BaseActivity doOnWindowFocusChanged removeNotification Xiaomi-MI 5");
        }
        this.this$0.app.removeNotification();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity.2
 * JD-Core Version:    0.7.0.1
 */