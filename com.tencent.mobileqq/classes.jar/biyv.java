import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsDataV2.GpsInfo;

public final class biyv
  implements Parcelable.Creator<LbsDataV2.GpsInfo>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biyv
 * JD-Core Version:    0.7.0.1
 */