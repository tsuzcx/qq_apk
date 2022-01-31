import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;

public final class aqqo
  implements Parcelable.Creator<WatchTogetherSession>
{
  public WatchTogetherSession a(Parcel paramParcel)
  {
    return new WatchTogetherSession(paramParcel);
  }
  
  public WatchTogetherSession[] a(int paramInt)
  {
    return new WatchTogetherSession[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqqo
 * JD-Core Version:    0.7.0.1
 */