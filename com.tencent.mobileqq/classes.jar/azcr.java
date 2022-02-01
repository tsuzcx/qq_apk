import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.olympic.OlyimpicConfig;

public final class azcr
  implements Parcelable.Creator<OlyimpicConfig>
{
  public OlyimpicConfig a(Parcel paramParcel)
  {
    return new OlyimpicConfig(paramParcel);
  }
  
  public OlyimpicConfig[] a(int paramInt)
  {
    return new OlyimpicConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azcr
 * JD-Core Version:    0.7.0.1
 */