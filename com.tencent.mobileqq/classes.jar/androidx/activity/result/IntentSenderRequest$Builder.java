package androidx.activity.result;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class IntentSenderRequest$Builder
{
  private Intent mFillInIntent;
  private int mFlagsMask;
  private int mFlagsValues;
  private IntentSender mIntentSender;
  
  public IntentSenderRequest$Builder(@NonNull PendingIntent paramPendingIntent)
  {
    this(paramPendingIntent.getIntentSender());
  }
  
  public IntentSenderRequest$Builder(@NonNull IntentSender paramIntentSender)
  {
    this.mIntentSender = paramIntentSender;
  }
  
  @NonNull
  public IntentSenderRequest build()
  {
    return new IntentSenderRequest(this.mIntentSender, this.mFillInIntent, this.mFlagsMask, this.mFlagsValues);
  }
  
  @NonNull
  public Builder setFillInIntent(@Nullable Intent paramIntent)
  {
    this.mFillInIntent = paramIntent;
    return this;
  }
  
  @NonNull
  public Builder setFlags(int paramInt1, int paramInt2)
  {
    this.mFlagsValues = paramInt1;
    this.mFlagsMask = paramInt2;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.IntentSenderRequest.Builder
 * JD-Core Version:    0.7.0.1
 */