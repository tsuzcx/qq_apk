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
      localStringBuilder.append("createNotification:String channel ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", int icon ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", CharSequence tickerText ");
      localStringBuilder.append(paramCharSequence);
      localStringBuilder.append(", long when");
      localStringBuilder.append(paramLong);
      QLog.d("NotificationFactory", 2, new Object[] { localStringBuilder });
    }
    if (SdkInfoUtil.isOreo())
    {
      if (paramString.isEmpty()) {
        paramString = new Notification.Builder(BaseApplication.getContext());
      } else {
        paramString = new Notification.Builder(BaseApplication.getContext(), paramString);
      }
      paramString.setSmallIcon(paramInt).setTicker(paramCharSequence).setWhen(paramLong);
      return paramString.build();
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
    NotificationCompat.Builder localBuilder1;
    if (SdkInfoUtil.isOreo())
    {
      NotificationCompat.Builder localBuilder2 = new NotificationCompat.Builder(BaseApplication.getContext());
      localBuilder1 = localBuilder2;
      if (!paramString.isEmpty())
      {
        localBuilder2.setChannelId(paramString);
        return localBuilder2;
      }
    }
    else
    {
      localBuilder1 = new NotificationCompat.Builder(BaseApplication.getContext());
    }
    return localBuilder1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.util.notification.NotificationFactory
 * JD-Core Version:    0.7.0.1
 */