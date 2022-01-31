import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;

public final class berv
  implements Parcelable.Creator<MiniAppBaseInfo>
{
  public MiniAppBaseInfo a(Parcel paramParcel)
  {
    return new MiniAppBaseInfo(paramParcel);
  }
  
  public MiniAppBaseInfo[] a(int paramInt)
  {
    return new MiniAppBaseInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berv
 * JD-Core Version:    0.7.0.1
 */