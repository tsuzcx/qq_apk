import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;

public final class bero
  implements Parcelable.Creator<DebugInfo>
{
  public DebugInfo a(Parcel paramParcel)
  {
    DebugInfo localDebugInfo = new DebugInfo();
    localDebugInfo.a = paramParcel.readString();
    localDebugInfo.b = paramParcel.readString();
    return localDebugInfo;
  }
  
  public DebugInfo[] a(int paramInt)
  {
    return new DebugInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bero
 * JD-Core Version:    0.7.0.1
 */