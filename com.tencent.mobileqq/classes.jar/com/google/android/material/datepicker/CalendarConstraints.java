package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;

public final class CalendarConstraints
  implements Parcelable
{
  public static final Parcelable.Creator<CalendarConstraints> CREATOR = new CalendarConstraints.1();
  @NonNull
  private final Month a;
  @NonNull
  private final Month b;
  @NonNull
  private final CalendarConstraints.DateValidator c;
  @Nullable
  private Month d;
  private final int e;
  private final int f;
  
  private CalendarConstraints(@NonNull Month paramMonth1, @NonNull Month paramMonth2, @NonNull CalendarConstraints.DateValidator paramDateValidator, @Nullable Month paramMonth3)
  {
    this.a = paramMonth1;
    this.b = paramMonth2;
    this.d = paramMonth3;
    this.c = paramDateValidator;
    if ((paramMonth3 != null) && (paramMonth1.a(paramMonth3) > 0)) {
      throw new IllegalArgumentException("start Month cannot be after current Month");
    }
    if ((paramMonth3 != null) && (paramMonth3.a(paramMonth2) > 0)) {
      throw new IllegalArgumentException("current Month cannot be after end Month");
    }
    this.f = (paramMonth1.b(paramMonth2) + 1);
    this.e = (paramMonth2.b - paramMonth1.b + 1);
  }
  
  public CalendarConstraints.DateValidator a()
  {
    return this.c;
  }
  
  Month a(Month paramMonth)
  {
    if (paramMonth.a(this.a) < 0) {
      return this.a;
    }
    Month localMonth = paramMonth;
    if (paramMonth.a(this.b) > 0) {
      localMonth = this.b;
    }
    return localMonth;
  }
  
  boolean a(long paramLong)
  {
    if (this.a.a(1) <= paramLong)
    {
      Month localMonth = this.b;
      if (paramLong <= localMonth.a(localMonth.d)) {
        return true;
      }
    }
    return false;
  }
  
  @NonNull
  Month b()
  {
    return this.a;
  }
  
  @NonNull
  Month c()
  {
    return this.b;
  }
  
  @Nullable
  Month d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int e()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof CalendarConstraints)) {
      return false;
    }
    paramObject = (CalendarConstraints)paramObject;
    return (this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)) && (ObjectsCompat.equals(this.d, paramObject.d)) && (this.c.equals(paramObject.c));
  }
  
  int f()
  {
    return this.e;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.a, this.b, this.d, this.c });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, 0);
    paramParcel.writeParcelable(this.b, 0);
    paramParcel.writeParcelable(this.d, 0);
    paramParcel.writeParcelable(this.c, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.CalendarConstraints
 * JD-Core Version:    0.7.0.1
 */