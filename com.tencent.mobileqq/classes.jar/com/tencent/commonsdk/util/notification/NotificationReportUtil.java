package com.tencent.commonsdk.util.notification;

public class NotificationReportUtil
{
  static NotificationReportController s_notificationReportController;
  
  public static void reportAll()
  {
    NotificationReportController localNotificationReportController = s_notificationReportController;
    if (localNotificationReportController != null) {
      localNotificationReportController.reportAll();
    }
  }
  
  public static void reportNotification(int paramInt1, String paramString, int paramInt2)
  {
    NotificationReportController localNotificationReportController = s_notificationReportController;
    if (localNotificationReportController != null) {
      localNotificationReportController.report(1, paramInt1, paramString, paramInt2);
    }
  }
  
  public static void setReport(NotificationReportController paramNotificationReportController)
  {
    s_notificationReportController = paramNotificationReportController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.util.notification.NotificationReportUtil
 * JD-Core Version:    0.7.0.1
 */