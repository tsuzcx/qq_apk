import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.album.QzonePhotoInfo;

public final class bhbv
  implements Parcelable.Creator<QzonePhotoInfo>
{
  public QzonePhotoInfo a(Parcel paramParcel)
  {
    return new QzonePhotoInfo(paramParcel);
  }
  
  public QzonePhotoInfo[] a(int paramInt)
  {
    return new QzonePhotoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhbv
 * JD-Core Version:    0.7.0.1
 */