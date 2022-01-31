import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.core.model.SongInfo;

public final class bgkf
  implements Parcelable.Creator<SongInfo>
{
  public SongInfo a(Parcel paramParcel)
  {
    return new SongInfo(paramParcel, null);
  }
  
  public SongInfo[] a(int paramInt)
  {
    return new SongInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgkf
 * JD-Core Version:    0.7.0.1
 */