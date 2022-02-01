import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;

public final class aphu
  implements Parcelable.Creator<ARCommonConfigInfo>
{
  public ARCommonConfigInfo a(Parcel paramParcel)
  {
    return new ARCommonConfigInfo(paramParcel);
  }
  
  public ARCommonConfigInfo[] a(int paramInt)
  {
    return new ARCommonConfigInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphu
 * JD-Core Version:    0.7.0.1
 */