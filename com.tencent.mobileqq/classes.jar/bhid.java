import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qqmini.sdk.ui.MoreItem;

public final class bhid
  implements Parcelable.Creator<MoreItem>
{
  public MoreItem a(Parcel paramParcel)
  {
    return new MoreItem(paramParcel);
  }
  
  public MoreItem[] a(int paramInt)
  {
    return new MoreItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhid
 * JD-Core Version:    0.7.0.1
 */