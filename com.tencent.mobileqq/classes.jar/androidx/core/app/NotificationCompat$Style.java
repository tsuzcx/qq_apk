package androidx.core.app;

import android.app.Notification;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.core.R.dimen;
import androidx.core.R.drawable;
import androidx.core.R.id;
import androidx.core.R.integer;
import androidx.core.R.string;
import androidx.core.graphics.drawable.IconCompat;
import java.text.NumberFormat;

public abstract class NotificationCompat$Style
{
  CharSequence mBigContentTitle;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected NotificationCompat.Builder mBuilder;
  CharSequence mSummaryText;
  boolean mSummaryTextSet = false;
  
  private int calculateTopPadding()
  {
    Resources localResources = this.mBuilder.mContext.getResources();
    int i = localResources.getDimensionPixelSize(R.dimen.notification_top_pad);
    int j = localResources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
    float f = (constrain(localResources.getConfiguration().fontScale, 1.0F, 1.3F) - 1.0F) / 0.3F;
    return Math.round((1.0F - f) * i + f * j);
  }
  
  private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    paramFloat2 = paramFloat1;
    if (paramFloat1 > paramFloat3) {
      paramFloat2 = paramFloat3;
    }
    return paramFloat2;
  }
  
  private Bitmap createColoredBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    return createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, paramInt1), paramInt2, paramInt3);
  }
  
  private Bitmap createColoredBitmap(IconCompat paramIconCompat, int paramInt1, int paramInt2)
  {
    paramIconCompat = paramIconCompat.loadDrawable(this.mBuilder.mContext);
    int i;
    if (paramInt2 == 0) {
      i = paramIconCompat.getIntrinsicWidth();
    } else {
      i = paramInt2;
    }
    int j = paramInt2;
    if (paramInt2 == 0) {
      j = paramIconCompat.getIntrinsicHeight();
    }
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    paramIconCompat.setBounds(0, 0, i, j);
    if (paramInt1 != 0) {
      paramIconCompat.mutate().setColorFilter(new PorterDuffColorFilter(paramInt1, PorterDuff.Mode.SRC_IN));
    }
    paramIconCompat.draw(new Canvas(localBitmap));
    return localBitmap;
  }
  
  private Bitmap createIconWithBackground(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = R.drawable.notification_icon_background;
    int i = paramInt4;
    if (paramInt4 == 0) {
      i = 0;
    }
    Bitmap localBitmap = createColoredBitmap(j, i, paramInt2);
    Canvas localCanvas = new Canvas(localBitmap);
    Drawable localDrawable = this.mBuilder.mContext.getResources().getDrawable(paramInt1).mutate();
    localDrawable.setFilterBitmap(true);
    paramInt1 = (paramInt2 - paramInt3) / 2;
    paramInt2 = paramInt3 + paramInt1;
    localDrawable.setBounds(paramInt1, paramInt1, paramInt2, paramInt2);
    localDrawable.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
    localDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private void hideNormalContent(RemoteViews paramRemoteViews)
  {
    paramRemoteViews.setViewVisibility(R.id.title, 8);
    paramRemoteViews.setViewVisibility(R.id.text2, 8);
    paramRemoteViews.setViewVisibility(R.id.text, 8);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void addCompatExtras(Bundle paramBundle) {}
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {}
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews applyStandardTemplate(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Resources localResources = this.mBuilder.mContext.getResources();
    RemoteViews localRemoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), paramInt);
    paramInt = this.mBuilder.getPriority();
    int k = 0;
    if (paramInt < -1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 21)) {
      if (paramInt != 0)
      {
        localRemoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg_low);
        localRemoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_low_bg);
      }
      else
      {
        localRemoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg);
        localRemoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_bg);
      }
    }
    int i;
    Object localObject;
    if (this.mBuilder.mLargeIcon != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        localRemoteViews.setViewVisibility(R.id.icon, 0);
        localRemoteViews.setImageViewBitmap(R.id.icon, this.mBuilder.mLargeIcon);
      }
      else
      {
        localRemoteViews.setViewVisibility(R.id.icon, 8);
      }
      if ((paramBoolean1) && (this.mBuilder.mNotification.icon != 0))
      {
        paramInt = localResources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
        i = localResources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding);
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject = createIconWithBackground(this.mBuilder.mNotification.icon, paramInt, paramInt - i * 2, this.mBuilder.getColor());
          localRemoteViews.setImageViewBitmap(R.id.right_icon, (Bitmap)localObject);
        }
        else
        {
          localRemoteViews.setImageViewBitmap(R.id.right_icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
        }
        localRemoteViews.setViewVisibility(R.id.right_icon, 0);
      }
    }
    else if ((paramBoolean1) && (this.mBuilder.mNotification.icon != 0))
    {
      localRemoteViews.setViewVisibility(R.id.icon, 0);
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramInt = localResources.getDimensionPixelSize(R.dimen.notification_large_icon_width);
        i = localResources.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
        j = localResources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
        localObject = createIconWithBackground(this.mBuilder.mNotification.icon, paramInt - i, j, this.mBuilder.getColor());
        localRemoteViews.setImageViewBitmap(R.id.icon, (Bitmap)localObject);
      }
      else
      {
        localRemoteViews.setImageViewBitmap(R.id.icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
      }
    }
    if (this.mBuilder.mContentTitle != null) {
      localRemoteViews.setTextViewText(R.id.title, this.mBuilder.mContentTitle);
    }
    if (this.mBuilder.mContentText != null)
    {
      localRemoteViews.setTextViewText(R.id.text, this.mBuilder.mContentText);
      i = 1;
    }
    else
    {
      i = 0;
    }
    if ((Build.VERSION.SDK_INT < 21) && (this.mBuilder.mLargeIcon != null)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (this.mBuilder.mContentInfo != null)
    {
      localRemoteViews.setTextViewText(R.id.info, this.mBuilder.mContentInfo);
      localRemoteViews.setViewVisibility(R.id.info, 0);
    }
    for (;;)
    {
      i = 1;
      paramInt = 1;
      break label658;
      if (this.mBuilder.mNumber <= 0) {
        break;
      }
      paramInt = localResources.getInteger(R.integer.status_bar_notification_info_maxnum);
      if (this.mBuilder.mNumber > paramInt)
      {
        localRemoteViews.setTextViewText(R.id.info, localResources.getString(R.string.status_bar_notification_info_overflow));
      }
      else
      {
        localObject = NumberFormat.getIntegerInstance();
        localRemoteViews.setTextViewText(R.id.info, ((NumberFormat)localObject).format(this.mBuilder.mNumber));
      }
      localRemoteViews.setViewVisibility(R.id.info, 0);
    }
    localRemoteViews.setViewVisibility(R.id.info, 8);
    label658:
    if ((this.mBuilder.mSubText != null) && (Build.VERSION.SDK_INT >= 16))
    {
      localRemoteViews.setTextViewText(R.id.text, this.mBuilder.mSubText);
      if (this.mBuilder.mContentText != null)
      {
        localRemoteViews.setTextViewText(R.id.text2, this.mBuilder.mContentText);
        localRemoteViews.setViewVisibility(R.id.text2, 0);
        j = 1;
      }
      else
      {
        localRemoteViews.setViewVisibility(R.id.text2, 8);
      }
    }
    else
    {
      j = 0;
    }
    if ((j != 0) && (Build.VERSION.SDK_INT >= 16))
    {
      if (paramBoolean2)
      {
        float f = localResources.getDimensionPixelSize(R.dimen.notification_subtext_size);
        localRemoteViews.setTextViewTextSize(R.id.text, 0, f);
      }
      localRemoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
    }
    if (this.mBuilder.getWhenIfShowing() != 0L)
    {
      if ((this.mBuilder.mUseChronometer) && (Build.VERSION.SDK_INT >= 16))
      {
        localRemoteViews.setViewVisibility(R.id.chronometer, 0);
        localRemoteViews.setLong(R.id.chronometer, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
        localRemoteViews.setBoolean(R.id.chronometer, "setStarted", true);
        if ((this.mBuilder.mChronometerCountDown) && (Build.VERSION.SDK_INT >= 24)) {
          localRemoteViews.setChronometerCountDown(R.id.chronometer, this.mBuilder.mChronometerCountDown);
        }
      }
      else
      {
        localRemoteViews.setViewVisibility(R.id.time, 0);
        localRemoteViews.setLong(R.id.time, "setTime", this.mBuilder.getWhenIfShowing());
      }
      paramInt = 1;
    }
    int j = R.id.right_side;
    if (paramInt != 0) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    localRemoteViews.setViewVisibility(j, paramInt);
    j = R.id.line3;
    if (i != 0) {
      paramInt = k;
    } else {
      paramInt = 8;
    }
    localRemoteViews.setViewVisibility(j, paramInt);
    return localRemoteViews;
  }
  
  public Notification build()
  {
    NotificationCompat.Builder localBuilder = this.mBuilder;
    if (localBuilder != null) {
      return localBuilder.build();
    }
    return null;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void buildIntoRemoteViews(RemoteViews paramRemoteViews1, RemoteViews paramRemoteViews2)
  {
    hideNormalContent(paramRemoteViews1);
    paramRemoteViews1.removeAllViews(R.id.notification_main_column);
    paramRemoteViews1.addView(R.id.notification_main_column, paramRemoteViews2.clone());
    paramRemoteViews1.setViewVisibility(R.id.notification_main_column, 0);
    if (Build.VERSION.SDK_INT >= 21) {
      paramRemoteViews1.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public Bitmap createColoredBitmap(int paramInt1, int paramInt2)
  {
    return createColoredBitmap(paramInt1, paramInt2, 0);
  }
  
  Bitmap createColoredBitmap(IconCompat paramIconCompat, int paramInt)
  {
    return createColoredBitmap(paramIconCompat, paramInt, 0);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    return null;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    return null;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    return null;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  protected void restoreFromCompatExtras(Bundle paramBundle) {}
  
  public void setBuilder(NotificationCompat.Builder paramBuilder)
  {
    if (this.mBuilder != paramBuilder)
    {
      this.mBuilder = paramBuilder;
      paramBuilder = this.mBuilder;
      if (paramBuilder != null) {
        paramBuilder.setStyle(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.Style
 * JD-Core Version:    0.7.0.1
 */