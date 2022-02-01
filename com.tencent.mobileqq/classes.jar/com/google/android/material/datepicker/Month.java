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
  final int a;
  final int b;
  final int c;
  final int d;
  final long e;
  @NonNull
  private final Calendar f;
  @Nullable
  private String g;
  
  private Month(@NonNull Calendar paramCalendar)
  {
    paramCalendar.set(5, 1);
    this.f = UtcDates.b(paramCalendar);
    this.a = this.f.get(2);
    this.b = this.f.get(1);
    this.c = this.f.getMaximum(7);
    this.d = this.f.getActualMaximum(5);
    this.e = this.f.getTimeInMillis();
  }
  
  @NonNull
  static Month a()
  {
    return new Month(UtcDates.b());
  }
  
  @NonNull
  static Month a(int paramInt1, int paramInt2)
  {
    Calendar localCalendar = UtcDates.c();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2);
    return new Month(localCalendar);
  }
  
  @NonNull
  static Month a(long paramLong)
  {
    Calendar localCalendar = UtcDates.c();
    localCalendar.setTimeInMillis(paramLong);
    return new Month(localCalendar);
  }
  
  public int a(@NonNull Month paramMonth)
  {
    return this.f.compareTo(paramMonth.f);
  }
  
  long a(int paramInt)
  {
    Calendar localCalendar = UtcDates.b(this.f);
    localCalendar.set(5, paramInt);
    return localCalendar.getTimeInMillis();
  }
  
  @NonNull
  String a(Context paramContext)
  {
    if (this.g == null) {
      this.g = DateStrings.a(paramContext, this.f.getTimeInMillis());
    }
    return this.g;
  }
  
  int b()
  {
    int j = this.f.get(7) - this.f.getFirstDayOfWeek();
    int i = j;
    if (j < 0) {
      i = j + this.c;
    }
    return i;
  }
  
  int b(long paramLong)
  {
    Calendar localCalendar = UtcDates.b(this.f);
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(5);
  }
  
  int b(@NonNull Month paramMonth)
  {
    if ((this.f instanceof GregorianCalendar)) {
      return (paramMonth.b - this.b) * 12 + (paramMonth.a - this.a);
    }
    throw new IllegalArgumentException("Only Gregorian calendars are supported.");
  }
  
  @NonNull
  Month b(int paramInt)
  {
    Calendar localCalendar = UtcDates.b(this.f);
    localCalendar.add(2, paramInt);
    return new Month(localCalendar);
  }
  
  long c()
  {
    return this.f.getTimeInMillis();
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
    return (this.a == paramObject.a) && (this.b == paramObject.b);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) });
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.Month
 * JD-Core Version:    0.7.0.1
 */