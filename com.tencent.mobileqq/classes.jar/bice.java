import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.wadl.ipc.WadlResult;

public final class bice
  implements Parcelable.Creator<WadlResult>
{
  public WadlResult a(Parcel paramParcel)
  {
    return new WadlResult(paramParcel);
  }
  
  public WadlResult[] a(int paramInt)
  {
    return new WadlResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bice
 * JD-Core Version:    0.7.0.1
 */