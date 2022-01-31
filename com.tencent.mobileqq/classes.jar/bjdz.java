import android.os.Parcel;
import android.os.Parcelable.Creator;
import dov.com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;

public final class bjdz
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
 * Qualified Name:     bjdz
 * JD-Core Version:    0.7.0.1
 */