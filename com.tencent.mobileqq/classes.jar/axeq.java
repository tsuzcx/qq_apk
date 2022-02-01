import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.miniapp.MiniAppOptions;

public final class axeq
  implements Parcelable.Creator<MiniAppOptions>
{
  public MiniAppOptions a(Parcel paramParcel)
  {
    return new MiniAppOptions(paramParcel);
  }
  
  public MiniAppOptions[] a(int paramInt)
  {
    return new MiniAppOptions[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axeq
 * JD-Core Version:    0.7.0.1
 */