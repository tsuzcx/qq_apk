package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import java.util.List;

public final class CompositeDateValidator
  implements CalendarConstraints.DateValidator
{
  public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new CompositeDateValidator.3();
  private static final CompositeDateValidator.Operator c = new CompositeDateValidator.1();
  private static final CompositeDateValidator.Operator d = new CompositeDateValidator.2();
  @NonNull
  private final CompositeDateValidator.Operator a;
  @NonNull
  private final List<CalendarConstraints.DateValidator> b;
  
  private CompositeDateValidator(@NonNull List<CalendarConstraints.DateValidator> paramList, CompositeDateValidator.Operator paramOperator)
  {
    this.b = paramList;
    this.a = paramOperator;
  }
  
  public boolean a(long paramLong)
  {
    return this.a.a(this.b, paramLong);
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
    if (!(paramObject instanceof CompositeDateValidator)) {
      return false;
    }
    paramObject = (CompositeDateValidator)paramObject;
    return (this.b.equals(paramObject.b)) && (this.a.a() == paramObject.a.a());
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.b);
    paramParcel.writeInt(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.CompositeDateValidator
 * JD-Core Version:    0.7.0.1
 */