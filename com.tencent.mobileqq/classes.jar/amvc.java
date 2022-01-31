import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.WeishiOperationInfo;

public final class amvc
  implements Parcelable.Creator
{
  public WeishiOperationInfo a(Parcel paramParcel)
  {
    return new WeishiOperationInfo(paramParcel);
  }
  
  public WeishiOperationInfo[] a(int paramInt)
  {
    return new WeishiOperationInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvc
 * JD-Core Version:    0.7.0.1
 */