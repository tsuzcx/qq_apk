package com.tencent.commonsdk.util.notification;

public class NotificationLimiterUtil
{
  static NotificationLimiter s_notificationLimiter;
  
  public static void setLimiter(NotificationLimiter paramNotificationLimiter)
  {
    s_notificationLimiter = paramNotificationLimiter;
  }
  
  public static boolean shouldNotify()
  {
    if (s_notificationLimiter != null) {
      return s_notificationLimiter.shouldNotify();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.util.notification.NotificationLimiterUtil
 * JD-Core Version:    0.7.0.1
 */