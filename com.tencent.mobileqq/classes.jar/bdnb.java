import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.PluginInfo;

public final class bdnb
  implements Parcelable.Creator<PluginInfo>
{
  public PluginInfo a(Parcel paramParcel)
  {
    PluginInfo localPluginInfo = new PluginInfo();
    PluginInfo.a(localPluginInfo, paramParcel.readString());
    PluginInfo.b(localPluginInfo, paramParcel.readString());
    return localPluginInfo;
  }
  
  public PluginInfo[] a(int paramInt)
  {
    return new PluginInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdnb
 * JD-Core Version:    0.7.0.1
 */