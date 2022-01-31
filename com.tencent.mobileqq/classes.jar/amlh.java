import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;

public final class amlh
  implements Parcelable.Creator<SosoInterface.SosoLbsInfo>
{
  public SosoInterface.SosoLbsInfo a(Parcel paramParcel)
  {
    return new SosoInterface.SosoLbsInfo(paramParcel);
  }
  
  public SosoInterface.SosoLbsInfo[] a(int paramInt)
  {
    return new SosoInterface.SosoLbsInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amlh
 * JD-Core Version:    0.7.0.1
 */