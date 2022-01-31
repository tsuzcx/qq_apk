import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;

public final class amze
  implements Parcelable.Creator<ArConfigInfo>
{
  public ArConfigInfo a(Parcel paramParcel)
  {
    return new ArConfigInfo(paramParcel);
  }
  
  public ArConfigInfo[] a(int paramInt)
  {
    return new ArConfigInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amze
 * JD-Core Version:    0.7.0.1
 */