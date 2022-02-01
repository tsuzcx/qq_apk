package com.tencent.commonsdk.util.notification;

public abstract interface NotificationReportController
{
  public static final int MSG_REPORT_NOTIFY_CLICK = 2;
  public static final int MSG_REPORT_NOTIFY_PUSH = 1;
  public static final int MSG_REPORT_NOTIFY_PUSH_FLUSH = 5;
  public static final int MSG_REPORT_QQLS_CLICK = 4;
  public static final int MSG_REPORT_QQLS_PUSH = 3;
  
  public abstract void report(int paramInt1, int paramInt2, String paramString, int paramInt3);
  
  public abstract void reportAll();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.util.notification.NotificationReportController
 * JD-Core Version:    0.7.0.1
 */