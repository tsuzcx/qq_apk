import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.WeishiPictureUrl;

public final class bjlo
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjlo
 * JD-Core Version:    0.7.0.1
 */