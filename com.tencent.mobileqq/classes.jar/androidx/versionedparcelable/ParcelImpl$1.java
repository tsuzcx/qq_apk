package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ParcelImpl$1
  implements Parcelable.Creator<ParcelImpl>
{
  public ParcelImpl createFromParcel(Parcel paramParcel)
  {
    return new ParcelImpl(paramParcel);
  }
  
  public ParcelImpl[] newArray(int paramInt)
  {
    return new ParcelImpl[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.versionedparcelable.ParcelImpl.1
 * JD-Core Version:    0.7.0.1
 */