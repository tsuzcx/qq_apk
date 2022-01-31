import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.PublishEventTag;

public final class bfwk
  implements Parcelable.Creator<PublishEventTag>
{
  public PublishEventTag a(Parcel paramParcel)
  {
    return new PublishEventTag(paramParcel);
  }
  
  public PublishEventTag[] a(int paramInt)
  {
    return new PublishEventTag[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfwk
 * JD-Core Version:    0.7.0.1
 */