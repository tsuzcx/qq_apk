import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public final class berf
  implements Parcelable.Creator<MiniAppInfo>
{
  public MiniAppInfo a(Parcel paramParcel)
  {
    return new MiniAppInfo(paramParcel);
  }
  
  public MiniAppInfo[] a(int paramInt)
  {
    return new MiniAppInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berf
 * JD-Core Version:    0.7.0.1
 */