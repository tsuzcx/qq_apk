import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.ARRecognition;

public final class apdb
  implements Parcelable.Creator<ARRecognition>
{
  public ARRecognition a(Parcel paramParcel)
  {
    return new ARRecognition(paramParcel);
  }
  
  public ARRecognition[] a(int paramInt)
  {
    return new ARRecognition[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdb
 * JD-Core Version:    0.7.0.1
 */