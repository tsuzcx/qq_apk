import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.listentogether.data.MusicInfo;

public final class arrr
  implements Parcelable.Creator<MusicInfo>
{
  public MusicInfo a(Parcel paramParcel)
  {
    return new MusicInfo(paramParcel, null);
  }
  
  public MusicInfo[] a(int paramInt)
  {
    return new MusicInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arrr
 * JD-Core Version:    0.7.0.1
 */