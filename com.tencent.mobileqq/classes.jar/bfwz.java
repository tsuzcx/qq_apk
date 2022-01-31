import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.music.BroadcastOneShow;

public final class bfwz
  implements Parcelable.Creator<BroadcastOneShow>
{
  public BroadcastOneShow a(Parcel paramParcel)
  {
    return new BroadcastOneShow(paramParcel);
  }
  
  public BroadcastOneShow[] a(int paramInt)
  {
    return new BroadcastOneShow[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfwz
 * JD-Core Version:    0.7.0.1
 */