package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.IBinder;

public abstract class NotificationCompatSideChannelService
  extends Service
{
  public abstract void cancel(String paramString1, int paramInt, String paramString2);
  
  public abstract void cancelAll(String paramString);
  
  void checkPermission(int paramInt, String paramString)
  {
    Object localObject = getPackageManager().getPackagesForUid(paramInt);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].equals(paramString)) {
        return;
      }
      i += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("NotificationSideChannelService: Uid ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" is not authorized for package ");
    ((StringBuilder)localObject).append(paramString);
    paramString = new SecurityException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  public abstract void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification);
  
  public IBinder onBind(Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"))
    {
      if (Build.VERSION.SDK_INT > 19) {
        return null;
      }
      return new NotificationCompatSideChannelService.NotificationSideChannelStub(this);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.NotificationCompatSideChannelService
 * JD-Core Version:    0.7.0.1
 */