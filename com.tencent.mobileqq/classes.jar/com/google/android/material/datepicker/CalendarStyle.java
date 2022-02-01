package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;

final class CalendarStyle
{
  @NonNull
  final Paint jdField_a_of_type_AndroidGraphicsPaint;
  @NonNull
  final CalendarItemStyle jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarItemStyle;
  @NonNull
  final CalendarItemStyle b;
  @NonNull
  final CalendarItemStyle c;
  @NonNull
  final CalendarItemStyle d;
  @NonNull
  final CalendarItemStyle e;
  @NonNull
  final CalendarItemStyle f;
  @NonNull
  final CalendarItemStyle g;
  
  CalendarStyle(@NonNull Context paramContext)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(MaterialAttributes.a(paramContext, R.attr.y, MaterialCalendar.class.getCanonicalName()), R.styleable.R);
    this.jdField_a_of_type_ComGoogleAndroidMaterialDatepickerCalendarItemStyle = CalendarItemStyle.a(paramContext, localTypedArray.getResourceId(R.styleable.cF, 0));
    this.g = CalendarItemStyle.a(paramContext, localTypedArray.getResourceId(R.styleable.cD, 0));
    this.b = CalendarItemStyle.a(paramContext, localTypedArray.getResourceId(R.styleable.cE, 0));
    this.c = CalendarItemStyle.a(paramContext, localTypedArray.getResourceId(R.styleable.cG, 0));
    ColorStateList localColorStateList = MaterialResources.a(paramContext, localTypedArray, R.styleable.cH);
    this.d = CalendarItemStyle.a(paramContext, localTypedArray.getResourceId(R.styleable.cJ, 0));
    this.e = CalendarItemStyle.a(paramContext, localTypedArray.getResourceId(R.styleable.cI, 0));
    this.f = CalendarItemStyle.a(paramContext, localTypedArray.getResourceId(R.styleable.cK, 0));
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(localColorStateList.getDefaultColor());
    localTypedArray.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.datepicker.CalendarStyle
 * JD-Core Version:    0.7.0.1
 */