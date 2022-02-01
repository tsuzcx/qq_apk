package androidx.core.app;

import android.app.Notification;
import android.support.v4.app.INotificationSideChannel;
import androidx.annotation.NonNull;

class NotificationManagerCompat$NotifyTask
  implements NotificationManagerCompat.Task
{
  final int id;
  final Notification notif;
  final String packageName;
  final String tag;
  
  NotificationManagerCompat$NotifyTask(String paramString1, int paramInt, String paramString2, Notification paramNotification)
  {
    this.packageName = paramString1;
    this.id = paramInt;
    this.tag = paramString2;
    this.notif = paramNotification;
  }
  
  public void send(INotificationSideChannel paramINotificationSideChannel)
  {
    paramINotificationSideChannel.notify(this.packageName, this.id, this.tag, this.notif);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("NotifyTask[");
    localStringBuilder.append("packageName:").append(this.packageName);
    localStringBuilder.append(", id:").append(this.id);
    localStringBuilder.append(", tag:").append(this.tag);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.app.NotificationManagerCompat.NotifyTask
 * JD-Core Version:    0.7.0.1
 */