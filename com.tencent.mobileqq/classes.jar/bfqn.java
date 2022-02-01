import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.util.HeadRequest;

public final class bfqn
  implements Parcelable.Creator<HeadRequest>
{
  public HeadRequest a(Parcel paramParcel)
  {
    HeadRequest localHeadRequest = new HeadRequest();
    localHeadRequest.a(paramParcel);
    return localHeadRequest;
  }
  
  public HeadRequest[] a(int paramInt)
  {
    return new HeadRequest[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfqn
 * JD-Core Version:    0.7.0.1
 */