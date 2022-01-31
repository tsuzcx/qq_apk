import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsDataV2.GpsInfo;

public final class amyu
  implements Parcelable.Creator
{
  public LbsDataV2.GpsInfo a(Parcel paramParcel)
  {
    LbsDataV2.GpsInfo localGpsInfo = new LbsDataV2.GpsInfo();
    if (paramParcel != null)
    {
      localGpsInfo.lat = paramParcel.readInt();
      localGpsInfo.lon = paramParcel.readInt();
      localGpsInfo.alt = paramParcel.readInt();
      localGpsInfo.gpsType = paramParcel.readInt();
      localGpsInfo.accuracy = paramParcel.readInt();
    }
    return localGpsInfo;
  }
  
  public LbsDataV2.GpsInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyu
 * JD-Core Version:    0.7.0.1
 */