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
  private final int jdField_a_of_type_Int;
  @NonNull
  private final CalendarConstraints.DateValidator jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints$DateValidator;
  @NonNull
  private final Month jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth;
  private final int jdField_b_of_type_Int;
  @NonNull
  private final Month jdField_b_of_type_ComGoogleAndroidMaterialDatepickerMonth;
  @Nullable
  private Month c;
  
  private CalendarConstraints(@NonNull Month paramMonth1, @NonNull Month paramMonth2, @NonNull CalendarConstraints.DateValidator paramDateValidator, @Nullable Month paramMonth3)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth = paramMonth1;
    this.jdField_b_of_type_ComGoogleAndroidMaterialDatepickerMonth = paramMonth2;
    this.c = paramMonth3;
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints$DateValidator = paramDateValidator;
    if ((paramMonth3 != null) && (paramMonth1.a(paramMonth3) > 0)) {
      throw new IllegalArgumentException("start Month cannot be after current Month");
    }
    if ((paramMonth3 != null) && (paramMonth3.a(paramMonth2) > 0)) {
      throw new IllegalArgumentException("current Month cannot be after end Month");
    }
    this.jdField_b_of_type_Int = (paramMonth1.b(paramMonth2) + 1);
    this.jdField_a_of_type_Int = (paramMonth2.jdField_b_of_type_Int - paramMonth1.jdField_b_of_type_Int + 1);
  }
  
  int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public CalendarConstraints.DateValidator a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints$DateValidator;
  }
  
  @NonNull
  Month a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth;
  }
  
  Month a(Month paramMonth)
  {
    if (paramMonth.a(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth) < 0) {
      return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth;
    }
    Month localMonth = paramMonth;
    if (paramMonth.a(this.jdField_b_of_type_ComGoogleAndroidMaterialDatepickerMonth) > 0) {
      localMonth = this.jdField_b_of_type_ComGoogleAndroidMaterialDatepickerMonth;
    }
    return localMonth;
  }
  
  boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.a(1) <= paramLong)
    {
      Month localMonth = this.jdField_b_of_type_ComGoogleAndroidMaterialDatepickerMonth;
      if (paramLong <= localMonth.a(localMonth.d)) {
        return true;
      }
    }
    return false;
  }
  
  int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NonNull
  Month b()
  {
    return this.jdField_b_of_type_ComGoogleAndroidMaterialDatepickerMonth;
  }
  
  @Nullable
  Month c()
  {
    return this.c;
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
    if (!(paramObject instanceof CalendarConstraints)) {
      return false;
    }
    paramObject = (CalendarConstraints)paramObject;
    return (this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth.equals(paramObject.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth)) && (this.jdField_b_of_type_ComGoogleAndroidMaterialDatepickerMonth.equals(paramObject.jdField_b_of_type_ComGoogleAndroidMaterialDatepickerMonth)) && (ObjectsCompat.equals(this.c, paramObject.c)) && (this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints$DateValidator.equals(paramObject.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints$DateValidator));
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth, this.jdField_b_of_type_ComGoogleAndroidMaterialDatepickerMonth, this.c, this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints$DateValidator });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerMonth, 0);
    paramParcel.writeParcelable(this.jdField_b_of_type_ComGoogleAndroidMaterialDatepickerMonth, 0);
    paramParcel.writeParcelable(this.c, 0);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarConstraints$DateValidator, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.CalendarConstraints
 * JD-Core Version:    0.7.0.1
 */