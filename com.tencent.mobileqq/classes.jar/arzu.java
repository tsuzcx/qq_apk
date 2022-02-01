import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.doutu.DoutuData;

public final class arzu
  implements Parcelable.Creator<DoutuData>
{
  public DoutuData a(Parcel paramParcel)
  {
    return new DoutuData(paramParcel);
  }
  
  public DoutuData[] a(int paramInt)
  {
    return new DoutuData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzu
 * JD-Core Version:    0.7.0.1
 */