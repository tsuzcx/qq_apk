package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

final class SingleDateSelector$2
  implements Parcelable.Creator<SingleDateSelector>
{
  @NonNull
  public SingleDateSelector a(@NonNull Parcel paramParcel)
  {
    SingleDateSelector localSingleDateSelector = new SingleDateSelector();
    SingleDateSelector.a(localSingleDateSelector, (Long)paramParcel.readValue(Long.class.getClassLoader()));
    return localSingleDateSelector;
  }
  
  @NonNull
  public SingleDateSelector[] a(int paramInt)
  {
    return new SingleDateSelector[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.SingleDateSelector.2
 * JD-Core Version:    0.7.0.1
 */