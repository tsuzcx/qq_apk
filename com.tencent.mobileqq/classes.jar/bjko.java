import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.BusinessAlbumInfo;

public final class bjko
  implements Parcelable.Creator<BusinessAlbumInfo>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjko
 * JD-Core Version:    0.7.0.1
 */