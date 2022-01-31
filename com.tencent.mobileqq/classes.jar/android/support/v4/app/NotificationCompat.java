package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

public class NotificationCompat
{
  public static final int FLAG_HIGH_PRIORITY = 128;
  private static final NotificationCompatImpl IMPL = new NotificationCompatImplHoneycomb();
  public static final int PRIORITY_DEFAULT = 0;
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_LOW = -1;
  public static final int PRIORITY_MAX = 2;
  public static final int PRIORITY_MIN = -2;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      IMPL = new NotificationCompatImplOreo();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new NotificationCompatImplJellybean();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new NotificationCompatImplIceCreamSandwich();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      IMPL = new NotificationCompatImplHoneycomb();
      return;
    }
  }
  
  public static class Action
  {
    public PendingIntent actionIntent;
    public int icon;
    public CharSequence title;
    
    public Action(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this.icon = paramInt;
      this.title = paramCharSequence;
      this.actionIntent = paramPendingIntent;
    }
  }
  
  public static class BigPictureStyle
    extends NotificationCompat.Style
  {
    Bitmap mBigLargeIcon;
    boolean mBigLargeIconSet;
    Bitmap mPicture;
    
    public BigPictureStyle() {}
    
    public BigPictureStyle(NotificationCompat.Builder paramBuilder)
    {
      setBuilder(paramBuilder);
    }
    
    public BigPictureStyle bigLargeIcon(Bitmap paramBitmap)
    {
      this.mBigLargeIcon = paramBitmap;
      this.mBigLargeIconSet = true;
      return this;
    }
    
    public BigPictureStyle bigPicture(Bitmap paramBitmap)
    {
      this.mPicture = paramBitmap;
      return this;
    }
    
    public BigPictureStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      this.mBigContentTitle = paramCharSequence;
      return this;
    }
    
    public BigPictureStyle setSummaryText(CharSequence paramCharSequence)
    {
      this.mSummaryText = paramCharSequence;
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  public static class BigTextStyle
    extends NotificationCompat.Style
  {
    CharSequence mBigText;
    
    public BigTextStyle() {}
    
    public BigTextStyle(NotificationCompat.Builder paramBuilder)
    {
      setBuilder(paramBuilder);
    }
    
    public BigTextStyle bigText(CharSequence paramCharSequence)
    {
      this.mBigText = paramCharSequence;
      return this;
    }
    
    public BigTextStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      this.mBigContentTitle = paramCharSequence;
      return this;
    }
    
    public BigTextStyle setSummaryText(CharSequence paramCharSequence)
    {
      this.mSummaryText = paramCharSequence;
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  public static class Builder
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
    
    public Builder(Context paramContext)
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
        localNotification.flags |= paramInt;
        return;
      }
      Notification localNotification = this.mNotification;
      localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
    }
    
    public Builder addAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this.mActions.add(new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent));
      return this;
    }
    
    public Notification build()
    {
      return NotificationCompat.IMPL.build(this);
    }
    
    @Deprecated
    public Notification getNotification()
    {
      return NotificationCompat.IMPL.build(this);
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
      this.mNotification.defaults = paramInt;
      if ((paramInt & 0x4) != 0)
      {
        Notification localNotification = this.mNotification;
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
      int i = 1;
      this.mNotification.ledARGB = paramInt1;
      this.mNotification.ledOnMS = paramInt2;
      this.mNotification.ledOffMS = paramInt3;
      Notification localNotification;
      if ((this.mNotification.ledOnMS != 0) && (this.mNotification.ledOffMS != 0))
      {
        paramInt1 = 1;
        localNotification = this.mNotification;
        paramInt2 = this.mNotification.flags;
        if (paramInt1 == 0) {
          break label88;
        }
      }
      label88:
      for (paramInt1 = i;; paramInt1 = 0)
      {
        localNotification.flags = (paramInt1 | paramInt2 & 0xFFFFFFFE);
        return this;
        paramInt1 = 0;
        break;
      }
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
      this.mNotification.icon = paramInt1;
      this.mNotification.iconLevel = paramInt2;
      return this;
    }
    
    public Builder setSound(Uri paramUri)
    {
      this.mNotification.sound = paramUri;
      this.mNotification.audioStreamType = -1;
      return this;
    }
    
    public Builder setSound(Uri paramUri, int paramInt)
    {
      this.mNotification.sound = paramUri;
      this.mNotification.audioStreamType = paramInt;
      return this;
    }
    
    public Builder setStyle(NotificationCompat.Style paramStyle)
    {
      if (this.mStyle != paramStyle)
      {
        this.mStyle = paramStyle;
        if (this.mStyle != null) {
          this.mStyle.setBuilder(this);
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
  
  public static class InboxStyle
    extends NotificationCompat.Style
  {
    ArrayList<CharSequence> mTexts = new ArrayList();
    
    public InboxStyle() {}
    
    public InboxStyle(NotificationCompat.Builder paramBuilder)
    {
      setBuilder(paramBuilder);
    }
    
    public InboxStyle addLine(CharSequence paramCharSequence)
    {
      this.mTexts.add(paramCharSequence);
      return this;
    }
    
    public InboxStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      this.mBigContentTitle = paramCharSequence;
      return this;
    }
    
    public InboxStyle setSummaryText(CharSequence paramCharSequence)
    {
      this.mSummaryText = paramCharSequence;
      this.mSummaryTextSet = true;
      return this;
    }
  }
  
  static abstract interface NotificationCompatImpl
  {
    public abstract Notification build(NotificationCompat.Builder paramBuilder);
  }
  
  static class NotificationCompatImplHoneycomb
    implements NotificationCompat.NotificationCompatImpl
  {
    public Notification build(NotificationCompat.Builder paramBuilder)
    {
      return NotificationCompatHoneycomb.add(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon);
    }
  }
  
  static class NotificationCompatImplIceCreamSandwich
    implements NotificationCompat.NotificationCompatImpl
  {
    public Notification build(NotificationCompat.Builder paramBuilder)
    {
      return NotificationCompatIceCreamSandwich.add(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate);
    }
  }
  
  static class NotificationCompatImplJellybean
    implements NotificationCompat.NotificationCompatImpl
  {
    public Notification build(NotificationCompat.Builder paramBuilder)
    {
      NotificationCompatJellybean localNotificationCompatJellybean = new NotificationCompatJellybean(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate, paramBuilder.mUseChronometer, paramBuilder.mPriority, paramBuilder.mSubText);
      Iterator localIterator = paramBuilder.mActions.iterator();
      while (localIterator.hasNext())
      {
        NotificationCompat.Action localAction = (NotificationCompat.Action)localIterator.next();
        localNotificationCompatJellybean.addAction(localAction.icon, localAction.title, localAction.actionIntent);
      }
      if (paramBuilder.mStyle != null)
      {
        if (!(paramBuilder.mStyle instanceof NotificationCompat.BigTextStyle)) {
          break label172;
        }
        paramBuilder = (NotificationCompat.BigTextStyle)paramBuilder.mStyle;
        localNotificationCompatJellybean.addBigTextStyle(paramBuilder.mBigContentTitle, paramBuilder.mSummaryTextSet, paramBuilder.mSummaryText, paramBuilder.mBigText);
      }
      for (;;)
      {
        return localNotificationCompatJellybean.build();
        label172:
        if ((paramBuilder.mStyle instanceof NotificationCompat.InboxStyle))
        {
          paramBuilder = (NotificationCompat.InboxStyle)paramBuilder.mStyle;
          localNotificationCompatJellybean.addInboxStyle(paramBuilder.mBigContentTitle, paramBuilder.mSummaryTextSet, paramBuilder.mSummaryText, paramBuilder.mTexts);
        }
        else if ((paramBuilder.mStyle instanceof NotificationCompat.BigPictureStyle))
        {
          paramBuilder = (NotificationCompat.BigPictureStyle)paramBuilder.mStyle;
          localNotificationCompatJellybean.addBigPictureStyle(paramBuilder.mBigContentTitle, paramBuilder.mSummaryTextSet, paramBuilder.mSummaryText, paramBuilder.mPicture, paramBuilder.mBigLargeIcon, paramBuilder.mBigLargeIconSet);
        }
      }
    }
  }
  
  static class NotificationCompatImplOreo
    implements NotificationCompat.NotificationCompatImpl
  {
    public Notification build(NotificationCompat.Builder paramBuilder)
    {
      NotificationCompatOreo localNotificationCompatOreo = new NotificationCompatOreo(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon, paramBuilder.mProgressMax, paramBuilder.mProgress, paramBuilder.mProgressIndeterminate, paramBuilder.mUseChronometer, paramBuilder.mPriority, paramBuilder.mSubText, paramBuilder.mChannelId);
      Iterator localIterator = paramBuilder.mActions.iterator();
      while (localIterator.hasNext())
      {
        NotificationCompat.Action localAction = (NotificationCompat.Action)localIterator.next();
        localNotificationCompatOreo.addAction(localAction.icon, localAction.title, localAction.actionIntent);
      }
      if (paramBuilder.mStyle != null)
      {
        if (!(paramBuilder.mStyle instanceof NotificationCompat.BigTextStyle)) {
          break label176;
        }
        paramBuilder = (NotificationCompat.BigTextStyle)paramBuilder.mStyle;
        localNotificationCompatOreo.addBigTextStyle(paramBuilder.mBigContentTitle, paramBuilder.mSummaryTextSet, paramBuilder.mSummaryText, paramBuilder.mBigText);
      }
      for (;;)
      {
        return localNotificationCompatOreo.build();
        label176:
        if ((paramBuilder.mStyle instanceof NotificationCompat.InboxStyle))
        {
          paramBuilder = (NotificationCompat.InboxStyle)paramBuilder.mStyle;
          localNotificationCompatOreo.addInboxStyle(paramBuilder.mBigContentTitle, paramBuilder.mSummaryTextSet, paramBuilder.mSummaryText, paramBuilder.mTexts);
        }
        else if ((paramBuilder.mStyle instanceof NotificationCompat.BigPictureStyle))
        {
          paramBuilder = (NotificationCompat.BigPictureStyle)paramBuilder.mStyle;
          localNotificationCompatOreo.addBigPictureStyle(paramBuilder.mBigContentTitle, paramBuilder.mSummaryTextSet, paramBuilder.mSummaryText, paramBuilder.mPicture, paramBuilder.mBigLargeIcon, paramBuilder.mBigLargeIconSet);
        }
      }
    }
  }
  
  public static abstract class Style
  {
    CharSequence mBigContentTitle;
    NotificationCompat.Builder mBuilder;
    CharSequence mSummaryText;
    boolean mSummaryTextSet = false;
    
    public Notification build()
    {
      Notification localNotification = null;
      if (this.mBuilder != null) {
        localNotification = this.mBuilder.build();
      }
      return localNotification;
    }
    
    public void setBuilder(NotificationCompat.Builder paramBuilder)
    {
      if (this.mBuilder != paramBuilder)
      {
        this.mBuilder = paramBuilder;
        if (this.mBuilder != null) {
          this.mBuilder.setStyle(this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat
 * JD-Core Version:    0.7.0.1
 */