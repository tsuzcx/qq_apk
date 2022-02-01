import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.face.FaceInfo;

public final class anhn
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
 * Qualified Name:     anhn
 * JD-Core Version:    0.7.0.1
 */