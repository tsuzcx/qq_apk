import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.DynamicAvatar;

public final class apdx
  implements Parcelable.Creator<DynamicAvatar>
{
  public DynamicAvatar a(Parcel paramParcel)
  {
    return new DynamicAvatar(paramParcel);
  }
  
  public DynamicAvatar[] a(int paramInt)
  {
    return new DynamicAvatar[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdx
 * JD-Core Version:    0.7.0.1
 */