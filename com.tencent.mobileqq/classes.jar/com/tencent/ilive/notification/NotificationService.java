package com.tencent.ilive.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat.Builder;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.notification.NotificationChannelConstant;
import com.tencent.falco.base.libapi.notification.NotificationIdConstant;
import com.tencent.falco.base.libapi.notification.NotificationInterface;
import com.tencent.falco.base.libapi.notification.NotificationServiceAdapter;

public class NotificationService
  implements NotificationInterface
{
  private static final NotificationChannelConstant DEFAULT_CHANNEL = NotificationChannelConstant.DEFAULT_CHANNEL;
  private static final String TAG = "NotificationService";
  private volatile boolean isDefaultChannelHasCreate = false;
  private NotificationServiceAdapter mAdapter;
  private Context mContext;
  private NotificationManager mNotificationManager;
  
  @RequiresApi(api=26)
  private void createDefaultNotificationChannel()
  {
    createNotificationChannel(DEFAULT_CHANNEL);
    this.isDefaultChannelHasCreate = true;
  }
  
  public void cancel()
  {
    cancel(NotificationIdConstant.DEFAULT.getValue());
  }
  
  public void cancel(int paramInt)
  {
    this.mNotificationManager.cancel(paramInt);
  }
  
  public void cancelAll()
  {
    this.mNotificationManager.cancelAll();
  }
  
  public void clearEventOutput() {}
  
  @RequiresApi(api=26)
  public NotificationChannel createNotificationChannel(NotificationChannelConstant paramNotificationChannelConstant)
  {
    NotificationChannel localNotificationChannel = new NotificationChannel(paramNotificationChannelConstant.getId(), paramNotificationChannelConstant.getName(), 3);
    this.mNotificationManager.createNotificationChannel(localNotificationChannel);
    this.mAdapter.getLogger().i("NotificationService", "创建通知渠道, id = " + paramNotificationChannelConstant.getId() + ", name = " + paramNotificationChannelConstant.getName(), new Object[0]);
    return localNotificationChannel;
  }
  
  public NotificationCompat.Builder getNotificationBuilder(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return new NotificationCompat.Builder(paramContext);
    }
    if (!this.isDefaultChannelHasCreate) {
      createDefaultNotificationChannel();
    }
    return getNotificationBuilder(paramContext, DEFAULT_CHANNEL);
  }
  
  public NotificationCompat.Builder getNotificationBuilder(Context paramContext, NotificationChannelConstant paramNotificationChannelConstant)
  {
    return getNotificationBuilder(paramContext, paramNotificationChannelConstant.getId());
  }
  
  public NotificationCompat.Builder getNotificationBuilder(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return new NotificationCompat.Builder(paramContext);
    }
    return new NotificationCompat.Builder(paramContext, paramString);
  }
  
  public void onCreate(Context paramContext)
  {
    this.mContext = paramContext;
    this.mNotificationManager = ((NotificationManager)this.mContext.getSystemService("notification"));
  }
  
  public void onDestroy() {}
  
  public void setAdapter(NotificationServiceAdapter paramNotificationServiceAdapter)
  {
    this.mAdapter = paramNotificationServiceAdapter;
  }
  
  public void show(int paramInt, NotificationCompat.Builder paramBuilder)
  {
    this.mNotificationManager.notify(paramInt, paramBuilder.build());
  }
  
  public void show(NotificationCompat.Builder paramBuilder)
  {
    show(NotificationIdConstant.DEFAULT.getValue(), paramBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.notification.NotificationService
 * JD-Core Version:    0.7.0.1
 */