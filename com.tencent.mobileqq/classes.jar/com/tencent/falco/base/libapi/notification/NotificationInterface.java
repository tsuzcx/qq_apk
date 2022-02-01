package com.tencent.falco.base.libapi.notification;

import android.app.NotificationChannel;
import android.content.Context;
import androidx.core.app.NotificationCompat.Builder;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface NotificationInterface
  extends ServiceBaseInterface
{
  public abstract void cancel();
  
  public abstract void cancel(int paramInt);
  
  public abstract void cancelAll();
  
  public abstract NotificationChannel createNotificationChannel(NotificationChannelConstant paramNotificationChannelConstant);
  
  public abstract NotificationCompat.Builder getNotificationBuilder(Context paramContext);
  
  public abstract NotificationCompat.Builder getNotificationBuilder(Context paramContext, NotificationChannelConstant paramNotificationChannelConstant);
  
  public abstract NotificationCompat.Builder getNotificationBuilder(Context paramContext, String paramString);
  
  public abstract void setAdapter(NotificationServiceAdapter paramNotificationServiceAdapter);
  
  public abstract void show(int paramInt, NotificationCompat.Builder paramBuilder);
  
  public abstract void show(NotificationCompat.Builder paramBuilder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.notification.NotificationInterface
 * JD-Core Version:    0.7.0.1
 */