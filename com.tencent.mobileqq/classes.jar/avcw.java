import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;

public final class avcw
  implements Parcelable.Creator<LocationInfo>
{
  public LocationInfo a(Parcel paramParcel)
  {
    return new LocationInfo(paramParcel);
  }
  
  public LocationInfo[] a(int paramInt)
  {
    return new LocationInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avcw
 * JD-Core Version:    0.7.0.1
 */