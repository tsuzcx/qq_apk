import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.WeishiPictureUrl;

public final class bhff
  implements Parcelable.Creator<WeishiPictureUrl>
{
  public WeishiPictureUrl a(Parcel paramParcel)
  {
    return new WeishiPictureUrl(paramParcel);
  }
  
  public WeishiPictureUrl[] a(int paramInt)
  {
    return new WeishiPictureUrl[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhff
 * JD-Core Version:    0.7.0.1
 */