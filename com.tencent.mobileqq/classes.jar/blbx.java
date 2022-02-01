import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.widget.ExpandableListView.SavedState;

public final class blbx
  implements Parcelable.Creator<ExpandableListView.SavedState>
{
  public ExpandableListView.SavedState a(Parcel paramParcel)
  {
    return new ExpandableListView.SavedState(paramParcel, null);
  }
  
  public ExpandableListView.SavedState[] a(int paramInt)
  {
    return new ExpandableListView.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbx
 * JD-Core Version:    0.7.0.1
 */