package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

final class CalendarConstraints$1
  implements Parcelable.Creator<CalendarConstraints>
{
  @NonNull
  public CalendarConstraints a(@NonNull Parcel paramParcel)
  {
    Month localMonth1 = (Month)paramParcel.readParcelable(Month.class.getClassLoader());
    Month localMonth2 = (Month)paramParcel.readParcelable(Month.class.getClassLoader());
    Month localMonth3 = (Month)paramParcel.readParcelable(Month.class.getClassLoader());
    return new CalendarConstraints(localMonth1, localMonth2, (CalendarConstraints.DateValidator)paramParcel.readParcelable(CalendarConstraints.DateValidator.class.getClassLoader()), localMonth3, null);
  }
  
  @NonNull
  public CalendarConstraints[] a(int paramInt)
  {
    return new CalendarConstraints[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.CalendarConstraints.1
 * JD-Core Version:    0.7.0.1
 */