package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import java.util.Arrays;

public class DateValidatorPointBackward
  implements CalendarConstraints.DateValidator
{
  public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new DateValidatorPointBackward.1();
  private final long a;
  
  private DateValidatorPointBackward(long paramLong)
  {
    this.a = paramLong;
  }
  
  public boolean a(long paramLong)
  {
    return paramLong <= this.a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DateValidatorPointBackward)) {
      return false;
    }
    paramObject = (DateValidatorPointBackward)paramObject;
    return this.a == paramObject.a;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Long.valueOf(this.a) });
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.DateValidatorPointBackward
 * JD-Core Version:    0.7.0.1
 */