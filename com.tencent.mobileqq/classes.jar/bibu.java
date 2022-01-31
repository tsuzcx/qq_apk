import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;

public final class bibu
  implements Parcelable.Creator<EditLocalVideoSource>
{
  public EditLocalVideoSource a(Parcel paramParcel)
  {
    return new EditLocalVideoSource(paramParcel);
  }
  
  public EditLocalVideoSource[] a(int paramInt)
  {
    return new EditLocalVideoSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bibu
 * JD-Core Version:    0.7.0.1
 */