import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public final class avde
  implements Parcelable.Creator<VideoData>
{
  public VideoData a(Parcel paramParcel)
  {
    return new VideoData(paramParcel);
  }
  
  public VideoData[] a(int paramInt)
  {
    return new VideoData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avde
 * JD-Core Version:    0.7.0.1
 */