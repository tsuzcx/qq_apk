import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.widget.AbsSpinner.SavedState;

public final class bhud
  implements Parcelable.Creator<AbsSpinner.SavedState>
{
  public AbsSpinner.SavedState a(Parcel paramParcel)
  {
    return new AbsSpinner.SavedState(paramParcel, null);
  }
  
  public AbsSpinner.SavedState[] a(int paramInt)
  {
    return new AbsSpinner.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhud
 * JD-Core Version:    0.7.0.1
 */