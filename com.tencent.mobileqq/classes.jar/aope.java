import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public final class aope
  implements Parcelable.Creator<SosoInterface.SosoLocation>
{
  public SosoInterface.SosoLocation a(Parcel paramParcel)
  {
    return new SosoInterface.SosoLocation(paramParcel);
  }
  
  public SosoInterface.SosoLocation[] a(int paramInt)
  {
    return new SosoInterface.SosoLocation[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aope
 * JD-Core Version:    0.7.0.1
 */