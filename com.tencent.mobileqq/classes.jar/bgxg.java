import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsDataV2.GeoInfo;
import cooperation.qzone.LbsDataV2.GetGeoInfoRsp;
import cooperation.qzone.LbsDataV2.GpsInfo;

public final class bgxg
  implements Parcelable.Creator<LbsDataV2.GetGeoInfoRsp>
{
  public LbsDataV2.GetGeoInfoRsp a(Parcel paramParcel)
  {
    LbsDataV2.GetGeoInfoRsp localGetGeoInfoRsp = new LbsDataV2.GetGeoInfoRsp();
    if (paramParcel != null)
    {
      localGetGeoInfoRsp.stGps = ((LbsDataV2.GpsInfo)paramParcel.readParcelable(LbsDataV2.GpsInfo.class.getClassLoader()));
      localGetGeoInfoRsp.stGeoInfo = ((LbsDataV2.GeoInfo)paramParcel.readParcelable(LbsDataV2.GeoInfo.class.getClassLoader()));
    }
    return localGetGeoInfoRsp;
  }
  
  public LbsDataV2.GetGeoInfoRsp[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgxg
 * JD-Core Version:    0.7.0.1
 */