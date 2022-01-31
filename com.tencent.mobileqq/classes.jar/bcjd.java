import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.open.model.GetVirtualListResult;

public final class bcjd
  implements Parcelable.Creator<GetVirtualListResult>
{
  public GetVirtualListResult a(Parcel paramParcel)
  {
    return new GetVirtualListResult(paramParcel);
  }
  
  public GetVirtualListResult[] a(int paramInt)
  {
    return new GetVirtualListResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcjd
 * JD-Core Version:    0.7.0.1
 */