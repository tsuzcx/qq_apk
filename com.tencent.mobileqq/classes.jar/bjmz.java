import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.downloadnew.DownloadInfo;

public final class bjmz
  implements Parcelable.Creator<DownloadInfo>
{
  public DownloadInfo a(Parcel paramParcel)
  {
    return new DownloadInfo(paramParcel);
  }
  
  public DownloadInfo[] a(int paramInt)
  {
    return new DownloadInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjmz
 * JD-Core Version:    0.7.0.1
 */