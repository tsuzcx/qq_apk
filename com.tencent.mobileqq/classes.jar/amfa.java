import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.music.BroadcastMusicInfo;

public final class amfa
  implements Parcelable.Creator
{
  public BroadcastMusicInfo a(Parcel paramParcel)
  {
    return new BroadcastMusicInfo(paramParcel);
  }
  
  public BroadcastMusicInfo[] a(int paramInt)
  {
    return new BroadcastMusicInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfa
 * JD-Core Version:    0.7.0.1
 */