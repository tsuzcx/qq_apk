import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.widget.TCWDatePicker.SavedState;

public final class bkpa
  implements Parcelable.Creator<TCWDatePicker.SavedState>
{
  public TCWDatePicker.SavedState a(Parcel paramParcel)
  {
    return new TCWDatePicker.SavedState(paramParcel, null);
  }
  
  public TCWDatePicker.SavedState[] a(int paramInt)
  {
    return new TCWDatePicker.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpa
 * JD-Core Version:    0.7.0.1
 */