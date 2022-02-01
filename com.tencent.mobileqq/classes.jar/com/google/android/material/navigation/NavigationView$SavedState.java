package com.google.android.material.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;

public class NavigationView$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new NavigationView.SavedState.1();
  @Nullable
  public Bundle a;
  
  public NavigationView$SavedState(@NonNull Parcel paramParcel, @Nullable ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    this.a = paramParcel.readBundle(paramClassLoader);
  }
  
  public NavigationView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeBundle(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.navigation.NavigationView.SavedState
 * JD-Core Version:    0.7.0.1
 */