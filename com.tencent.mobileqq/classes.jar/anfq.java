import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArModelResource;

public final class anfq
  implements Parcelable.Creator<ArModelResource>
{
  public ArModelResource a(Parcel paramParcel)
  {
    return new ArModelResource(paramParcel);
  }
  
  public ArModelResource[] a(int paramInt)
  {
    return new ArModelResource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfq
 * JD-Core Version:    0.7.0.1
 */