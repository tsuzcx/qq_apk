import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;

public final class auwt
  implements Parcelable.Creator<BasicTypeDataParcel>
{
  public BasicTypeDataParcel a(Parcel paramParcel)
  {
    return new BasicTypeDataParcel(paramParcel);
  }
  
  public BasicTypeDataParcel[] a(int paramInt)
  {
    return new BasicTypeDataParcel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auwt
 * JD-Core Version:    0.7.0.1
 */