import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.IPSiteModel.Video;

public final class arua
  implements Parcelable.Creator
{
  public IPSiteModel.Video a(Parcel paramParcel)
  {
    IPSiteModel.Video localVideo = new IPSiteModel.Video();
    localVideo.id = paramParcel.readString();
    localVideo.buttonDesc = paramParcel.readString();
    localVideo.content = paramParcel.readString();
    localVideo.cover = paramParcel.readString();
    localVideo.desc = paramParcel.readString();
    localVideo.name = paramParcel.readString();
    localVideo.endTime = paramParcel.readString();
    localVideo.isShow = paramParcel.readInt();
    localVideo.newStartTime = paramParcel.readLong();
    localVideo.newEndTime = paramParcel.readLong();
    localVideo.redirectUrl = paramParcel.readString();
    localVideo.videoSource = paramParcel.readString();
    localVideo.showDate = paramParcel.readString();
    return localVideo;
  }
  
  public IPSiteModel.Video[] a(int paramInt)
  {
    return new IPSiteModel.Video[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arua
 * JD-Core Version:    0.7.0.1
 */