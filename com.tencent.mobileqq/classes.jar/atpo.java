import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;

public final class atpo
  implements Parcelable.Creator<FavFileInfo>
{
  public FavFileInfo a(Parcel paramParcel)
  {
    return new FavFileInfo(paramParcel);
  }
  
  public FavFileInfo[] a(int paramInt)
  {
    return new FavFileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpo
 * JD-Core Version:    0.7.0.1
 */