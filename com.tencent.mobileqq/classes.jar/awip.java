import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pic.CompressInfo;

public final class awip
  implements Parcelable.Creator<CompressInfo>
{
  public CompressInfo a(Parcel paramParcel)
  {
    return new CompressInfo(paramParcel, null);
  }
  
  public CompressInfo[] a(int paramInt)
  {
    return new CompressInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awip
 * JD-Core Version:    0.7.0.1
 */