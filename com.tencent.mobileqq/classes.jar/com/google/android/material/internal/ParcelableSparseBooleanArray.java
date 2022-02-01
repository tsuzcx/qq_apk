package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableSparseBooleanArray
  extends SparseBooleanArray
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = new ParcelableSparseBooleanArray.1();
  
  public ParcelableSparseBooleanArray() {}
  
  public ParcelableSparseBooleanArray(int paramInt)
  {
    super(paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    int[] arrayOfInt = new int[size()];
    boolean[] arrayOfBoolean = new boolean[size()];
    paramInt = 0;
    while (paramInt < size())
    {
      arrayOfInt[paramInt] = keyAt(paramInt);
      arrayOfBoolean[paramInt] = valueAt(paramInt);
      paramInt += 1;
    }
    paramParcel.writeInt(size());
    paramParcel.writeIntArray(arrayOfInt);
    paramParcel.writeBooleanArray(arrayOfBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.ParcelableSparseBooleanArray
 * JD-Core Version:    0.7.0.1
 */