package com.tencent.mobileqq.activity.activateFriend.biz;

import com.tencent.mobileqq.activity.activateFriend.QQNotifyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.qphone.base.util.QLog;

public class QQReminderStepAsync
  extends AsyncStep
{
  protected int doStep()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("mStepId: ");
      localStringBuilder1.append(this.mStepId);
      QLog.d("QQInitHandler", 2, localStringBuilder1.toString());
    }
    try
    {
      ((IQQReminderDataService)this.mAutomator.k.getRuntimeService(IQQReminderDataService.class, "")).checkTodayReminder();
      QQNotifyHelper.a(this.mAutomator.k);
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("activateManager doLogin throw an exception: ");
        localStringBuilder2.append(localThrowable);
        QLog.e("QQInitHandler", 1, localStringBuilder2.toString());
      }
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.biz.QQReminderStepAsync
 * JD-Core Version:    0.7.0.1
 */