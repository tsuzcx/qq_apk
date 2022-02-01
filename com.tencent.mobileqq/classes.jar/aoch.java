import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.ARScanAR;

public final class aoch
  implements Parcelable.Creator<ARScanAR>
{
  public ARScanAR a(Parcel paramParcel)
  {
    return new ARScanAR(paramParcel);
  }
  
  public ARScanAR[] a(int paramInt)
  {
    return new ARScanAR[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoch
 * JD-Core Version:    0.7.0.1
 */