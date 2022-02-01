package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

final class RangeDateSelector$3
  implements Parcelable.Creator<RangeDateSelector>
{
  @NonNull
  public RangeDateSelector a(@NonNull Parcel paramParcel)
  {
    RangeDateSelector localRangeDateSelector = new RangeDateSelector();
    RangeDateSelector.c(localRangeDateSelector, (Long)paramParcel.readValue(Long.class.getClassLoader()));
    RangeDateSelector.d(localRangeDateSelector, (Long)paramParcel.readValue(Long.class.getClassLoader()));
    return localRangeDateSelector;
  }
  
  @NonNull
  public RangeDateSelector[] a(int paramInt)
  {
    return new RangeDateSelector[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.RangeDateSelector.3
 * JD-Core Version:    0.7.0.1
 */