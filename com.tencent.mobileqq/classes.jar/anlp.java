import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.qq.im.capture.data.FilterCategory;

public final class anlp
  implements Parcelable.Creator
{
  public FilterCategory a(Parcel paramParcel)
  {
    return new FilterCategory(paramParcel);
  }
  
  public FilterCategory[] a(int paramInt)
  {
    return new FilterCategory[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anlp
 * JD-Core Version:    0.7.0.1
 */