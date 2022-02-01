package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;

class SmoothCalendarLayoutManager$1
  extends LinearSmoothScroller
{
  SmoothCalendarLayoutManager$1(SmoothCalendarLayoutManager paramSmoothCalendarLayoutManager, Context paramContext)
  {
    super(paramContext);
  }
  
  protected float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.datepicker.SmoothCalendarLayoutManager.1
 * JD-Core Version:    0.7.0.1
 */