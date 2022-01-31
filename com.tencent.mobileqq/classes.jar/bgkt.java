import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.core.utils.FileInfo;

public final class bgkt
  implements Parcelable.Creator<FileInfo>
{
  public FileInfo a(Parcel paramParcel)
  {
    return new FileInfo(paramParcel, null);
  }
  
  public FileInfo[] a(int paramInt)
  {
    return new FileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgkt
 * JD-Core Version:    0.7.0.1
 */