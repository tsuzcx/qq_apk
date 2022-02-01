package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

final class ParcelableSparseIntArray$1
  implements Parcelable.Creator<ParcelableSparseIntArray>
{
  @NonNull
  public ParcelableSparseIntArray a(@NonNull Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    ParcelableSparseIntArray localParcelableSparseIntArray = new ParcelableSparseIntArray(j);
    int[] arrayOfInt1 = new int[j];
    int[] arrayOfInt2 = new int[j];
    paramParcel.readIntArray(arrayOfInt1);
    paramParcel.readIntArray(arrayOfInt2);
    int i = 0;
    while (i < j)
    {
      localParcelableSparseIntArray.put(arrayOfInt1[i], arrayOfInt2[i]);
      i += 1;
    }
    return localParcelableSparseIntArray;
  }
  
  @NonNull
  public ParcelableSparseIntArray[] a(int paramInt)
  {
    return new ParcelableSparseIntArray[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.ParcelableSparseIntArray.1
 * JD-Core Version:    0.7.0.1
 */