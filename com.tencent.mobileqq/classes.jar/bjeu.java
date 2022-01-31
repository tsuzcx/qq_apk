import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.QZoneShareData;

public final class bjeu
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjeu
 * JD-Core Version:    0.7.0.1
 */