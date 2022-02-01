package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.internal.ParcelableSparseArray;

class BottomNavigationPresenter$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new BottomNavigationPresenter.SavedState.1();
  int a;
  @Nullable
  ParcelableSparseArray b;
  
  BottomNavigationPresenter$SavedState() {}
  
  BottomNavigationPresenter$SavedState(@NonNull Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = ((ParcelableSparseArray)paramParcel.readParcelable(getClass().getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeParcelable(this.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState
 * JD-Core Version:    0.7.0.1
 */