package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult
  implements Parcelable
{
  @NonNull
  public static final Parcelable.Creator<ActivityResult> CREATOR = new ActivityResult.1();
  @Nullable
  private final Intent mData;
  private final int mResultCode;
  
  public ActivityResult(int paramInt, @Nullable Intent paramIntent)
  {
    this.mResultCode = paramInt;
    this.mData = paramIntent;
  }
  
  ActivityResult(Parcel paramParcel)
  {
    this.mResultCode = paramParcel.readInt();
    if (paramParcel.readInt() == 0) {
      paramParcel = null;
    } else {
      paramParcel = (Intent)Intent.CREATOR.createFromParcel(paramParcel);
    }
    this.mData = paramParcel;
  }
  
  @NonNull
  public static String resultCodeToString(int paramInt)
  {
    if (paramInt != -1)
    {
      if (paramInt != 0) {
        return String.valueOf(paramInt);
      }
      return "RESULT_CANCELED";
    }
    return "RESULT_OK";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Nullable
  public Intent getData()
  {
    return this.mData;
  }
  
  public int getResultCode()
  {
    return this.mResultCode;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ActivityResult{resultCode=");
    localStringBuilder.append(resultCodeToString(this.mResultCode));
    localStringBuilder.append(", data=");
    localStringBuilder.append(this.mData);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mResultCode);
    int i;
    if (this.mData == null) {
      i = 0;
    } else {
      i = 1;
    }
    paramParcel.writeInt(i);
    Intent localIntent = this.mData;
    if (localIntent != null) {
      localIntent.writeToParcel(paramParcel, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.ActivityResult
 * JD-Core Version:    0.7.0.1
 */