import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeGifSource;

public final class aoav
  implements Parcelable.Creator
{
  public EditTakeGifSource a(Parcel paramParcel)
  {
    return new EditTakeGifSource(paramParcel);
  }
  
  public EditTakeGifSource[] a(int paramInt)
  {
    return new EditTakeGifSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoav
 * JD-Core Version:    0.7.0.1
 */