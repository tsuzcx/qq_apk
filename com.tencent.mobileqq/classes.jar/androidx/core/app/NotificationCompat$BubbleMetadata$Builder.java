package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.IconCompat;

public final class NotificationCompat$BubbleMetadata$Builder
{
  private PendingIntent mDeleteIntent;
  private int mDesiredHeight;
  @DimenRes
  private int mDesiredHeightResId;
  private int mFlags;
  private IconCompat mIcon;
  private PendingIntent mPendingIntent;
  
  private Builder setFlag(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFlags |= paramInt;
      return this;
    }
    this.mFlags &= (paramInt ^ 0xFFFFFFFF);
    return this;
  }
  
  @SuppressLint({"SyntheticAccessor"})
  @NonNull
  public NotificationCompat.BubbleMetadata build()
  {
    if (this.mPendingIntent == null) {
      throw new IllegalStateException("Must supply pending intent to bubble");
    }
    if (this.mIcon == null) {
      throw new IllegalStateException("Must supply an icon for the bubble");
    }
    return new NotificationCompat.BubbleMetadata(this.mPendingIntent, this.mDeleteIntent, this.mIcon, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, null);
  }
  
  @NonNull
  public Builder setAutoExpandBubble(boolean paramBoolean)
  {
    setFlag(1, paramBoolean);
    return this;
  }
  
  @NonNull
  public Builder setDeleteIntent(@Nullable PendingIntent paramPendingIntent)
  {
    this.mDeleteIntent = paramPendingIntent;
    return this;
  }
  
  @NonNull
  public Builder setDesiredHeight(@Dimension(unit=0) int paramInt)
  {
    this.mDesiredHeight = Math.max(paramInt, 0);
    this.mDesiredHeightResId = 0;
    return this;
  }
  
  @NonNull
  public Builder setDesiredHeightResId(@DimenRes int paramInt)
  {
    this.mDesiredHeightResId = paramInt;
    this.mDesiredHeight = 0;
    return this;
  }
  
  @NonNull
  public Builder setIcon(@NonNull IconCompat paramIconCompat)
  {
    if (paramIconCompat == null) {
      throw new IllegalArgumentException("Bubbles require non-null icon");
    }
    if (paramIconCompat.getType() == 1) {
      throw new IllegalArgumentException("When using bitmap based icons, Bubbles require TYPE_ADAPTIVE_BITMAP, please use IconCompat#createWithAdaptiveBitmap instead");
    }
    this.mIcon = paramIconCompat;
    return this;
  }
  
  @NonNull
  public Builder setIntent(@NonNull PendingIntent paramPendingIntent)
  {
    if (paramPendingIntent == null) {
      throw new IllegalArgumentException("Bubble requires non-null pending intent");
    }
    this.mPendingIntent = paramPendingIntent;
    return this;
  }
  
  @NonNull
  public Builder setSuppressNotification(boolean paramBoolean)
  {
    setFlag(2, paramBoolean);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.BubbleMetadata.Builder
 * JD-Core Version:    0.7.0.1
 */