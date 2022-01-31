package com.tencent.commonsdk.util.notification;

import com.tencent.qphone.base.util.QLog;

public class NotificationLimiterUtil
{
  static NotificationLimiter s_notificationLimiter;
  
  public static void setLimiter(NotificationLimiter paramNotificationLimiter)
  {
    s_notificationLimiter = paramNotificationLimiter;
  }
  
  public static boolean shouldNotify(int paramInt)
  {
    if (s_notificationLimiter != null) {}
    for (boolean bool = s_notificationLimiter.shouldNotify(paramInt);; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQNotification", 2, "studymode_fight notify id:" + paramInt + ",s_notificationLimiter " + s_notificationLimiter + ",result = " + bool);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.util.notification.NotificationLimiterUtil
 * JD-Core Version:    0.7.0.1
 */