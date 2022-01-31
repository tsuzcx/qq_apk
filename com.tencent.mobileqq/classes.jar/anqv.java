import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.poi.PoiInfo;

public final class anqv
  implements Parcelable.Creator
{
  public PoiInfo a(Parcel paramParcel)
  {
    return new PoiInfo(paramParcel, null);
  }
  
  public PoiInfo[] a(int paramInt)
  {
    return new PoiInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anqv
 * JD-Core Version:    0.7.0.1
 */