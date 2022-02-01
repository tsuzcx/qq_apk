import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;

public final class axwj
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axwj
 * JD-Core Version:    0.7.0.1
 */