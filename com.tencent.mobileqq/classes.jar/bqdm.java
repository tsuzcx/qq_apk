import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;

public final class bqdm
  implements Parcelable.Creator<EditTakePhotoSource>
{
  public EditTakePhotoSource a(Parcel paramParcel)
  {
    return new EditTakePhotoSource(paramParcel);
  }
  
  public EditTakePhotoSource[] a(int paramInt)
  {
    return new EditTakePhotoSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqdm
 * JD-Core Version:    0.7.0.1
 */