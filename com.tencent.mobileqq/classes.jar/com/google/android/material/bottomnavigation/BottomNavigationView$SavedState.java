package com.google.android.material.bottomnavigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;

class BottomNavigationView$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new BottomNavigationView.SavedState.1();
  @Nullable
  Bundle a;
  
  public BottomNavigationView$SavedState(@NonNull Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    ClassLoader localClassLoader = paramClassLoader;
    if (paramClassLoader == null) {
      localClassLoader = getClass().getClassLoader();
    }
    a(paramParcel, localClassLoader);
  }
  
  public BottomNavigationView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  private void a(@NonNull Parcel paramParcel, ClassLoader paramClassLoader)
  {
    this.a = paramParcel.readBundle(paramClassLoader);
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeBundle(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationView.SavedState
 * JD-Core Version:    0.7.0.1
 */