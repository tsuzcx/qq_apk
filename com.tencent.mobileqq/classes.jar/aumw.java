import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.music.SongInfo;

public final class aumw
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aumw
 * JD-Core Version:    0.7.0.1
 */