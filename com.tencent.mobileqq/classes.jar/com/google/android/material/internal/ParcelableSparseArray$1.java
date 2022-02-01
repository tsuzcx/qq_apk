package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

final class ParcelableSparseArray$1
  implements Parcelable.ClassLoaderCreator<ParcelableSparseArray>
{
  @Nullable
  public ParcelableSparseArray a(@NonNull Parcel paramParcel)
  {
    return new ParcelableSparseArray(paramParcel, null);
  }
  
  @NonNull
  public ParcelableSparseArray a(@NonNull Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new ParcelableSparseArray(paramParcel, paramClassLoader);
  }
  
  @NonNull
  public ParcelableSparseArray[] a(int paramInt)
  {
    return new ParcelableSparseArray[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.ParcelableSparseArray.1
 * JD-Core Version:    0.7.0.1
 */