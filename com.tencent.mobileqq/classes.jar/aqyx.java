import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;

public final class aqyx
  implements Parcelable.Creator<LocationRoom.Venue>
{
  public LocationRoom.Venue a(Parcel paramParcel)
  {
    return new LocationRoom.Venue(paramParcel);
  }
  
  public LocationRoom.Venue[] a(int paramInt)
  {
    return new LocationRoom.Venue[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqyx
 * JD-Core Version:    0.7.0.1
 */