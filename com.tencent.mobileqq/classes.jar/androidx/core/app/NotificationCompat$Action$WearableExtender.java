package androidx.core.app;

import android.os.Bundle;

public final class NotificationCompat$Action$WearableExtender
  implements NotificationCompat.Action.Extender
{
  private static final int DEFAULT_FLAGS = 1;
  private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
  private static final int FLAG_AVAILABLE_OFFLINE = 1;
  private static final int FLAG_HINT_DISPLAY_INLINE = 4;
  private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
  private static final String KEY_CANCEL_LABEL = "cancelLabel";
  private static final String KEY_CONFIRM_LABEL = "confirmLabel";
  private static final String KEY_FLAGS = "flags";
  private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
  private CharSequence mCancelLabel;
  private CharSequence mConfirmLabel;
  private int mFlags = 1;
  private CharSequence mInProgressLabel;
  
  public NotificationCompat$Action$WearableExtender() {}
  
  public NotificationCompat$Action$WearableExtender(NotificationCompat.Action paramAction)
  {
    paramAction = paramAction.getExtras().getBundle("android.wearable.EXTENSIONS");
    if (paramAction != null)
    {
      this.mFlags = paramAction.getInt("flags", 1);
      this.mInProgressLabel = paramAction.getCharSequence("inProgressLabel");
      this.mConfirmLabel = paramAction.getCharSequence("confirmLabel");
      this.mCancelLabel = paramAction.getCharSequence("cancelLabel");
    }
  }
  
  private void setFlag(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFlags |= paramInt;
      return;
    }
    this.mFlags &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public WearableExtender clone()
  {
    WearableExtender localWearableExtender = new WearableExtender();
    localWearableExtender.mFlags = this.mFlags;
    localWearableExtender.mInProgressLabel = this.mInProgressLabel;
    localWearableExtender.mConfirmLabel = this.mConfirmLabel;
    localWearableExtender.mCancelLabel = this.mCancelLabel;
    return localWearableExtender;
  }
  
  public NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder paramBuilder)
  {
    Bundle localBundle = new Bundle();
    if (this.mFlags != 1) {
      localBundle.putInt("flags", this.mFlags);
    }
    if (this.mInProgressLabel != null) {
      localBundle.putCharSequence("inProgressLabel", this.mInProgressLabel);
    }
    if (this.mConfirmLabel != null) {
      localBundle.putCharSequence("confirmLabel", this.mConfirmLabel);
    }
    if (this.mCancelLabel != null) {
      localBundle.putCharSequence("cancelLabel", this.mCancelLabel);
    }
    paramBuilder.getExtras().putBundle("android.wearable.EXTENSIONS", localBundle);
    return paramBuilder;
  }
  
  @Deprecated
  public CharSequence getCancelLabel()
  {
    return this.mCancelLabel;
  }
  
  @Deprecated
  public CharSequence getConfirmLabel()
  {
    return this.mConfirmLabel;
  }
  
  public boolean getHintDisplayActionInline()
  {
    return (this.mFlags & 0x4) != 0;
  }
  
  public boolean getHintLaunchesActivity()
  {
    return (this.mFlags & 0x2) != 0;
  }
  
  @Deprecated
  public CharSequence getInProgressLabel()
  {
    return this.mInProgressLabel;
  }
  
  public boolean isAvailableOffline()
  {
    return (this.mFlags & 0x1) != 0;
  }
  
  public WearableExtender setAvailableOffline(boolean paramBoolean)
  {
    setFlag(1, paramBoolean);
    return this;
  }
  
  @Deprecated
  public WearableExtender setCancelLabel(CharSequence paramCharSequence)
  {
    this.mCancelLabel = paramCharSequence;
    return this;
  }
  
  @Deprecated
  public WearableExtender setConfirmLabel(CharSequence paramCharSequence)
  {
    this.mConfirmLabel = paramCharSequence;
    return this;
  }
  
  public WearableExtender setHintDisplayActionInline(boolean paramBoolean)
  {
    setFlag(4, paramBoolean);
    return this;
  }
  
  public WearableExtender setHintLaunchesActivity(boolean paramBoolean)
  {
    setFlag(2, paramBoolean);
    return this;
  }
  
  @Deprecated
  public WearableExtender setInProgressLabel(CharSequence paramCharSequence)
  {
    this.mInProgressLabel = paramCharSequence;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.app.NotificationCompat.Action.WearableExtender
 * JD-Core Version:    0.7.0.1
 */