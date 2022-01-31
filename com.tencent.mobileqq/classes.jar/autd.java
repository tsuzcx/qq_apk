import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;

public final class autd
  implements Parcelable.Creator<FilterCategoryItem>
{
  public FilterCategoryItem a(Parcel paramParcel)
  {
    return new FilterCategoryItem(paramParcel);
  }
  
  public FilterCategoryItem[] a(int paramInt)
  {
    return new FilterCategoryItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     autd
 * JD-Core Version:    0.7.0.1
 */