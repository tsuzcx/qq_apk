package com.tencent.commonsdk.util.notification;

import android.app.Notification;
import android.app.Notification.Builder;
import android.support.v4.app.NotificationCompat.Builder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class NotificationFactory
{
  private static final String TAG = "NotificationFactory";
  
  public static Notification createNotification(String paramString, int paramInt, CharSequence paramCharSequence, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createNotification:String channel ").append(paramString).append(", int icon ").append(paramInt).append(", CharSequence tickerText ").append(paramCharSequence).append(", long when").append(paramLong);
      QLog.d("NotificationFactory", 2, new Object[] { localStringBuilder });
    }
    if (SdkInfoUtil.isOreo())
    {
      if (paramString.isEmpty()) {}
      for (paramString = new Notification.Builder(BaseApplication.getContext());; paramString = new Notification.Builder(BaseApplication.getContext(), paramString))
      {
        paramString.setSmallIcon(paramInt).setTicker(paramCharSequence).setWhen(paramLong);
        return paramString.build();
      }
    }
    return new Notification(paramInt, paramCharSequence, paramLong);
  }
  
  public static Notification.Builder createNotificationBuilder(String paramString)
  {
    if (SdkInfoUtil.isOreo())
    {
      if (paramString.isEmpty()) {
        return new Notification.Builder(BaseApplication.getContext());
      }
      return new Notification.Builder(BaseApplication.context, paramString);
    }
    return new Notification.Builder(BaseApplication.getContext());
  }
  
  public static NotificationCompat.Builder createNotificationCompatBuilder(String paramString)
  {
    if (SdkInfoUtil.isOreo())
    {
      NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(BaseApplication.getContext());
      if (!paramString.isEmpty()) {
        localBuilder.setChannelId(paramString);
      }
      return localBuilder;
    }
    return new NotificationCompat.Builder(BaseApplication.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.util.notification.NotificationFactory
 * JD-Core Version:    0.7.0.1
 */