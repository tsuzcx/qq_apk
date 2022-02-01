package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

class ActivityResult$1
  implements Parcelable.Creator<ActivityResult>
{
  public ActivityResult createFromParcel(@NonNull Parcel paramParcel)
  {
    return new ActivityResult(paramParcel);
  }
  
  public ActivityResult[] newArray(int paramInt)
  {
    return new ActivityResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.ActivityResult.1
 * JD-Core Version:    0.7.0.1
 */