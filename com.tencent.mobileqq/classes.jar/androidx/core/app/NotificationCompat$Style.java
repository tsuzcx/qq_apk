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
    int i = localResources.getDimensionPixelSize(2131297449);
    int j = localResources.getDimensionPixelSize(2131297450);
    float f1 = (constrain(localResources.getConfiguration().fontScale, 1.0F, 1.3F) - 1.0F) / 0.3F;
    float f2 = i;
    return Math.round(f1 * j + f2 * (1.0F - f1));
  }
  
  private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  private Bitmap createColoredBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    return createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, paramInt1), paramInt2, paramInt3);
  }
  
  private Bitmap createColoredBitmap(IconCompat paramIconCompat, int paramInt1, int paramInt2)
  {
    paramIconCompat = paramIconCompat.loadDrawable(this.mBuilder.mContext);
    if (paramInt2 == 0) {}
    for (int i = paramIconCompat.getIntrinsicWidth();; i = paramInt2)
    {
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
  }
  
  private Bitmap createIconWithBackground(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4;
    if (paramInt4 == 0) {
      i = 0;
    }
    Bitmap localBitmap = createColoredBitmap(2130841439, i, paramInt2);
    Canvas localCanvas = new Canvas(localBitmap);
    Drawable localDrawable = this.mBuilder.mContext.getResources().getDrawable(paramInt1).mutate();
    localDrawable.setFilterBitmap(true);
    paramInt1 = (paramInt2 - paramInt3) / 2;
    localDrawable.setBounds(paramInt1, paramInt1, paramInt3 + paramInt1, paramInt3 + paramInt1);
    localDrawable.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
    localDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private void hideNormalContent(RemoteViews paramRemoteViews)
  {
    paramRemoteViews.setViewVisibility(2131379001, 8);
    paramRemoteViews.setViewVisibility(2131378661, 8);
    paramRemoteViews.setViewVisibility(2131378658, 8);
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
    label87:
    label127:
    int i;
    if (this.mBuilder.getPriority() < -1)
    {
      paramInt = 1;
      if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 21))
      {
        if (paramInt == 0) {
          break label578;
        }
        localRemoteViews.setInt(2131372105, "setBackgroundResource", 2130841434);
        localRemoteViews.setInt(2131368381, "setBackgroundResource", 2130841442);
      }
      if (this.mBuilder.mLargeIcon == null) {
        break label642;
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label605;
      }
      localRemoteViews.setViewVisibility(2131368381, 0);
      localRemoteViews.setImageViewBitmap(2131368381, this.mBuilder.mLargeIcon);
      if ((paramBoolean1) && (this.mBuilder.mNotification.icon != 0))
      {
        paramInt = localResources.getDimensionPixelSize(2131297444);
        i = localResources.getDimensionPixelSize(2131297446);
        if (Build.VERSION.SDK_INT < 21) {
          break label617;
        }
        localRemoteViews.setImageViewBitmap(2131376696, createIconWithBackground(this.mBuilder.mNotification.icon, paramInt, paramInt - i * 2, this.mBuilder.getColor()));
        label204:
        localRemoteViews.setViewVisibility(2131376696, 0);
      }
      label212:
      if (this.mBuilder.mContentTitle != null) {
        localRemoteViews.setTextViewText(2131379001, this.mBuilder.mContentTitle);
      }
      if (this.mBuilder.mContentText == null) {
        break label936;
      }
      localRemoteViews.setTextViewText(2131378658, this.mBuilder.mContentText);
    }
    label283:
    label545:
    label930:
    label936:
    for (paramInt = 1;; paramInt = 0)
    {
      label320:
      int j;
      if ((Build.VERSION.SDK_INT < 21) && (this.mBuilder.mLargeIcon != null))
      {
        i = 1;
        if (this.mBuilder.mContentInfo == null) {
          break label772;
        }
        localRemoteViews.setTextViewText(2131368819, this.mBuilder.mContentInfo);
        localRemoteViews.setViewVisibility(2131368819, 0);
        paramInt = 1;
        i = 1;
        if ((this.mBuilder.mSubText == null) || (Build.VERSION.SDK_INT < 16)) {
          break label888;
        }
        localRemoteViews.setTextViewText(2131378658, this.mBuilder.mSubText);
        if (this.mBuilder.mContentText == null) {
          break label879;
        }
        localRemoteViews.setTextViewText(2131378661, this.mBuilder.mContentText);
        localRemoteViews.setViewVisibility(2131378661, 0);
        j = 1;
        if ((j != 0) && (Build.VERSION.SDK_INT >= 16))
        {
          if (paramBoolean2) {
            localRemoteViews.setTextViewTextSize(2131378658, 0, localResources.getDimensionPixelSize(2131297448));
          }
          localRemoteViews.setViewPadding(2131370111, 0, 0, 0, 0);
        }
        if (this.mBuilder.getWhenIfShowing() != 0L)
        {
          if ((!this.mBuilder.mUseChronometer) || (Build.VERSION.SDK_INT < 16)) {
            break label894;
          }
          localRemoteViews.setViewVisibility(2131364635, 0);
          localRemoteViews.setLong(2131364635, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
          localRemoteViews.setBoolean(2131364635, "setStarted", true);
          if ((this.mBuilder.mChronometerCountDown) && (Build.VERSION.SDK_INT >= 24)) {
            localRemoteViews.setChronometerCountDown(2131364635, this.mBuilder.mChronometerCountDown);
          }
          paramInt = 1;
        }
        if (paramInt == 0) {
          break label924;
        }
        paramInt = 0;
        localRemoteViews.setViewVisibility(2131376719, paramInt);
        if (i == 0) {
          break label930;
        }
      }
      for (paramInt = 0;; paramInt = 8)
      {
        localRemoteViews.setViewVisibility(2131370113, paramInt);
        return localRemoteViews;
        paramInt = 0;
        break;
        label578:
        localRemoteViews.setInt(2131372105, "setBackgroundResource", 2130841433);
        localRemoteViews.setInt(2131368381, "setBackgroundResource", 2130841441);
        break label87;
        label605:
        localRemoteViews.setViewVisibility(2131368381, 8);
        break label127;
        label617:
        localRemoteViews.setImageViewBitmap(2131376696, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
        break label204;
        if ((!paramBoolean1) || (this.mBuilder.mNotification.icon == 0)) {
          break label212;
        }
        localRemoteViews.setViewVisibility(2131368381, 0);
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramInt = localResources.getDimensionPixelSize(2131297441);
          i = localResources.getDimensionPixelSize(2131297438);
          j = localResources.getDimensionPixelSize(2131297447);
          localRemoteViews.setImageViewBitmap(2131368381, createIconWithBackground(this.mBuilder.mNotification.icon, paramInt - i, j, this.mBuilder.getColor()));
          break label212;
        }
        localRemoteViews.setImageViewBitmap(2131368381, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
        break label212;
        i = 0;
        break label283;
        if (this.mBuilder.mNumber > 0)
        {
          paramInt = localResources.getInteger(2131427372);
          if (this.mBuilder.mNumber > paramInt) {
            localRemoteViews.setTextViewText(2131368819, localResources.getString(2131718968));
          }
          for (;;)
          {
            localRemoteViews.setViewVisibility(2131368819, 0);
            paramInt = 1;
            i = 1;
            break;
            localRemoteViews.setTextViewText(2131368819, NumberFormat.getIntegerInstance().format(this.mBuilder.mNumber));
          }
        }
        localRemoteViews.setViewVisibility(2131368819, 8);
        j = paramInt;
        paramInt = i;
        i = j;
        break label320;
        label879:
        localRemoteViews.setViewVisibility(2131378661, 8);
        label888:
        j = 0;
        break label387;
        label894:
        localRemoteViews.setViewVisibility(2131378905, 0);
        localRemoteViews.setLong(2131378905, "setTime", this.mBuilder.getWhenIfShowing());
        break label537;
        paramInt = 8;
        break label545;
      }
    }
  }
  
  public Notification build()
  {
    Notification localNotification = null;
    if (this.mBuilder != null) {
      localNotification = this.mBuilder.build();
    }
    return localNotification;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void buildIntoRemoteViews(RemoteViews paramRemoteViews1, RemoteViews paramRemoteViews2)
  {
    hideNormalContent(paramRemoteViews1);
    paramRemoteViews1.removeAllViews(2131372110);
    paramRemoteViews1.addView(2131372110, paramRemoteViews2.clone());
    paramRemoteViews1.setViewVisibility(2131372110, 0);
    if (Build.VERSION.SDK_INT >= 21) {
      paramRemoteViews1.setViewPadding(2131372111, 0, calculateTopPadding(), 0, 0);
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
      if (this.mBuilder != null) {
        this.mBuilder.setStyle(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.Style
 * JD-Core Version:    0.7.0.1
 */