package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableSparseIntArray
  extends SparseIntArray
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new ParcelableSparseIntArray.1();
  
  public ParcelableSparseIntArray() {}
  
  public ParcelableSparseIntArray(int paramInt)
  {
    super(paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    int[] arrayOfInt1 = new int[size()];
    int[] arrayOfInt2 = new int[size()];
    paramInt = 0;
    while (paramInt < size())
    {
      arrayOfInt1[paramInt] = keyAt(paramInt);
      arrayOfInt2[paramInt] = valueAt(paramInt);
      paramInt += 1;
    }
    paramParcel.writeInt(size());
    paramParcel.writeIntArray(arrayOfInt1);
    paramParcel.writeIntArray(arrayOfInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.ParcelableSparseIntArray
 * JD-Core Version:    0.7.0.1
 */