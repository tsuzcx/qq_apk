package androidx.viewpager2.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import androidx.annotation.RequiresApi;

class ViewPager2$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new ViewPager2.SavedState.1();
  Parcelable mAdapterState;
  int mCurrentItem;
  int mRecyclerViewId;
  
  ViewPager2$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    readValues(paramParcel, null);
  }
  
  @RequiresApi(24)
  ViewPager2$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    readValues(paramParcel, paramClassLoader);
  }
  
  ViewPager2$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  private void readValues(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    this.mRecyclerViewId = paramParcel.readInt();
    this.mCurrentItem = paramParcel.readInt();
    this.mAdapterState = paramParcel.readParcelable(paramClassLoader);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mRecyclerViewId);
    paramParcel.writeInt(this.mCurrentItem);
    paramParcel.writeParcelable(this.mAdapterState, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2.SavedState
 * JD-Core Version:    0.7.0.1
 */