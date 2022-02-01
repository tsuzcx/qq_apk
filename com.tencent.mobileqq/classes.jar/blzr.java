import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.WeishiBasicInfo;

public final class blzr
  implements Parcelable.Creator<WeishiBasicInfo>
{
  public WeishiBasicInfo a(Parcel paramParcel)
  {
    return new WeishiBasicInfo(paramParcel);
  }
  
  public WeishiBasicInfo[] a(int paramInt)
  {
    return new WeishiBasicInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzr
 * JD-Core Version:    0.7.0.1
 */