import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;

public final class berv
  implements Parcelable.Creator<SubPkgInfo>
{
  public SubPkgInfo a(Parcel paramParcel)
  {
    SubPkgInfo localSubPkgInfo = new SubPkgInfo();
    localSubPkgInfo.subPkgName = paramParcel.readString();
    localSubPkgInfo.downloadUrl = paramParcel.readString();
    localSubPkgInfo.independent = paramParcel.readInt();
    localSubPkgInfo.fileSize = paramParcel.readInt();
    return localSubPkgInfo;
  }
  
  public SubPkgInfo[] a(int paramInt)
  {
    return new SubPkgInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berv
 * JD-Core Version:    0.7.0.1
 */