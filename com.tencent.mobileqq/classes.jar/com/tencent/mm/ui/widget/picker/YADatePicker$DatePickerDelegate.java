package com.tencent.mm.ui.widget.picker;

import android.content.res.Configuration;
import android.os.Parcelable;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CalendarView;
import java.util.Calendar;

public abstract interface YADatePicker$DatePickerDelegate
{
  public abstract boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent);
  
  public abstract CalendarView getCalendarView();
  
  public abstract boolean getCalendarViewShown();
  
  public abstract int getDayOfMonth();
  
  public abstract int getFirstDayOfWeek();
  
  public abstract Calendar getMaxDate();
  
  public abstract Calendar getMinDate();
  
  public abstract int getMonth();
  
  public abstract boolean getSpinnersShown();
  
  public abstract int getYear();
  
  public abstract void init(int paramInt1, int paramInt2, int paramInt3, YADatePicker.OnDateChangedListener paramOnDateChangedListener);
  
  public abstract boolean isEnabled();
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent);
  
  public abstract void onRestoreInstanceState(Parcelable paramParcelable);
  
  public abstract Parcelable onSaveInstanceState(Parcelable paramParcelable);
  
  public abstract void setCalendarViewShown(boolean paramBoolean);
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract void setFirstDayOfWeek(int paramInt);
  
  public abstract void setMaxDate(long paramLong);
  
  public abstract void setMinDate(long paramLong);
  
  public abstract void setSpinnersShown(boolean paramBoolean);
  
  public abstract void setValidationCallback(YADatePicker.ValidationCallback paramValidationCallback);
  
  public abstract void updateDate(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker.DatePickerDelegate
 * JD-Core Version:    0.7.0.1
 */