package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R.dimen;
import java.util.ArrayList;

public class NotificationCompat$Builder
{
  private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public ArrayList<NotificationCompat.Action> mActions = new ArrayList();
  boolean mAllowSystemGeneratedContextualActions;
  int mBadgeIcon = 0;
  RemoteViews mBigContentView;
  NotificationCompat.BubbleMetadata mBubbleMetadata;
  String mCategory;
  String mChannelId;
  boolean mChronometerCountDown;
  int mColor = 0;
  boolean mColorized;
  boolean mColorizedSet;
  CharSequence mContentInfo;
  PendingIntent mContentIntent;
  CharSequence mContentText;
  CharSequence mContentTitle;
  RemoteViews mContentView;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public Context mContext;
  Bundle mExtras;
  PendingIntent mFullScreenIntent;
  int mGroupAlertBehavior = 0;
  String mGroupKey;
  boolean mGroupSummary;
  RemoteViews mHeadsUpContentView;
  ArrayList<NotificationCompat.Action> mInvisibleActions = new ArrayList();
  Bitmap mLargeIcon;
  boolean mLocalOnly = false;
  Notification mNotification = new Notification();
  int mNumber;
  @Deprecated
  public ArrayList<String> mPeople;
  int mPriority;
  int mProgress;
  boolean mProgressIndeterminate;
  int mProgressMax;
  Notification mPublicVersion;
  CharSequence[] mRemoteInputHistory;
  String mShortcutId;
  boolean mShowWhen = true;
  boolean mSilent;
  String mSortKey;
  NotificationCompat.Style mStyle;
  CharSequence mSubText;
  RemoteViews mTickerView;
  long mTimeout;
  boolean mUseChronometer;
  int mVisibility = 0;
  
  @Deprecated
  public NotificationCompat$Builder(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NotificationCompat$Builder(@NonNull Context paramContext, @NonNull String paramString)
  {
    this.mContext = paramContext;
    this.mChannelId = paramString;
    this.mNotification.when = System.currentTimeMillis();
    this.mNotification.audioStreamType = -1;
    this.mPriority = 0;
    this.mPeople = new ArrayList();
    this.mAllowSystemGeneratedContextualActions = true;
  }
  
  protected static CharSequence limitCharSequenceLength(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return paramCharSequence;
    }
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence.length() > 5120) {
      localCharSequence = paramCharSequence.subSequence(0, 5120);
    }
    return localCharSequence;
  }
  
  private Bitmap reduceLargeIconSize(Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      if (Build.VERSION.SDK_INT >= 27) {
        return paramBitmap;
      }
      localObject = this.mContext.getResources();
      int i = ((Resources)localObject).getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
      int j = ((Resources)localObject).getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
      if ((paramBitmap.getWidth() <= i) && (paramBitmap.getHeight() <= j)) {
        return paramBitmap;
      }
      double d1 = i;
      double d2 = Math.max(1, paramBitmap.getWidth());
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      d2 = j;
      double d3 = Math.max(1, paramBitmap.getHeight());
      Double.isNaN(d2);
      Double.isNaN(d3);
      d1 = Math.min(d1, d2 / d3);
      d2 = paramBitmap.getWidth();
      Double.isNaN(d2);
      i = (int)Math.ceil(d2 * d1);
      d2 = paramBitmap.getHeight();
      Double.isNaN(d2);
      localObject = Bitmap.createScaledBitmap(paramBitmap, i, (int)Math.ceil(d2 * d1), true);
    }
    return localObject;
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
  
  public Builder addAction(NotificationCompat.Action paramAction)
  {
    this.mActions.add(paramAction);
    return this;
  }
  
  public Builder addExtras(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Bundle localBundle = this.mExtras;
      if (localBundle == null)
      {
        this.mExtras = new Bundle(paramBundle);
        return this;
      }
      localBundle.putAll(paramBundle);
    }
    return this;
  }
  
  @RequiresApi(21)
  public Builder addInvisibleAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    return addInvisibleAction(new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent));
  }
  
  @RequiresApi(21)
  public Builder addInvisibleAction(NotificationCompat.Action paramAction)
  {
    this.mInvisibleActions.add(paramAction);
    return this;
  }
  
  public Builder addPerson(String paramString)
  {
    this.mPeople.add(paramString);
    return this;
  }
  
  public Notification build()
  {
    return new NotificationCompatBuilder(this).build();
  }
  
  public Builder extend(NotificationCompat.Extender paramExtender)
  {
    paramExtender.extend(this);
    return this;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews getBigContentView()
  {
    return this.mBigContentView;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public NotificationCompat.BubbleMetadata getBubbleMetadata()
  {
    return this.mBubbleMetadata;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int getColor()
  {
    return this.mColor;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews getContentView()
  {
    return this.mContentView;
  }
  
  public Bundle getExtras()
  {
    if (this.mExtras == null) {
      this.mExtras = new Bundle();
    }
    return this.mExtras;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews getHeadsUpContentView()
  {
    return this.mHeadsUpContentView;
  }
  
  @Deprecated
  public Notification getNotification()
  {
    return build();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int getPriority()
  {
    return this.mPriority;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public long getWhenIfShowing()
  {
    if (this.mShowWhen) {
      return this.mNotification.when;
    }
    return 0L;
  }
  
  @NonNull
  public Builder setAllowSystemGeneratedContextualActions(boolean paramBoolean)
  {
    this.mAllowSystemGeneratedContextualActions = paramBoolean;
    return this;
  }
  
  public Builder setAutoCancel(boolean paramBoolean)
  {
    setFlag(16, paramBoolean);
    return this;
  }
  
  public Builder setBadgeIconType(int paramInt)
  {
    this.mBadgeIcon = paramInt;
    return this;
  }
  
  @NonNull
  public Builder setBubbleMetadata(@Nullable NotificationCompat.BubbleMetadata paramBubbleMetadata)
  {
    this.mBubbleMetadata = paramBubbleMetadata;
    return this;
  }
  
  public Builder setCategory(String paramString)
  {
    this.mCategory = paramString;
    return this;
  }
  
  public Builder setChannelId(@NonNull String paramString)
  {
    this.mChannelId = paramString;
    return this;
  }
  
  @NonNull
  @RequiresApi(24)
  public Builder setChronometerCountDown(boolean paramBoolean)
  {
    this.mChronometerCountDown = paramBoolean;
    this.mExtras.putBoolean("android.chronometerCountDown", paramBoolean);
    return this;
  }
  
  public Builder setColor(@ColorInt int paramInt)
  {
    this.mColor = paramInt;
    return this;
  }
  
  public Builder setColorized(boolean paramBoolean)
  {
    this.mColorized = paramBoolean;
    this.mColorizedSet = true;
    return this;
  }
  
  public Builder setContent(RemoteViews paramRemoteViews)
  {
    this.mNotification.contentView = paramRemoteViews;
    return this;
  }
  
  public Builder setContentInfo(CharSequence paramCharSequence)
  {
    this.mContentInfo = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public Builder setContentIntent(PendingIntent paramPendingIntent)
  {
    this.mContentIntent = paramPendingIntent;
    return this;
  }
  
  public Builder setContentText(CharSequence paramCharSequence)
  {
    this.mContentText = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public Builder setContentTitle(CharSequence paramCharSequence)
  {
    this.mContentTitle = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public Builder setCustomBigContentView(RemoteViews paramRemoteViews)
  {
    this.mBigContentView = paramRemoteViews;
    return this;
  }
  
  public Builder setCustomContentView(RemoteViews paramRemoteViews)
  {
    this.mContentView = paramRemoteViews;
    return this;
  }
  
  public Builder setCustomHeadsUpContentView(RemoteViews paramRemoteViews)
  {
    this.mHeadsUpContentView = paramRemoteViews;
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
  
  public Builder setExtras(Bundle paramBundle)
  {
    this.mExtras = paramBundle;
    return this;
  }
  
  public Builder setFullScreenIntent(PendingIntent paramPendingIntent, boolean paramBoolean)
  {
    this.mFullScreenIntent = paramPendingIntent;
    setFlag(128, paramBoolean);
    return this;
  }
  
  public Builder setGroup(String paramString)
  {
    this.mGroupKey = paramString;
    return this;
  }
  
  public Builder setGroupAlertBehavior(int paramInt)
  {
    this.mGroupAlertBehavior = paramInt;
    return this;
  }
  
  public Builder setGroupSummary(boolean paramBoolean)
  {
    this.mGroupSummary = paramBoolean;
    return this;
  }
  
  public Builder setLargeIcon(Bitmap paramBitmap)
  {
    this.mLargeIcon = reduceLargeIconSize(paramBitmap);
    return this;
  }
  
  public Builder setLights(@ColorInt int paramInt1, int paramInt2, int paramInt3)
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
  
  public Builder setLocalOnly(boolean paramBoolean)
  {
    this.mLocalOnly = paramBoolean;
    return this;
  }
  
  @NonNull
  public Builder setNotificationSilent()
  {
    this.mSilent = true;
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
  
  public Builder setPublicVersion(Notification paramNotification)
  {
    this.mPublicVersion = paramNotification;
    return this;
  }
  
  public Builder setRemoteInputHistory(CharSequence[] paramArrayOfCharSequence)
  {
    this.mRemoteInputHistory = paramArrayOfCharSequence;
    return this;
  }
  
  public Builder setShortcutId(String paramString)
  {
    this.mShortcutId = paramString;
    return this;
  }
  
  public Builder setShowWhen(boolean paramBoolean)
  {
    this.mShowWhen = paramBoolean;
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
  
  public Builder setSortKey(String paramString)
  {
    this.mSortKey = paramString;
    return this;
  }
  
  public Builder setSound(Uri paramUri)
  {
    Notification localNotification = this.mNotification;
    localNotification.sound = paramUri;
    localNotification.audioStreamType = -1;
    if (Build.VERSION.SDK_INT >= 21) {
      this.mNotification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
    }
    return this;
  }
  
  public Builder setSound(Uri paramUri, int paramInt)
  {
    Notification localNotification = this.mNotification;
    localNotification.sound = paramUri;
    localNotification.audioStreamType = paramInt;
    if (Build.VERSION.SDK_INT >= 21) {
      this.mNotification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(paramInt).build();
    }
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
    this.mSubText = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public Builder setTicker(CharSequence paramCharSequence)
  {
    this.mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public Builder setTicker(CharSequence paramCharSequence, RemoteViews paramRemoteViews)
  {
    this.mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
    this.mTickerView = paramRemoteViews;
    return this;
  }
  
  public Builder setTimeoutAfter(long paramLong)
  {
    this.mTimeout = paramLong;
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
  
  public Builder setVisibility(int paramInt)
  {
    this.mVisibility = paramInt;
    return this;
  }
  
  public Builder setWhen(long paramLong)
  {
    this.mNotification.when = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.Builder
 * JD-Core Version:    0.7.0.1
 */