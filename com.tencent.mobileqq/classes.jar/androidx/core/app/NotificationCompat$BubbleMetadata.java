package androidx.core.app;

import android.app.Notification.BubbleMetadata;
import android.app.Notification.BubbleMetadata.Builder;
import android.app.PendingIntent;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.IconCompat;

public final class NotificationCompat$BubbleMetadata
{
  private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
  private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
  private PendingIntent mDeleteIntent;
  private int mDesiredHeight;
  @DimenRes
  private int mDesiredHeightResId;
  private int mFlags;
  private IconCompat mIcon;
  private PendingIntent mPendingIntent;
  
  private NotificationCompat$BubbleMetadata(PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, IconCompat paramIconCompat, int paramInt1, @DimenRes int paramInt2, int paramInt3)
  {
    this.mPendingIntent = paramPendingIntent1;
    this.mIcon = paramIconCompat;
    this.mDesiredHeight = paramInt1;
    this.mDesiredHeightResId = paramInt2;
    this.mDeleteIntent = paramPendingIntent2;
    this.mFlags = paramInt3;
  }
  
  @Nullable
  @RequiresApi(29)
  public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata paramBubbleMetadata)
  {
    if (paramBubbleMetadata == null) {
      return null;
    }
    NotificationCompat.BubbleMetadata.Builder localBuilder = new NotificationCompat.BubbleMetadata.Builder().setAutoExpandBubble(paramBubbleMetadata.getAutoExpandBubble()).setDeleteIntent(paramBubbleMetadata.getDeleteIntent()).setIcon(IconCompat.createFromIcon(paramBubbleMetadata.getIcon())).setIntent(paramBubbleMetadata.getIntent()).setSuppressNotification(paramBubbleMetadata.isNotificationSuppressed());
    if (paramBubbleMetadata.getDesiredHeight() != 0) {
      localBuilder.setDesiredHeight(paramBubbleMetadata.getDesiredHeight());
    }
    if (paramBubbleMetadata.getDesiredHeightResId() != 0) {
      localBuilder.setDesiredHeightResId(paramBubbleMetadata.getDesiredHeightResId());
    }
    return localBuilder.build();
  }
  
  @Nullable
  @RequiresApi(29)
  public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata paramBubbleMetadata)
  {
    if (paramBubbleMetadata == null) {
      return null;
    }
    Notification.BubbleMetadata.Builder localBuilder = new Notification.BubbleMetadata.Builder().setAutoExpandBubble(paramBubbleMetadata.getAutoExpandBubble()).setDeleteIntent(paramBubbleMetadata.getDeleteIntent()).setIcon(paramBubbleMetadata.getIcon().toIcon()).setIntent(paramBubbleMetadata.getIntent()).setSuppressNotification(paramBubbleMetadata.isNotificationSuppressed());
    if (paramBubbleMetadata.getDesiredHeight() != 0) {
      localBuilder.setDesiredHeight(paramBubbleMetadata.getDesiredHeight());
    }
    if (paramBubbleMetadata.getDesiredHeightResId() != 0) {
      localBuilder.setDesiredHeightResId(paramBubbleMetadata.getDesiredHeightResId());
    }
    return localBuilder.build();
  }
  
  public boolean getAutoExpandBubble()
  {
    return (this.mFlags & 0x1) != 0;
  }
  
  @Nullable
  public PendingIntent getDeleteIntent()
  {
    return this.mDeleteIntent;
  }
  
  @Dimension(unit=0)
  public int getDesiredHeight()
  {
    return this.mDesiredHeight;
  }
  
  @DimenRes
  public int getDesiredHeightResId()
  {
    return this.mDesiredHeightResId;
  }
  
  @NonNull
  public IconCompat getIcon()
  {
    return this.mIcon;
  }
  
  @NonNull
  public PendingIntent getIntent()
  {
    return this.mPendingIntent;
  }
  
  public boolean isNotificationSuppressed()
  {
    return (this.mFlags & 0x2) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.BubbleMetadata
 * JD-Core Version:    0.7.0.1
 */