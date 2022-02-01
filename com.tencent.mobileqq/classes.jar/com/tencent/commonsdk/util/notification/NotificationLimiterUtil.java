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
    Object localObject = s_notificationLimiter;
    boolean bool;
    if (localObject != null) {
      bool = ((NotificationLimiter)localObject).shouldNotify(paramInt);
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("studymode_fight notify id:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",s_notificationLimiter ");
      ((StringBuilder)localObject).append(s_notificationLimiter);
      ((StringBuilder)localObject).append(",result = ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("QQNotification", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.util.notification.NotificationLimiterUtil
 * JD-Core Version:    0.7.0.1
 */