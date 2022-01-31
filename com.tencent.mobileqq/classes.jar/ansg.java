import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;

public final class ansg
  implements Parcelable.Creator
{
  public EditTakeVideoSource a(Parcel paramParcel)
  {
    return new EditTakeVideoSource(paramParcel);
  }
  
  public EditTakeVideoSource[] a(int paramInt)
  {
    return new EditTakeVideoSource[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ansg
 * JD-Core Version:    0.7.0.1
 */