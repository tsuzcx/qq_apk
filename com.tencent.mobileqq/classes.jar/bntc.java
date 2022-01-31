import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.ShortVideoTravellerManager.TravellerVideoItem;

public final class bntc
  implements Parcelable.Creator<ShortVideoTravellerManager.TravellerVideoItem>
{
  public ShortVideoTravellerManager.TravellerVideoItem a(Parcel paramParcel)
  {
    return new ShortVideoTravellerManager.TravellerVideoItem(paramParcel);
  }
  
  public ShortVideoTravellerManager.TravellerVideoItem[] a(int paramInt)
  {
    return new ShortVideoTravellerManager.TravellerVideoItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntc
 * JD-Core Version:    0.7.0.1
 */