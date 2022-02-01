import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.QZoneShareData;

public final class bmuc
  implements Parcelable.Creator<QZoneShareData>
{
  public QZoneShareData a(Parcel paramParcel)
  {
    return new QZoneShareData(paramParcel, null);
  }
  
  public QZoneShareData[] a(int paramInt)
  {
    return new QZoneShareData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmuc
 * JD-Core Version:    0.7.0.1
 */