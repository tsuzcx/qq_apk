package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month
  implements Parcelable, Comparable<Month>
{
  public static final Parcelable.Creator<Month> CREATOR = new Month.1();
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  @NonNull
  private final Calendar jdField_a_of_type_JavaUtilCalendar;
  final int b;
  final int c;
  final int d;
  
  private Month(@NonNull Calendar paramCalendar)
  {
    paramCalendar.set(5, 1);
    this.jdField_a_of_type_JavaUtilCalendar = UtcDates.b(paramCalendar);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilCalendar.get(2);
    this.b = this.jdField_a_of_type_JavaUtilCalendar.get(1);
    this.c = this.jdField_a_of_type_JavaUtilCalendar.getMaximum(7);
    this.d = this.jdField_a_of_type_JavaUtilCalendar.getActualMaximum(5);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaUtilCalendar.getTimeInMillis();
  }
  
  @NonNull
  static Month a()
  {
    return new Month(UtcDates.a());
  }
  
  @NonNull
  static Month a(int paramInt1, int paramInt2)
  {
    Calendar localCalendar = UtcDates.b();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2);
    return new Month(localCalendar);
  }
  
  @NonNull
  static Month a(long paramLong)
  {
    Calendar localCalendar = UtcDates.b();
    localCalendar.setTimeInMillis(paramLong);
    return new Month(localCalendar);
  }
  
  int a()
  {
    int j = this.jdField_a_of_type_JavaUtilCalendar.get(7) - this.jdField_a_of_type_JavaUtilCalendar.getFirstDayOfWeek();
    int i = j;
    if (j < 0) {
      i = j + this.c;
    }
    return i;
  }
  
  int a(long paramLong)
  {
    Calendar localCalendar = UtcDates.b(this.jdField_a_of_type_JavaUtilCalendar);
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(5);
  }
  
  public int a(@NonNull Month paramMonth)
  {
    return this.jdField_a_of_type_JavaUtilCalendar.compareTo(paramMonth.jdField_a_of_type_JavaUtilCalendar);
  }
  
  long a()
  {
    return this.jdField_a_of_type_JavaUtilCalendar.getTimeInMillis();
  }
  
  long a(int paramInt)
  {
    Calendar localCalendar = UtcDates.b(this.jdField_a_of_type_JavaUtilCalendar);
    localCalendar.set(5, paramInt);
    return localCalendar.getTimeInMillis();
  }
  
  @NonNull
  Month a(int paramInt)
  {
    Calendar localCalendar = UtcDates.b(this.jdField_a_of_type_JavaUtilCalendar);
    localCalendar.add(2, paramInt);
    return new Month(localCalendar);
  }
  
  @NonNull
  String a(Context paramContext)
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = DateStrings.a(paramContext, this.jdField_a_of_type_JavaUtilCalendar.getTimeInMillis());
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  int b(@NonNull Month paramMonth)
  {
    if ((this.jdField_a_of_type_JavaUtilCalendar instanceof GregorianCalendar)) {
      return (paramMonth.b - this.b) * 12 + (paramMonth.jdField_a_of_type_Int - this.jdField_a_of_type_Int);
    }
    throw new IllegalArgumentException("Only Gregorian calendars are supported.");
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
    if (!(paramObject instanceof Month)) {
      return false;
    }
    paramObject = (Month)paramObject;
    return (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.b == paramObject.b);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b) });
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.Month
 * JD-Core Version:    0.7.0.1
 */