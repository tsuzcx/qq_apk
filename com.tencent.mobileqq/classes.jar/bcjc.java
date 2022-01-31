import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.model.CreateVirtualResult;

public final class bcjc
  implements Parcelable.Creator<CreateVirtualResult>
{
  public CreateVirtualResult a(Parcel paramParcel)
  {
    return new CreateVirtualResult(paramParcel);
  }
  
  public CreateVirtualResult[] a(int paramInt)
  {
    return new CreateVirtualResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcjc
 * JD-Core Version:    0.7.0.1
 */