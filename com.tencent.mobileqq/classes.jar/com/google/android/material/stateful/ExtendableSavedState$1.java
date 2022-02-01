package com.google.android.material.stateful;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class ExtendableSavedState$1
  implements Parcelable.ClassLoaderCreator<ExtendableSavedState>
{
  @Nullable
  public ExtendableSavedState a(@NonNull Parcel paramParcel)
  {
    return new ExtendableSavedState(paramParcel, null, null);
  }
  
  @NonNull
  public ExtendableSavedState a(@NonNull Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new ExtendableSavedState(paramParcel, paramClassLoader, null);
  }
  
  @NonNull
  public ExtendableSavedState[] a(int paramInt)
  {
    return new ExtendableSavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.stateful.ExtendableSavedState.1
 * JD-Core Version:    0.7.0.1
 */