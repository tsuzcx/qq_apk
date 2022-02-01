import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.face.FaceInfo;

public final class aopd
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopd
 * JD-Core Version:    0.7.0.1
 */