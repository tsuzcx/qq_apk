import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.statistic.serverip.WebAppIpRecord;

public final class anib
  implements Parcelable.Creator
{
  public WebAppIpRecord a(Parcel paramParcel)
  {
    return new WebAppIpRecord(paramParcel);
  }
  
  public WebAppIpRecord[] a(int paramInt)
  {
    return new WebAppIpRecord[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anib
 * JD-Core Version:    0.7.0.1
 */