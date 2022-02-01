package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

final class Month$1
  implements Parcelable.Creator<Month>
{
  @NonNull
  public Month a(@NonNull Parcel paramParcel)
  {
    return Month.a(paramParcel.readInt(), paramParcel.readInt());
  }
  
  @NonNull
  public Month[] a(int paramInt)
  {
    return new Month[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.Month.1
 * JD-Core Version:    0.7.0.1
 */