import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.capture.paster.PasterParcelData;

public final class bjfq
  implements Parcelable.Creator<PasterParcelData>
{
  public PasterParcelData a(Parcel paramParcel)
  {
    return new PasterParcelData(paramParcel);
  }
  
  public PasterParcelData[] a(int paramInt)
  {
    return new PasterParcelData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfq
 * JD-Core Version:    0.7.0.1
 */