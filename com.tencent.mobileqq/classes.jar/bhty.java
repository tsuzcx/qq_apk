import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.widget.AbsListView.SavedState;

public final class bhty
  implements Parcelable.Creator<AbsListView.SavedState>
{
  public AbsListView.SavedState a(Parcel paramParcel)
  {
    return new AbsListView.SavedState(paramParcel, null);
  }
  
  public AbsListView.SavedState[] a(int paramInt)
  {
    return new AbsListView.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhty
 * JD-Core Version:    0.7.0.1
 */