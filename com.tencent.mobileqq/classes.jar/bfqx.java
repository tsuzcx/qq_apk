import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.model.AppInfo;

public final class bfqx
  implements Parcelable.Creator<AppInfo>
{
  public AppInfo a(Parcel paramParcel)
  {
    return new AppInfo(paramParcel);
  }
  
  public AppInfo[] a(int paramInt)
  {
    return new AppInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfqx
 * JD-Core Version:    0.7.0.1
 */