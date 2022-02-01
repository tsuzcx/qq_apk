package androidx.core.app;

import android.content.ComponentName;
import android.support.v4.app.INotificationSideChannel;
import java.util.ArrayDeque;

class NotificationManagerCompat$SideChannelManager$ListenerRecord
{
  boolean bound = false;
  final ComponentName componentName;
  int retryCount = 0;
  INotificationSideChannel service;
  ArrayDeque<NotificationManagerCompat.Task> taskQueue = new ArrayDeque();
  
  NotificationManagerCompat$SideChannelManager$ListenerRecord(ComponentName paramComponentName)
  {
    this.componentName = paramComponentName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord
 * JD-Core Version:    0.7.0.1
 */