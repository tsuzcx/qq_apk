package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest
  implements Parcelable
{
  @NonNull
  public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new IntentSenderRequest.1();
  @Nullable
  private final Intent mFillInIntent;
  private final int mFlagsMask;
  private final int mFlagsValues;
  @NonNull
  private final IntentSender mIntentSender;
  
  IntentSenderRequest(@NonNull IntentSender paramIntentSender, @Nullable Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.mIntentSender = paramIntentSender;
    this.mFillInIntent = paramIntent;
    this.mFlagsMask = paramInt1;
    this.mFlagsValues = paramInt2;
  }
  
  IntentSenderRequest(@NonNull Parcel paramParcel)
  {
    this.mIntentSender = ((IntentSender)paramParcel.readParcelable(IntentSender.class.getClassLoader()));
    this.mFillInIntent = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    this.mFlagsMask = paramParcel.readInt();
    this.mFlagsValues = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Nullable
  public Intent getFillInIntent()
  {
    return this.mFillInIntent;
  }
  
  public int getFlagsMask()
  {
    return this.mFlagsMask;
  }
  
  public int getFlagsValues()
  {
    return this.mFlagsValues;
  }
  
  @NonNull
  public IntentSender getIntentSender()
  {
    return this.mIntentSender;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mIntentSender, paramInt);
    paramParcel.writeParcelable(this.mFillInIntent, paramInt);
    paramParcel.writeInt(this.mFlagsMask);
    paramParcel.writeInt(this.mFlagsValues);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.IntentSenderRequest
 * JD-Core Version:    0.7.0.1
 */