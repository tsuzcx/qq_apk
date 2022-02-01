package com.tencent.mobileqq.activity.activateFriend;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import mqq.app.MobileQQ;

class QQReminderJumpFragment$1
  implements Runnable
{
  QQReminderJumpFragment$1(QQReminderJumpFragment paramQQReminderJumpFragment, String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    localQQAppInterface.runOnUiThread(new QQReminderJumpFragment.1.1(this, ((IQQReminderCalendarService)localQQAppInterface.getRuntimeService(IQQReminderCalendarService.class, "")).queryCalendarEntity(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQReminderJumpFragment.1
 * JD-Core Version:    0.7.0.1
 */