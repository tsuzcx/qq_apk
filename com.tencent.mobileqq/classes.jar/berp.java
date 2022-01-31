import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.RenderInfo;

public final class berp
  implements Parcelable.Creator<RenderInfo>
{
  public RenderInfo a(Parcel paramParcel)
  {
    return new RenderInfo(paramParcel);
  }
  
  public RenderInfo[] a(int paramInt)
  {
    return new RenderInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berp
 * JD-Core Version:    0.7.0.1
 */