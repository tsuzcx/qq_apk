import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.now.model.MedalItem;

public final class avda
  implements Parcelable.Creator<MedalItem>
{
  public MedalItem a(Parcel paramParcel)
  {
    return new MedalItem(paramParcel);
  }
  
  public MedalItem[] a(int paramInt)
  {
    return new MedalItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avda
 * JD-Core Version:    0.7.0.1
 */