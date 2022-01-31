import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.medalwall.MedalID;

public final class arju
  implements Parcelable.Creator<MedalID>
{
  public MedalID a(Parcel paramParcel)
  {
    return new MedalID(paramParcel);
  }
  
  public MedalID[] a(int paramInt)
  {
    return new MedalID[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arju
 * JD-Core Version:    0.7.0.1
 */