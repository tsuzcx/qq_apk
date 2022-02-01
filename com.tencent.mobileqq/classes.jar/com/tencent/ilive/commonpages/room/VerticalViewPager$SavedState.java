package com.tencent.ilive.commonpages.room;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import androidx.core.os.ParcelableCompat;

public class VerticalViewPager$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new VerticalViewPager.SavedState.1());
  Parcelable adapterState;
  ClassLoader loader;
  int position;
  
  VerticalViewPager$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel);
    ClassLoader localClassLoader = paramClassLoader;
    if (paramClassLoader == null) {
      localClassLoader = getClass().getClassLoader();
    }
    this.position = paramParcel.readInt();
    this.adapterState = paramParcel.readParcelable(localClassLoader);
    this.loader = localClassLoader;
  }
  
  public VerticalViewPager$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.position);
    paramParcel.writeParcelable(this.adapterState, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.commonpages.room.VerticalViewPager.SavedState
 * JD-Core Version:    0.7.0.1
 */