import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.manager.EngineVersion;

public final class bdos
  implements Parcelable.Creator<EngineVersion>
{
  public EngineVersion a(Parcel paramParcel)
  {
    EngineVersion localEngineVersion = new EngineVersion();
    localEngineVersion.a = paramParcel.readString();
    localEngineVersion.b = paramParcel.readString();
    return localEngineVersion;
  }
  
  public EngineVersion[] a(int paramInt)
  {
    return new EngineVersion[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdos
 * JD-Core Version:    0.7.0.1
 */