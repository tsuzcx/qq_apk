import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;

public final class berg
  implements Parcelable.Creator<MiniGamePluginInfo>
{
  public MiniGamePluginInfo a(Parcel paramParcel)
  {
    return new MiniGamePluginInfo(paramParcel);
  }
  
  public MiniGamePluginInfo[] a(int paramInt)
  {
    return new MiniGamePluginInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berg
 * JD-Core Version:    0.7.0.1
 */