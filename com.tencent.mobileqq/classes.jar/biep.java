import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.model.VirtualInfo;

public final class biep
  implements Parcelable.Creator<VirtualInfo>
{
  public VirtualInfo a(Parcel paramParcel)
  {
    return new VirtualInfo(paramParcel);
  }
  
  public VirtualInfo[] a(int paramInt)
  {
    return new VirtualInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biep
 * JD-Core Version:    0.7.0.1
 */