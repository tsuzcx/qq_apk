package com.tencent.mobileqq.app.lifecycle;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class BaseActivityLifecycleCallbackImpl$1
  implements Runnable
{
  BaseActivityLifecycleCallbackImpl$1(BaseActivityLifecycleCallbackImpl paramBaseActivityLifecycleCallbackImpl, QBaseActivity paramQBaseActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.a.getRunnableRemoveNotification() != null)
    {
      this.a.setRunnableRemoveNotification(null);
      if (this.b != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("notification", 2, "BaseActivity doOnWindowFocusChanged removeNotification Xiaomi-MI 5");
        }
        this.b.removeNotification();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */