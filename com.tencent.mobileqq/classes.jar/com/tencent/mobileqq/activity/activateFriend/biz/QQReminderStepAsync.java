package com.tencent.mobileqq.activity.activateFriend.biz;

import agdj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class QQReminderStepAsync
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "mStepId: " + this.b);
    }
    try
    {
      ((agdj)this.a.app.getManager(378)).a();
      return 7;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQInitHandler", 1, "activateManager doLogin throw an exception: " + localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.QQReminderStepAsync
 * JD-Core Version:    0.7.0.1
 */