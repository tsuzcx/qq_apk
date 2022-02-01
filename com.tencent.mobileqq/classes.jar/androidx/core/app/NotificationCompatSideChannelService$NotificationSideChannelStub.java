package androidx.core.app;

import android.app.Notification;
import android.support.v4.app.INotificationSideChannel.Stub;

class NotificationCompatSideChannelService$NotificationSideChannelStub
  extends INotificationSideChannel.Stub
{
  NotificationCompatSideChannelService$NotificationSideChannelStub(NotificationCompatSideChannelService paramNotificationCompatSideChannelService) {}
  
  public void cancel(String paramString1, int paramInt, String paramString2)
  {
    this.this$0.checkPermission(getCallingUid(), paramString1);
    long l = clearCallingIdentity();
    try
    {
      this.this$0.cancel(paramString1, paramInt, paramString2);
      return;
    }
    finally
    {
      restoreCallingIdentity(l);
    }
  }
  
  public void cancelAll(String paramString)
  {
    this.this$0.checkPermission(getCallingUid(), paramString);
    long l = clearCallingIdentity();
    try
    {
      this.this$0.cancelAll(paramString);
      return;
    }
    finally
    {
      restoreCallingIdentity(l);
    }
  }
  
  public void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification)
  {
    this.this$0.checkPermission(getCallingUid(), paramString1);
    long l = clearCallingIdentity();
    try
    {
      this.this$0.notify(paramString1, paramInt, paramString2, paramNotification);
      return;
    }
    finally
    {
      restoreCallingIdentity(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.app.NotificationCompatSideChannelService.NotificationSideChannelStub
 * JD-Core Version:    0.7.0.1
 */