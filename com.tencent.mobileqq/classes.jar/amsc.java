import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.QZoneShareData;

public final class amsc
  implements Parcelable.Creator
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsc
 * JD-Core Version:    0.7.0.1
 */