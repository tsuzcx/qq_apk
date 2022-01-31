import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

public final class amun
  implements Parcelable.Creator<ArCloudConfigInfo>
{
  public ArCloudConfigInfo a(Parcel paramParcel)
  {
    return new ArCloudConfigInfo(paramParcel);
  }
  
  public ArCloudConfigInfo[] a(int paramInt)
  {
    return new ArCloudConfigInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amun
 * JD-Core Version:    0.7.0.1
 */