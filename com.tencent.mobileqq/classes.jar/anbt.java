import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.BusinessAlbumInfo;

public final class anbt
  implements Parcelable.Creator
{
  public BusinessAlbumInfo a(Parcel paramParcel)
  {
    return new BusinessAlbumInfo(paramParcel, null);
  }
  
  public BusinessAlbumInfo[] a(int paramInt)
  {
    return new BusinessAlbumInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbt
 * JD-Core Version:    0.7.0.1
 */