package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import java.util.List;

public final class CompositeDateValidator
  implements CalendarConstraints.DateValidator
{
  public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new CompositeDateValidator.3();
  private static final CompositeDateValidator.Operator b = new CompositeDateValidator.1();
  private static final CompositeDateValidator.Operator c = new CompositeDateValidator.2();
  @NonNull
  private final CompositeDateValidator.Operator jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCompositeDateValidator$Operator;
  @NonNull
  private final List<CalendarConstraints.DateValidator> jdField_a_of_type_JavaUtilList;
  
  private CompositeDateValidator(@NonNull List<CalendarConstraints.DateValidator> paramList, CompositeDateValidator.Operator paramOperator)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCompositeDateValidator$Operator = paramOperator;
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCompositeDateValidator$Operator.a(this.jdField_a_of_type_JavaUtilList, paramLong);
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
    return (this.jdField_a_of_type_JavaUtilList.equals(paramObject.jdField_a_of_type_JavaUtilList)) && (this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCompositeDateValidator$Operator.a() == paramObject.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCompositeDateValidator$Operator.a());
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaUtilList.hashCode();
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilList);
    paramParcel.writeInt(this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCompositeDateValidator$Operator.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.CompositeDateValidator
 * JD-Core Version:    0.7.0.1
 */