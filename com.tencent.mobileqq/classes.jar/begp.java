import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.widget.AbsSpinner.SavedState;

public final class begp
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     begp
 * JD-Core Version:    0.7.0.1
 */