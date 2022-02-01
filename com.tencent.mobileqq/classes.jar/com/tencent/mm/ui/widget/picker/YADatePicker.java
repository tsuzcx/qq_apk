package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View.BaseSavedState;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable;
import java.util.Calendar;

public class YADatePicker
  extends FrameLayout
{
  private static final String a = "YADatePicker";
  public final YADatePicker.DatePickerDelegate mDelegate;
  
  public YADatePicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public YADatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131034685);
  }
  
  public YADatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mDelegate = a(paramContext, paramAttributeSet, paramInt, 0);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DatePicker, paramInt, 0);
    paramInt = paramContext.getInt(R.styleable.DatePicker_firstDayOfWeek, 0);
    paramContext.recycle();
    if (paramInt != 0) {
      setFirstDayOfWeek(paramInt);
    }
  }
  
  private YADatePicker.DatePickerDelegate a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    return new YADatePicker.DatePickerSpinnerDelegate(this, paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return this.mDelegate.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  public CharSequence getAccessibilityClassName()
  {
    return YADatePicker.class.getName();
  }
  
  public CalendarView getCalendarView()
  {
    return this.mDelegate.getCalendarView();
  }
  
  public boolean getCalendarViewShown()
  {
    return this.mDelegate.getCalendarViewShown();
  }
  
  public int getDayOfMonth()
  {
    return this.mDelegate.getDayOfMonth();
  }
  
  public int getFirstDayOfWeek()
  {
    return this.mDelegate.getFirstDayOfWeek();
  }
  
  public long getMaxDate()
  {
    return this.mDelegate.getMaxDate().getTimeInMillis();
  }
  
  public long getMinDate()
  {
    return this.mDelegate.getMinDate().getTimeInMillis();
  }
  
  public int getMonth()
  {
    return this.mDelegate.getMonth();
  }
  
  public boolean getSpinnersShown()
  {
    return this.mDelegate.getSpinnersShown();
  }
  
  @Keep
  public YADatePicker.DatePickerDelegate getUIDelegate()
  {
    return this.mDelegate;
  }
  
  public int getYear()
  {
    return this.mDelegate.getYear();
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3, YADatePicker.OnDateChangedListener paramOnDateChangedListener)
  {
    this.mDelegate.init(paramInt1, paramInt2, paramInt3, paramOnDateChangedListener);
  }
  
  public boolean isEnabled()
  {
    return this.mDelegate.isEnabled();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mDelegate.onConfigurationChanged(paramConfiguration);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    this.mDelegate.onPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (View.BaseSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.mDelegate.onRestoreInstanceState(paramParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    return this.mDelegate.onSaveInstanceState(localParcelable);
  }
  
  public void setCalendarViewShown(boolean paramBoolean)
  {
    this.mDelegate.setCalendarViewShown(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.mDelegate.isEnabled() == paramBoolean) {
      return;
    }
    super.setEnabled(paramBoolean);
    this.mDelegate.setEnabled(paramBoolean);
  }
  
  public void setFirstDayOfWeek(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 7))
    {
      this.mDelegate.setFirstDayOfWeek(paramInt);
      return;
    }
    throw new IllegalArgumentException("firstDayOfWeek must be between 1 and 7");
  }
  
  public void setMaxDate(long paramLong)
  {
    this.mDelegate.setMaxDate(paramLong);
  }
  
  public void setMinDate(long paramLong)
  {
    this.mDelegate.setMinDate(paramLong);
  }
  
  public void setSpinnersShown(boolean paramBoolean)
  {
    this.mDelegate.setSpinnersShown(paramBoolean);
  }
  
  public void setValidationCallback(@Nullable YADatePicker.ValidationCallback paramValidationCallback)
  {
    this.mDelegate.setValidationCallback(paramValidationCallback);
  }
  
  public void updateDate(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mDelegate.updateDate(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.YADatePicker
 * JD-Core Version:    0.7.0.1
 */