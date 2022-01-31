import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.PublishEventTag;

public final class bjld
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjld
 * JD-Core Version:    0.7.0.1
 */