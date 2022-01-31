import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.WeishiInterestInfo;

public final class bfws
  implements Parcelable.Creator<WeishiInterestInfo>
{
  public WeishiInterestInfo a(Parcel paramParcel)
  {
    return new WeishiInterestInfo(paramParcel);
  }
  
  public WeishiInterestInfo[] a(int paramInt)
  {
    return new WeishiInterestInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfws
 * JD-Core Version:    0.7.0.1
 */