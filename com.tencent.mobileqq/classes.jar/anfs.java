import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArWebInfo;

public final class anfs
  implements Parcelable.Creator<ArWebInfo>
{
  public ArWebInfo a(Parcel paramParcel)
  {
    return new ArWebInfo(paramParcel);
  }
  
  public ArWebInfo[] a(int paramInt)
  {
    return new ArWebInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfs
 * JD-Core Version:    0.7.0.1
 */