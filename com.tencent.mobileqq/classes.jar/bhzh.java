import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.vip.jsoninflate.model.AlumBasicData;

public final class bhzh
  implements Parcelable.Creator<AlumBasicData>
{
  public AlumBasicData a(Parcel paramParcel)
  {
    return new AlumBasicData(paramParcel);
  }
  
  public AlumBasicData[] a(int paramInt)
  {
    return new AlumBasicData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhzh
 * JD-Core Version:    0.7.0.1
 */