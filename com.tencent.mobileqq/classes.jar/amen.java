import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.MapParcelable;

public final class amen
  implements Parcelable.Creator
{
  public MapParcelable a(Parcel paramParcel)
  {
    return new MapParcelable(paramParcel.readHashMap(getClass().getClassLoader()));
  }
  
  public MapParcelable[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amen
 * JD-Core Version:    0.7.0.1
 */