import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;

public final class bdms
  implements Parcelable.Creator<FirstPageInfo>
{
  public FirstPageInfo a(Parcel paramParcel)
  {
    FirstPageInfo localFirstPageInfo = new FirstPageInfo();
    localFirstPageInfo.a = paramParcel.readString();
    localFirstPageInfo.b = paramParcel.readString();
    return localFirstPageInfo;
  }
  
  public FirstPageInfo[] a(int paramInt)
  {
    return new FirstPageInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdms
 * JD-Core Version:    0.7.0.1
 */