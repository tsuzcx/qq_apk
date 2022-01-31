import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsDataV2.CellInfo;

public final class bfox
  implements Parcelable.Creator<LbsDataV2.CellInfo>
{
  public LbsDataV2.CellInfo a(Parcel paramParcel)
  {
    LbsDataV2.CellInfo localCellInfo = new LbsDataV2.CellInfo();
    if (paramParcel != null)
    {
      localCellInfo.mcc = paramParcel.readInt();
      localCellInfo.mnc = paramParcel.readInt();
      localCellInfo.lac = paramParcel.readInt();
      localCellInfo.cellId = paramParcel.readInt();
      localCellInfo.rssi = paramParcel.readInt();
      localCellInfo.stationLat = paramParcel.readDouble();
      localCellInfo.stationLon = paramParcel.readDouble();
    }
    return localCellInfo;
  }
  
  public LbsDataV2.CellInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfox
 * JD-Core Version:    0.7.0.1
 */