package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

final class CompositeDateValidator$3
  implements Parcelable.Creator<CompositeDateValidator>
{
  @NonNull
  public CompositeDateValidator a(@NonNull Parcel paramParcel)
  {
    ArrayList localArrayList = paramParcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
    int i = paramParcel.readInt();
    if (i == 2) {
      paramParcel = CompositeDateValidator.a();
    } else if (i == 1) {
      paramParcel = CompositeDateValidator.b();
    } else {
      paramParcel = CompositeDateValidator.a();
    }
    return new CompositeDateValidator((List)Preconditions.checkNotNull(localArrayList), paramParcel, null);
  }
  
  @NonNull
  public CompositeDateValidator[] a(int paramInt)
  {
    return new CompositeDateValidator[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.CompositeDateValidator.3
 * JD-Core Version:    0.7.0.1
 */