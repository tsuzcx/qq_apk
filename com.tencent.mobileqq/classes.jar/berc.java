import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;

public final class berc
  implements Parcelable.Creator<LaunchParam>
{
  public LaunchParam a(Parcel paramParcel)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    try
    {
      localLaunchParam.a(paramParcel);
      return localLaunchParam;
    }
    catch (Throwable paramParcel)
    {
      besl.d("miniapp", "LaunchParam createFromParcel exception!", paramParcel);
    }
    return localLaunchParam;
  }
  
  public LaunchParam[] a(int paramInt)
  {
    return new LaunchParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berc
 * JD-Core Version:    0.7.0.1
 */