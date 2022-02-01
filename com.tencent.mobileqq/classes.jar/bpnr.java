import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.capture.data.LockedCategory;

public final class bpnr
  implements Parcelable.Creator<LockedCategory>
{
  public LockedCategory a(Parcel paramParcel)
  {
    return new LockedCategory(paramParcel);
  }
  
  public LockedCategory[] a(int paramInt)
  {
    return new LockedCategory[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpnr
 * JD-Core Version:    0.7.0.1
 */