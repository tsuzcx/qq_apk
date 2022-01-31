import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.LocalImageShootInfo;

public final class amem
  implements Parcelable.Creator
{
  public LocalImageShootInfo a(Parcel paramParcel)
  {
    return new LocalImageShootInfo(paramParcel);
  }
  
  public LocalImageShootInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amem
 * JD-Core Version:    0.7.0.1
 */