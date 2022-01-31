import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.miniapp.MiniAppOptions;

public final class auaf
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auaf
 * JD-Core Version:    0.7.0.1
 */