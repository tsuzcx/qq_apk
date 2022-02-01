import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;

public final class bqca
  implements Parcelable.Creator<EditLocalPhotoSource>
{
  public EditLocalPhotoSource a(Parcel paramParcel)
  {
    return new EditLocalPhotoSource(paramParcel);
  }
  
  public EditLocalPhotoSource[] a(int paramInt)
  {
    return new EditLocalPhotoSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqca
 * JD-Core Version:    0.7.0.1
 */