import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public final class bquu
  implements Parcelable.Creator<PublishParam>
{
  public PublishParam a(Parcel paramParcel)
  {
    return new PublishParam(paramParcel);
  }
  
  public PublishParam[] a(int paramInt)
  {
    return new PublishParam[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bquu
 * JD-Core Version:    0.7.0.1
 */