import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.downloadnew.DownloadInfo;

public final class bfjz
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfjz
 * JD-Core Version:    0.7.0.1
 */