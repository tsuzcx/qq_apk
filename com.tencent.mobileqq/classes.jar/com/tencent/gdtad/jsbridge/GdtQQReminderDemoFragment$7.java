package com.tencent.gdtad.jsbridge;

import com.tencent.mobileqq.activity.activateFriend.QQReminderAMSHelper;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderSwitchObserver.QQReminderSwitchListener;

final class GdtQQReminderDemoFragment$7
  implements QQReminderSwitchObserver.QQReminderSwitchListener
{
  public void a(boolean paramBoolean)
  {
    GdtQQReminderDemoFragment.a(String.format("%s onResult allowed:%b switch:%b", new Object[] { "changeQQReminderSwitch", Boolean.valueOf(paramBoolean), Boolean.valueOf(QQReminderAMSHelper.a()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtQQReminderDemoFragment.7
 * JD-Core Version:    0.7.0.1
 */