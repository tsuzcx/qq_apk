import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.dating.DatingFilters;

public final class aphx
  implements Parcelable.Creator<DatingFilters>
{
  public DatingFilters a(Parcel paramParcel)
  {
    return new DatingFilters(paramParcel, null);
  }
  
  public DatingFilters[] a(int paramInt)
  {
    return new DatingFilters[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphx
 * JD-Core Version:    0.7.0.1
 */