import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.util.BinderWarpper;

public final class blgr
  implements Parcelable.Creator<BinderWarpper>
{
  public BinderWarpper a(Parcel paramParcel)
  {
    return new BinderWarpper(paramParcel.readStrongBinder());
  }
  
  public BinderWarpper[] a(int paramInt)
  {
    return new BinderWarpper[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgr
 * JD-Core Version:    0.7.0.1
 */