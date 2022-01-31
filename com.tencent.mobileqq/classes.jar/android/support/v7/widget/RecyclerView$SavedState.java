package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class RecyclerView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new RecyclerView.SavedState.1();
  Parcelable mLayoutState;
  
  RecyclerView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mLayoutState = paramParcel.readParcelable(RecyclerView.LayoutManager.class.getClassLoader());
  }
  
  RecyclerView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  private void copyFrom(SavedState paramSavedState)
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
 * Qualified Name:     android.support.v7.widget.RecyclerView.SavedState
 * JD-Core Version:    0.7.0.1
 */