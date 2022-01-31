import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;

public final class anpn
  implements Parcelable.Creator<MiniAppRecommInfo>
{
  public MiniAppRecommInfo a(Parcel paramParcel)
  {
    return new MiniAppRecommInfo(paramParcel);
  }
  
  public MiniAppRecommInfo[] a(int paramInt)
  {
    return new MiniAppRecommInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anpn
 * JD-Core Version:    0.7.0.1
 */