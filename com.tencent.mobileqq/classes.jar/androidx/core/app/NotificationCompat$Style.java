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
    int i = localResources.getDimensionPixelSize(2131297505);
    int j = localResources.getDimensionPixelSize(2131297506);
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
    int i = paramInt4;
    if (paramInt4 == 0) {
      i = 0;
    }
    Bitmap localBitmap = createColoredBitmap(2130841465, i, paramInt2);
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
    paramRemoteViews.setViewVisibility(2131378784, 8);
    paramRemoteViews.setViewVisibility(2131378463, 8);
    paramRemoteViews.setViewVisibility(2131378460, 8);
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
    if (this.mBuilder.getPriority() < -1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 21)) {
      if (paramInt != 0)
      {
        localRemoteViews.setInt(2131371988, "setBackgroundResource", 2130841460);
        localRemoteViews.setInt(2131368343, "setBackgroundResource", 2130841468);
      }
      else
      {
        localRemoteViews.setInt(2131371988, "setBackgroundResource", 2130841459);
        localRemoteViews.setInt(2131368343, "setBackgroundResource", 2130841467);
      }
    }
    Bitmap localBitmap = this.mBuilder.mLargeIcon;
    int k = 8;
    if (localBitmap != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        localRemoteViews.setViewVisibility(2131368343, 0);
        localRemoteViews.setImageViewBitmap(2131368343, this.mBuilder.mLargeIcon);
      }
      else
      {
        localRemoteViews.setViewVisibility(2131368343, 8);
      }
      if ((paramBoolean1) && (this.mBuilder.mNotification.icon != 0))
      {
        paramInt = localResources.getDimensionPixelSize(2131297500);
        i = localResources.getDimensionPixelSize(2131297502);
        if (Build.VERSION.SDK_INT >= 21) {
          localRemoteViews.setImageViewBitmap(2131376568, createIconWithBackground(this.mBuilder.mNotification.icon, paramInt, paramInt - i * 2, this.mBuilder.getColor()));
        } else {
          localRemoteViews.setImageViewBitmap(2131376568, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
        }
        localRemoteViews.setViewVisibility(2131376568, 0);
      }
    }
    else if ((paramBoolean1) && (this.mBuilder.mNotification.icon != 0))
    {
      localRemoteViews.setViewVisibility(2131368343, 0);
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramInt = localResources.getDimensionPixelSize(2131297497);
        i = localResources.getDimensionPixelSize(2131297494);
        j = localResources.getDimensionPixelSize(2131297503);
        localRemoteViews.setImageViewBitmap(2131368343, createIconWithBackground(this.mBuilder.mNotification.icon, paramInt - i, j, this.mBuilder.getColor()));
      }
      else
      {
        localRemoteViews.setImageViewBitmap(2131368343, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
      }
    }
    if (this.mBuilder.mContentTitle != null) {
      localRemoteViews.setTextViewText(2131378784, this.mBuilder.mContentTitle);
    }
    if (this.mBuilder.mContentText != null)
    {
      localRemoteViews.setTextViewText(2131378460, this.mBuilder.mContentText);
      paramInt = 1;
    }
    else
    {
      paramInt = 0;
    }
    if ((Build.VERSION.SDK_INT < 21) && (this.mBuilder.mLargeIcon != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.mBuilder.mContentInfo != null)
    {
      localRemoteViews.setTextViewText(2131368773, this.mBuilder.mContentInfo);
      localRemoteViews.setViewVisibility(2131368773, 0);
    }
    for (;;)
    {
      i = 1;
      paramInt = 1;
      break label627;
      if (this.mBuilder.mNumber <= 0) {
        break;
      }
      paramInt = localResources.getInteger(2131427376);
      if (this.mBuilder.mNumber > paramInt) {
        localRemoteViews.setTextViewText(2131368773, localResources.getString(2131719220));
      } else {
        localRemoteViews.setTextViewText(2131368773, NumberFormat.getIntegerInstance().format(this.mBuilder.mNumber));
      }
      localRemoteViews.setViewVisibility(2131368773, 0);
    }
    localRemoteViews.setViewVisibility(2131368773, 8);
    int j = paramInt;
    paramInt = i;
    int i = j;
    label627:
    if ((this.mBuilder.mSubText != null) && (Build.VERSION.SDK_INT >= 16))
    {
      localRemoteViews.setTextViewText(2131378460, this.mBuilder.mSubText);
      if (this.mBuilder.mContentText != null)
      {
        localRemoteViews.setTextViewText(2131378463, this.mBuilder.mContentText);
        localRemoteViews.setViewVisibility(2131378463, 0);
        j = 1;
      }
      else
      {
        localRemoteViews.setViewVisibility(2131378463, 8);
      }
    }
    else
    {
      j = 0;
    }
    if ((j != 0) && (Build.VERSION.SDK_INT >= 16))
    {
      if (paramBoolean2) {
        localRemoteViews.setTextViewTextSize(2131378460, 0, localResources.getDimensionPixelSize(2131297504));
      }
      localRemoteViews.setViewPadding(2131370044, 0, 0, 0, 0);
    }
    if (this.mBuilder.getWhenIfShowing() != 0L)
    {
      if ((this.mBuilder.mUseChronometer) && (Build.VERSION.SDK_INT >= 16))
      {
        localRemoteViews.setViewVisibility(2131364636, 0);
        localRemoteViews.setLong(2131364636, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
        localRemoteViews.setBoolean(2131364636, "setStarted", true);
        if ((this.mBuilder.mChronometerCountDown) && (Build.VERSION.SDK_INT >= 24)) {
          localRemoteViews.setChronometerCountDown(2131364636, this.mBuilder.mChronometerCountDown);
        }
      }
      else
      {
        localRemoteViews.setViewVisibility(2131378688, 0);
        localRemoteViews.setLong(2131378688, "setTime", this.mBuilder.getWhenIfShowing());
      }
      paramInt = 1;
    }
    if (paramInt != 0) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    localRemoteViews.setViewVisibility(2131376592, paramInt);
    paramInt = k;
    if (i != 0) {
      paramInt = 0;
    }
    localRemoteViews.setViewVisibility(2131370046, paramInt);
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
    paramRemoteViews1.removeAllViews(2131371993);
    paramRemoteViews1.addView(2131371993, paramRemoteViews2.clone());
    paramRemoteViews1.setViewVisibility(2131371993, 0);
    if (Build.VERSION.SDK_INT >= 21) {
      paramRemoteViews1.setViewPadding(2131371994, 0, calculateTopPadding(), 0, 0);
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