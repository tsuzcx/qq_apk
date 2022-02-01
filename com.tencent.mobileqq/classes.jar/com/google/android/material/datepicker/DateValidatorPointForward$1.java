package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

final class DateValidatorPointForward$1
  implements Parcelable.Creator<DateValidatorPointForward>
{
  @NonNull
  public DateValidatorPointForward a(@NonNull Parcel paramParcel)
  {
    return new DateValidatorPointForward(paramParcel.readLong(), null);
  }
  
  @NonNull
  public DateValidatorPointForward[] a(int paramInt)
  {
    return new DateValidatorPointForward[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.DateValidatorPointForward.1
 * JD-Core Version:    0.7.0.1
 */