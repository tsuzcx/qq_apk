package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class NotificationCompat$Builder
{
  ArrayList<NotificationCompat.Action> mActions = new ArrayList();
  String mChannelId;
  CharSequence mContentInfo;
  PendingIntent mContentIntent;
  CharSequence mContentText;
  CharSequence mContentTitle;
  Context mContext;
  PendingIntent mFullScreenIntent;
  Bitmap mLargeIcon;
  Notification mNotification = new Notification();
  int mNumber;
  int mPriority;
  int mProgress;
  boolean mProgressIndeterminate;
  int mProgressMax;
  NotificationCompat.Style mStyle;
  CharSequence mSubText;
  RemoteViews mTickerView;
  boolean mUseChronometer;
  
  public NotificationCompat$Builder(Context paramContext)
  {
    this.mContext = paramContext;
    this.mNotification.when = System.currentTimeMillis();
    this.mNotification.audioStreamType = -1;
    this.mPriority = 0;
  }
  
  private void setFlag(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localNotification = this.mNotification;
      localNotification.flags = (paramInt | localNotification.flags);
      return;
    }
    Notification localNotification = this.mNotification;
    localNotification.flags = ((paramInt ^ 0xFFFFFFFF) & localNotification.flags);
  }
  
  public Builder addAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this.mActions.add(new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent));
    return this;
  }
  
  public Notification build()
  {
    return NotificationCompat.access$000().build(this);
  }
  
  @Deprecated
  public Notification getNotification()
  {
    return NotificationCompat.access$000().build(this);
  }
  
  public Builder setAutoCancel(boolean paramBoolean)
  {
    setFlag(16, paramBoolean);
    return this;
  }
  
  public Builder setChannelId(String paramString)
  {
    this.mChannelId = paramString;
    return this;
  }
  
  public Builder setContent(RemoteViews paramRemoteViews)
  {
    this.mNotification.contentView = paramRemoteViews;
    return this;
  }
  
  public Builder setContentInfo(CharSequence paramCharSequence)
  {
    this.mContentInfo = paramCharSequence;
    return this;
  }
  
  public Builder setContentIntent(PendingIntent paramPendingIntent)
  {
    this.mContentIntent = paramPendingIntent;
    return this;
  }
  
  public Builder setContentText(CharSequence paramCharSequence)
  {
    this.mContentText = paramCharSequence;
    return this;
  }
  
  public Builder setContentTitle(CharSequence paramCharSequence)
  {
    this.mContentTitle = paramCharSequence;
    return this;
  }
  
  public Builder setDefaults(int paramInt)
  {
    Notification localNotification = this.mNotification;
    localNotification.defaults = paramInt;
    if ((paramInt & 0x4) != 0) {
      localNotification.flags |= 0x1;
    }
    return this;
  }
  
  public Builder setDeleteIntent(PendingIntent paramPendingIntent)
  {
    this.mNotification.deleteIntent = paramPendingIntent;
    return this;
  }
  
  public Builder setFullScreenIntent(PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    this.mFullScreenIntent = paramPendingIntent;
    setFlag(128, paramBoolean);
    return this;
  }
  
  public Builder setLargeIcon(Bitmap paramBitmap)
  {
    this.mLargeIcon = paramBitmap;
    return this;
  }
  
  public Builder setLights(int paramInt1, int paramInt2, int paramInt3)
  {
    Notification localNotification = this.mNotification;
    localNotification.ledARGB = paramInt1;
    localNotification.ledOnMS = paramInt2;
    localNotification.ledOffMS = paramInt3;
    if ((localNotification.ledOnMS != 0) && (this.mNotification.ledOffMS != 0)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    localNotification = this.mNotification;
    localNotification.flags = (paramInt1 | localNotification.flags & 0xFFFFFFFE);
    return this;
  }
  
  public Builder setNumber(int paramInt)
  {
    this.mNumber = paramInt;
    return this;
  }
  
  public Builder setOngoing(boolean paramBoolean)
  {
    setFlag(2, paramBoolean);
    return this;
  }
  
  public Builder setOnlyAlertOnce(boolean paramBoolean)
  {
    setFlag(8, paramBoolean);
    return this;
  }
  
  public Builder setPriority(int paramInt)
  {
    this.mPriority = paramInt;
    return this;
  }
  
  public Builder setProgress(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mProgressMax = paramInt1;
    this.mProgress = paramInt2;
    this.mProgressIndeterminate = paramBoolean;
    return this;
  }
  
  public Builder setSmallIcon(int paramInt)
  {
    this.mNotification.icon = paramInt;
    return this;
  }
  
  public Builder setSmallIcon(int paramInt1, int paramInt2)
  {
    Notification localNotification = this.mNotification;
    localNotification.icon = paramInt1;
    localNotification.iconLevel = paramInt2;
    return this;
  }
  
  public Builder setSound(Uri paramUri)
  {
    Notification localNotification = this.mNotification;
    localNotification.sound = paramUri;
    localNotification.audioStreamType = -1;
    return this;
  }
  
  public Builder setSound(Uri paramUri, int paramInt)
  {
    Notification localNotification = this.mNotification;
    localNotification.sound = paramUri;
    localNotification.audioStreamType = paramInt;
    return this;
  }
  
  public Builder setStyle(NotificationCompat.Style paramStyle)
  {
    if (this.mStyle != paramStyle)
    {
      this.mStyle = paramStyle;
      paramStyle = this.mStyle;
      if (paramStyle != null) {
        paramStyle.setBuilder(this);
      }
    }
    return this;
  }
  
  public Builder setSubText(CharSequence paramCharSequence)
  {
    this.mSubText = paramCharSequence;
    return this;
  }
  
  public Builder setTicker(CharSequence paramCharSequence)
  {
    this.mNotification.tickerText = paramCharSequence;
    return this;
  }
  
  public Builder setTicker(CharSequence paramCharSequence, RemoteViews paramRemoteViews)
  {
    this.mNotification.tickerText = paramCharSequence;
    this.mTickerView = paramRemoteViews;
    return this;
  }
  
  public Builder setUsesChronometer(boolean paramBoolean)
  {
    this.mUseChronometer = paramBoolean;
    return this;
  }
  
  public Builder setVibrate(long[] paramArrayOfLong)
  {
    this.mNotification.vibrate = paramArrayOfLong;
    return this;
  }
  
  public Builder setWhen(long paramLong)
  {
    this.mNotification.when = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.Builder
 * JD-Core Version:    0.7.0.1
 */