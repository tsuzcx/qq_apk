package com.google.android.material.timepicker;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.IntRange;
import java.util.Arrays;

class TimeModel
  implements Parcelable
{
  public static final Parcelable.Creator<TimeModel> CREATOR = new TimeModel.1();
  final int jdField_a_of_type_Int;
  private final MaxInputValidator jdField_a_of_type_ComGoogleAndroidMaterialTimepickerMaxInputValidator;
  int jdField_b_of_type_Int;
  private final MaxInputValidator jdField_b_of_type_ComGoogleAndroidMaterialTimepickerMaxInputValidator;
  int c;
  int d;
  int e;
  
  public TimeModel()
  {
    this(0);
  }
  
  public TimeModel(int paramInt)
  {
    this(0, 0, 10, paramInt);
  }
  
  public TimeModel(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.jdField_a_of_type_Int = paramInt4;
    this.e = a(paramInt1);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerMaxInputValidator = new MaxInputValidator(59);
    if (paramInt4 == 1) {
      paramInt1 = 24;
    } else {
      paramInt1 = 12;
    }
    this.jdField_b_of_type_ComGoogleAndroidMaterialTimepickerMaxInputValidator = new MaxInputValidator(paramInt1);
  }
  
  protected TimeModel(Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt());
  }
  
  private static int a(int paramInt)
  {
    if (paramInt >= 12) {
      return 1;
    }
    return 0;
  }
  
  public static String a(Resources paramResources, CharSequence paramCharSequence)
  {
    return a(paramResources, paramCharSequence, "%02d");
  }
  
  public static String a(Resources paramResources, CharSequence paramCharSequence, String paramString)
  {
    return String.format(paramResources.getConfiguration().locale, paramString, new Object[] { Integer.valueOf(Integer.parseInt(String.valueOf(paramCharSequence))) });
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 1) {
      return this.jdField_b_of_type_Int % 24;
    }
    int j = this.jdField_b_of_type_Int;
    if (j % 12 == 0) {
      return 12;
    }
    int i = j;
    if (this.e == 1) {
      i = j - 12;
    }
    return i;
  }
  
  public MaxInputValidator a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerMaxInputValidator;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
    int i = 12;
    if (this.e != 1) {
      i = 0;
    }
    this.jdField_b_of_type_Int = (paramInt % 12 + i);
  }
  
  public MaxInputValidator b()
  {
    return this.jdField_b_of_type_ComGoogleAndroidMaterialTimepickerMaxInputValidator;
  }
  
  public void b(@IntRange(from=0L, to=60L) int paramInt)
  {
    this.c = (paramInt % 60);
  }
  
  public void c(int paramInt)
  {
    if (paramInt != this.e)
    {
      this.e = paramInt;
      int i = this.jdField_b_of_type_Int;
      if ((i < 12) && (paramInt == 1))
      {
        this.jdField_b_of_type_Int = (i + 12);
        return;
      }
      i = this.jdField_b_of_type_Int;
      if ((i >= 12) && (paramInt == 0)) {
        this.jdField_b_of_type_Int = (i - 12);
      }
    }
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
    if (!(paramObject instanceof TimeModel)) {
      return false;
    }
    paramObject = (TimeModel)paramObject;
    return (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (this.c == paramObject.c) && (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.d == paramObject.d);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c), Integer.valueOf(this.d) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.timepicker.TimeModel
 * JD-Core Version:    0.7.0.1
 */