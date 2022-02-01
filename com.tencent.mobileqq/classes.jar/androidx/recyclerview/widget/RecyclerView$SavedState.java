package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.RestrictTo;
import androidx.customview.view.AbsSavedState;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class RecyclerView$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new RecyclerView.SavedState.1();
  Parcelable mLayoutState;
  
  RecyclerView$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    if (paramClassLoader == null) {
      paramClassLoader = RecyclerView.LayoutManager.class.getClassLoader();
    }
    this.mLayoutState = paramParcel.readParcelable(paramClassLoader);
  }
  
  RecyclerView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  void copyFrom(SavedState paramSavedState)
  {
    this.mLayoutState = paramSavedState.mLayoutState;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mLayoutState, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.SavedState
 * JD-Core Version:    0.7.0.1
 */