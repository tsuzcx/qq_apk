import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.wadl.ipc.WadlParams;

public final class bkij
  implements Parcelable.Creator<WadlParams>
{
  public WadlParams a(Parcel paramParcel)
  {
    WadlParams localWadlParams = new WadlParams("");
    localWadlParams.a(paramParcel);
    return localWadlParams;
  }
  
  public WadlParams[] a(int paramInt)
  {
    return new WadlParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkij
 * JD-Core Version:    0.7.0.1
 */