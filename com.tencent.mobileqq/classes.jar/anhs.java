import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;

public final class anhs
  implements Parcelable.Creator<IPCSpriteContext>
{
  public IPCSpriteContext a(Parcel paramParcel)
  {
    return new IPCSpriteContext(paramParcel);
  }
  
  public IPCSpriteContext[] a(int paramInt)
  {
    return new IPCSpriteContext[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhs
 * JD-Core Version:    0.7.0.1
 */