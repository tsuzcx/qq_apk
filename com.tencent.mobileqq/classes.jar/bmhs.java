import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.statistic.serverip.WebAppIpRecord;

public final class bmhs
  implements Parcelable.Creator<WebAppIpRecord>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhs
 * JD-Core Version:    0.7.0.1
 */