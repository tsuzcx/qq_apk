import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.data.IPSiteModel.GameRich;

public final class apee
  implements Parcelable.Creator
{
  public IPSiteModel.GameRich a(Parcel paramParcel)
  {
    IPSiteModel.GameRich localGameRich = new IPSiteModel.GameRich();
    localGameRich.anchorFaceUrl = paramParcel.readString();
    localGameRich.anchorId = paramParcel.readString();
    localGameRich.anchorName = paramParcel.readString();
    localGameRich.coverUrl = paramParcel.readString();
    localGameRich.online = paramParcel.readString();
    localGameRich.title = paramParcel.readString();
    localGameRich.richJumpUrl = paramParcel.readString();
    return localGameRich;
  }
  
  public IPSiteModel.GameRich[] a(int paramInt)
  {
    return new IPSiteModel.GameRich[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apee
 * JD-Core Version:    0.7.0.1
 */