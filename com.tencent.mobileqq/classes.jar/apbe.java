import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.QQPhotoInfo;

public final class apbe
  implements Parcelable.Creator<QQPhotoInfo>
{
  public QQPhotoInfo a(Parcel paramParcel)
  {
    return new QQPhotoInfo(paramParcel, null);
  }
  
  public QQPhotoInfo[] a(int paramInt)
  {
    return new QQPhotoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbe
 * JD-Core Version:    0.7.0.1
 */