import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;

public final class avjq
  implements Parcelable.Creator<PicInfo>
{
  public PicInfo a(Parcel paramParcel)
  {
    return new PicInfo(paramParcel);
  }
  
  public PicInfo[] a(int paramInt)
  {
    return new PicInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avjq
 * JD-Core Version:    0.7.0.1
 */