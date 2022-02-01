import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.troop.homework.arithmetic.data.HWGuideItem;

public final class behz
  implements Parcelable.Creator<HWGuideItem>
{
  public HWGuideItem a(Parcel paramParcel)
  {
    return new HWGuideItem(paramParcel);
  }
  
  public HWGuideItem[] a(int paramInt)
  {
    return new HWGuideItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behz
 * JD-Core Version:    0.7.0.1
 */