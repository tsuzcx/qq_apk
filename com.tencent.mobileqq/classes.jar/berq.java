import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo;

public final class berq
  implements Parcelable.Creator<SecondApiRightInfo>
{
  public SecondApiRightInfo a(Parcel paramParcel)
  {
    SecondApiRightInfo localSecondApiRightInfo = new SecondApiRightInfo();
    localSecondApiRightInfo.apiName = paramParcel.readString();
    localSecondApiRightInfo.secondName = paramParcel.readString();
    localSecondApiRightInfo.right = paramParcel.readInt();
    return localSecondApiRightInfo;
  }
  
  public SecondApiRightInfo[] a(int paramInt)
  {
    return new SecondApiRightInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     berq
 * JD-Core Version:    0.7.0.1
 */