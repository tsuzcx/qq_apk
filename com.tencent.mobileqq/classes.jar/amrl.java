import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsDataV2.WifiInfo;

public final class amrl
  implements Parcelable.Creator
{
  public LbsDataV2.WifiInfo a(Parcel paramParcel)
  {
    LbsDataV2.WifiInfo localWifiInfo = new LbsDataV2.WifiInfo();
    if (paramParcel != null)
    {
      localWifiInfo.mac = paramParcel.readString();
      localWifiInfo.rssi = paramParcel.readInt();
    }
    return localWifiInfo;
  }
  
  public LbsDataV2.WifiInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrl
 * JD-Core Version:    0.7.0.1
 */