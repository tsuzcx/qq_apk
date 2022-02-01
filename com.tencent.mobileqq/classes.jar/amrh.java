import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.apollo.data.ApolloDress.Dress;

public final class amrh
  implements Parcelable.Creator<ApolloDress.Dress>
{
  public ApolloDress.Dress a(Parcel paramParcel)
  {
    return new ApolloDress.Dress(paramParcel);
  }
  
  public ApolloDress.Dress[] a(int paramInt)
  {
    return new ApolloDress.Dress[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrh
 * JD-Core Version:    0.7.0.1
 */