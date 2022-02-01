import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class blep
  implements Parcelable.Creator<String>
{
  public String a(Parcel paramParcel)
  {
    return paramParcel.readString();
  }
  
  public String[] a(int paramInt)
  {
    return new String[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blep
 * JD-Core Version:    0.7.0.1
 */