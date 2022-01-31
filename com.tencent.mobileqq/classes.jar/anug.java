import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public final class anug
  implements Parcelable.Creator
{
  public EditVideoParams a(Parcel paramParcel)
  {
    return new EditVideoParams(paramParcel);
  }
  
  public EditVideoParams[] a(int paramInt)
  {
    return new EditVideoParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anug
 * JD-Core Version:    0.7.0.1
 */