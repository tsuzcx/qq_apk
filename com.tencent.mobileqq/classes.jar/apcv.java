import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;

public final class apcv
  implements Parcelable.Creator<SosoInterface.SosoWifi>
{
  public SosoInterface.SosoWifi a(Parcel paramParcel)
  {
    return new SosoInterface.SosoWifi(paramParcel);
  }
  
  public SosoInterface.SosoWifi[] a(int paramInt)
  {
    return new SosoInterface.SosoWifi[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcv
 * JD-Core Version:    0.7.0.1
 */