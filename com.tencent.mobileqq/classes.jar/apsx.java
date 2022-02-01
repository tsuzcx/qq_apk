import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.armap.POIInfo;

public final class apsx
  implements Parcelable.Creator<POIInfo>
{
  public POIInfo a(Parcel paramParcel)
  {
    return new POIInfo(paramParcel);
  }
  
  public POIInfo[] a(int paramInt)
  {
    return new POIInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsx
 * JD-Core Version:    0.7.0.1
 */