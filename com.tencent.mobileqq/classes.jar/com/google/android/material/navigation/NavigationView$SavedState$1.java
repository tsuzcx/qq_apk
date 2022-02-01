package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class NavigationView$SavedState$1
  implements Parcelable.ClassLoaderCreator<NavigationView.SavedState>
{
  @Nullable
  public NavigationView.SavedState a(@NonNull Parcel paramParcel)
  {
    return new NavigationView.SavedState(paramParcel, null);
  }
  
  @NonNull
  public NavigationView.SavedState a(@NonNull Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new NavigationView.SavedState(paramParcel, paramClassLoader);
  }
  
  @NonNull
  public NavigationView.SavedState[] a(int paramInt)
  {
    return new NavigationView.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.navigation.NavigationView.SavedState.1
 * JD-Core Version:    0.7.0.1
 */