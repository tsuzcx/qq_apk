package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class IntentSenderRequest$1
  implements Parcelable.Creator<IntentSenderRequest>
{
  public IntentSenderRequest createFromParcel(Parcel paramParcel)
  {
    return new IntentSenderRequest(paramParcel);
  }
  
  public IntentSenderRequest[] newArray(int paramInt)
  {
    return new IntentSenderRequest[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.IntentSenderRequest.1
 * JD-Core Version:    0.7.0.1
 */