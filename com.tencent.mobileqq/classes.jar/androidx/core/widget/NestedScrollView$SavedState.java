package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import androidx.annotation.NonNull;

class NestedScrollView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new NestedScrollView.SavedState.1();
  public int scrollPosition;
  
  NestedScrollView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.scrollPosition = paramParcel.readInt();
  }
  
  NestedScrollView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HorizontalScrollView.SavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" scrollPosition=");
    localStringBuilder.append(this.scrollPosition);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.scrollPosition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.widget.NestedScrollView.SavedState
 * JD-Core Version:    0.7.0.1
 */