import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;

public final class amyz
  implements Parcelable.Creator<ARCommonConfigInfo.NativeSoRes>
{
  public ARCommonConfigInfo.NativeSoRes a(Parcel paramParcel)
  {
    return new ARCommonConfigInfo.NativeSoRes(paramParcel);
  }
  
  public ARCommonConfigInfo.NativeSoRes[] a(int paramInt)
  {
    return new ARCommonConfigInfo.NativeSoRes[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyz
 * JD-Core Version:    0.7.0.1
 */