package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

final class ParcelableSparseBooleanArray$1
  implements Parcelable.Creator<ParcelableSparseBooleanArray>
{
  @NonNull
  public ParcelableSparseBooleanArray a(@NonNull Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    ParcelableSparseBooleanArray localParcelableSparseBooleanArray = new ParcelableSparseBooleanArray(j);
    int[] arrayOfInt = new int[j];
    boolean[] arrayOfBoolean = new boolean[j];
    paramParcel.readIntArray(arrayOfInt);
    paramParcel.readBooleanArray(arrayOfBoolean);
    int i = 0;
    while (i < j)
    {
      localParcelableSparseBooleanArray.put(arrayOfInt[i], arrayOfBoolean[i]);
      i += 1;
    }
    return localParcelableSparseBooleanArray;
  }
  
  @NonNull
  public ParcelableSparseBooleanArray[] a(int paramInt)
  {
    return new ParcelableSparseBooleanArray[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.ParcelableSparseBooleanArray.1
 * JD-Core Version:    0.7.0.1
 */