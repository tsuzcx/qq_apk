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
  final CalendarItemStyle a;
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
  @NonNull
  final Paint h;
  
  CalendarStyle(@NonNull Context paramContext)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(MaterialAttributes.a(paramContext, R.attr.F, MaterialCalendar.class.getCanonicalName()), R.styleable.eb);
    this.a = CalendarItemStyle.a(paramContext, localTypedArray.getResourceId(R.styleable.ee, 0));
    this.g = CalendarItemStyle.a(paramContext, localTypedArray.getResourceId(R.styleable.ec, 0));
    this.b = CalendarItemStyle.a(paramContext, localTypedArray.getResourceId(R.styleable.ed, 0));
    this.c = CalendarItemStyle.a(paramContext, localTypedArray.getResourceId(R.styleable.ef, 0));
    ColorStateList localColorStateList = MaterialResources.a(paramContext, localTypedArray, R.styleable.eg);
    this.d = CalendarItemStyle.a(paramContext, localTypedArray.getResourceId(R.styleable.ei, 0));
    this.e = CalendarItemStyle.a(paramContext, localTypedArray.getResourceId(R.styleable.eh, 0));
    this.f = CalendarItemStyle.a(paramContext, localTypedArray.getResourceId(R.styleable.ej, 0));
    this.h = new Paint();
    this.h.setColor(localColorStateList.getDefaultColor());
    localTypedArray.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.CalendarStyle
 * JD-Core Version:    0.7.0.1
 */