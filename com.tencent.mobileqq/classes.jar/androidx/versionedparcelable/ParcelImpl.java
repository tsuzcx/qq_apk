package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class ParcelImpl
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelImpl> CREATOR = new ParcelImpl.1();
  private final VersionedParcelable mParcel;
  
  protected ParcelImpl(Parcel paramParcel)
  {
    this.mParcel = new VersionedParcelParcel(paramParcel).readVersionedParcelable();
  }
  
  public ParcelImpl(VersionedParcelable paramVersionedParcelable)
  {
    this.mParcel = paramVersionedParcelable;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public <T extends VersionedParcelable> T getVersionedParcel()
  {
    return this.mParcel;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new VersionedParcelParcel(paramParcel).writeVersionedParcelable(this.mParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.versionedparcelable.ParcelImpl
 * JD-Core Version:    0.7.0.1
 */