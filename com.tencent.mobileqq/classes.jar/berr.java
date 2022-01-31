import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo;

public final class berr
  implements Parcelable.Creator<ExtConfigInfo>
{
  public ExtConfigInfo a(Parcel paramParcel)
  {
    return new ExtConfigInfo(paramParcel);
  }
  
  public ExtConfigInfo[] a(int paramInt)
  {
    return new ExtConfigInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berr
 * JD-Core Version:    0.7.0.1
 */