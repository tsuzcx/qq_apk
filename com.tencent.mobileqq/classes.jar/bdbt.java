import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.util.FaceInfo;

public final class bdbt
  implements Parcelable.Creator<FaceInfo>
{
  public FaceInfo a(Parcel paramParcel)
  {
    FaceInfo localFaceInfo = new FaceInfo();
    localFaceInfo.a(paramParcel);
    return localFaceInfo;
  }
  
  public FaceInfo[] a(int paramInt)
  {
    return new FaceInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbt
 * JD-Core Version:    0.7.0.1
 */