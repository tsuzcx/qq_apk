import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.qq.im.poi.LbsPackInfo;

public final class amp
  implements Parcelable.Creator
{
  public LbsPackInfo a(Parcel paramParcel)
  {
    return new LbsPackInfo(paramParcel);
  }
  
  public LbsPackInfo[] a(int paramInt)
  {
    return new LbsPackInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     amp
 * JD-Core Version:    0.7.0.1
 */