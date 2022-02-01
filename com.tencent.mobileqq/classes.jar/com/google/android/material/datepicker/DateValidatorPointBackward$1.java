package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

final class DateValidatorPointBackward$1
  implements Parcelable.Creator<DateValidatorPointBackward>
{
  @NonNull
  public DateValidatorPointBackward a(@NonNull Parcel paramParcel)
  {
    return new DateValidatorPointBackward(paramParcel.readLong(), null);
  }
  
  @NonNull
  public DateValidatorPointBackward[] a(int paramInt)
  {
    return new DateValidatorPointBackward[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.DateValidatorPointBackward.1
 * JD-Core Version:    0.7.0.1
 */