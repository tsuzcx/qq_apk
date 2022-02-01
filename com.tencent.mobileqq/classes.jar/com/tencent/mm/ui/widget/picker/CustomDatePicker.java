package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomDatePicker
  extends YADatePicker
{
  private boolean a = true;
  private boolean b = true;
  private NumberPicker c;
  private NumberPicker d;
  private NumberPicker e;
  private Date f;
  private Date g;
  private Calendar h;
  private String[] i;
  
  public CustomDatePicker(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public CustomDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.i = new String[12];
    int k;
    for (int j = 0;; j = k)
    {
      localObject1 = this.i;
      if (j >= localObject1.length) {
        break;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      k = j + 1;
      ((StringBuilder)localObject2).append(k);
      localObject1[j] = ((StringBuilder)localObject2).toString();
    }
    this.h = Calendar.getInstance(Locale.US);
    setCalendarViewShown(false);
    setSpinnersShown(true);
    this.c = ((YADatePicker.DatePickerSpinnerDelegate)getUIDelegate()).mYearSpinner;
    this.d = ((YADatePicker.DatePickerSpinnerDelegate)getUIDelegate()).mMonthSpinner;
    this.e = ((YADatePicker.DatePickerSpinnerDelegate)getUIDelegate()).mDaySpinner;
    c();
    NumberPickerUtil.reflectSetNumberPickerEditTextNotEditable(this.c);
    NumberPickerUtil.reflectSetNumberPickerEditTextNotEditable(this.d);
    NumberPickerUtil.reflectSetNumberPickerEditTextNotEditable(this.e);
    NumberPickerUtil.setNumberPickerTextColor(this.c, getResources().getColor(2131166595));
    NumberPickerUtil.setNumberPickerTextColor(this.d, getResources().getColor(2131166595));
    NumberPickerUtil.setNumberPickerTextColor(this.e, getResources().getColor(2131166595));
    Object localObject1 = new CustomDatePicker.1(this);
    Object localObject2 = this.c;
    if (localObject2 != null)
    {
      ((NumberPicker)localObject2).setOnValueChangedListener((NumberPicker.OnValueChangeListener)localObject1);
      this.c.setMinValue(1900);
    }
    localObject2 = this.d;
    if (localObject2 != null) {
      ((NumberPicker)localObject2).setOnValueChangedListener((NumberPicker.OnValueChangeListener)localObject1);
    }
    localObject2 = this.e;
    if (localObject2 != null) {
      ((NumberPicker)localObject2).setOnValueChangedListener((NumberPicker.OnValueChangeListener)localObject1);
    }
    d();
    NumberPickerUtil.removePendingSetSelectionCommand(this.c);
    NumberPickerUtil.removePendingSetSelectionCommand(this.d);
    NumberPickerUtil.removePendingSetSelectionCommand(this.e);
  }
  
  private void c()
  {
    Drawable localDrawable = getResources().getDrawable(2130842461);
    NumberPickerUtil.reflectSetDividerDrawable(this.c, localDrawable);
    NumberPickerUtil.reflectSetDividerDrawable(this.d, localDrawable);
    NumberPickerUtil.reflectSetDividerDrawable(this.e, localDrawable);
  }
  
  private void d()
  {
    if (this.c != null)
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        if (this.e == null) {
          return;
        }
        ((NumberPicker)localObject).setDisplayedValues(null);
        int j = this.c.getValue();
        int m = this.c.getMaxValue();
        int k = 0;
        if (j == m)
        {
          localObject = this.g;
          if (localObject != null)
          {
            this.d.setMaxValue(((Date)localObject).getMonth());
            if (this.d.getValue() != this.d.getMaxValue()) {
              break label132;
            }
            localObject = this.g;
            if (localObject == null) {
              break label132;
            }
            this.e.setMaxValue(((Date)localObject).getDate());
            j = 1;
            break label134;
          }
        }
        this.d.setMaxValue(11);
        label132:
        j = 0;
        label134:
        if (j == 0)
        {
          j = this.c.getValue();
          m = this.d.getValue();
          this.h.set(j, m, 1);
          j = this.h.getActualMaximum(5);
          this.e.setMaxValue(j);
        }
        if (this.c.getValue() == this.c.getMinValue())
        {
          localObject = this.f;
          if (localObject != null)
          {
            this.d.setMinValue(((Date)localObject).getMonth());
            j = k;
            if (this.d.getValue() != this.d.getMinValue()) {
              break label280;
            }
            localObject = this.f;
            j = k;
            if (localObject == null) {
              break label280;
            }
            this.e.setMinValue(((Date)localObject).getDate());
            j = 1;
            break label280;
          }
        }
        this.d.setMinValue(0);
        j = k;
        label280:
        if (j == 0) {
          this.e.setMinValue(1);
        }
        localObject = this.d;
        ((NumberPicker)localObject).setDisplayedValues((String[])Arrays.copyOfRange(this.i, ((NumberPicker)localObject).getMinValue(), this.d.getMaxValue() + 1));
        this.c.setWrapSelectorWheel(true);
        this.d.setWrapSelectorWheel(true);
        this.e.setWrapSelectorWheel(true);
      }
    }
  }
  
  public String currentValue()
  {
    if (this.b) {
      return String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(getYear()), Integer.valueOf(getMonth()), Integer.valueOf(getDayOfMonth()) });
    }
    if (this.a) {
      return String.format(Locale.US, "%04d-%02d", new Object[] { Integer.valueOf(getYear()), Integer.valueOf(getMonth()) });
    }
    return String.format(Locale.US, "%04d", new Object[] { Integer.valueOf(getYear()) });
  }
  
  public int getDayOfMonth()
  {
    NumberPicker localNumberPicker = this.e;
    if (localNumberPicker != null) {
      return localNumberPicker.getValue();
    }
    return super.getDayOfMonth();
  }
  
  public int getMonth()
  {
    NumberPicker localNumberPicker = this.d;
    int j;
    if (localNumberPicker != null) {
      j = localNumberPicker.getValue();
    } else {
      j = super.getMonth();
    }
    return Math.max(Math.min(j + 1, 12), 0);
  }
  
  public int getYear()
  {
    NumberPicker localNumberPicker = this.c;
    if (localNumberPicker != null) {
      return localNumberPicker.getValue();
    }
    return super.getYear();
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3)
  {
    init(paramInt1, paramInt2, paramInt3, null);
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3, YADatePicker.OnDateChangedListener paramOnDateChangedListener)
  {
    super.init(paramInt1, Math.max(paramInt2 - 1, 0), paramInt3, paramOnDateChangedListener);
    d();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    NumberPickerUtil.fixDefaultValueDisplaying(this.c);
    NumberPickerUtil.fixDefaultValueDisplaying(this.d);
    NumberPickerUtil.fixDefaultValueDisplaying(this.e);
  }
  
  public void onShow()
  {
    d();
  }
  
  public void setMaxDate(long paramLong)
  {
    super.setMaxDate(paramLong);
    this.g = new Date(paramLong);
    NumberPicker localNumberPicker = this.c;
    if (localNumberPicker != null) {
      localNumberPicker.setMaxValue(this.g.getYear() + 1900);
    }
    d();
  }
  
  public void setMinDate(long paramLong)
  {
    super.setMinDate(paramLong);
    this.f = new Date(paramLong);
    NumberPicker localNumberPicker = this.c;
    if (localNumberPicker != null) {
      localNumberPicker.setMinValue(this.f.getYear() + 1900);
    }
  }
  
  public void setPickersEnable(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a = paramBoolean2;
    this.b = paramBoolean3;
    NumberPicker localNumberPicker = this.c;
    int k = 0;
    int j;
    if (localNumberPicker != null)
    {
      localNumberPicker.setEnabled(paramBoolean1);
      localNumberPicker = this.c;
      if (paramBoolean1) {
        j = 0;
      } else {
        j = 8;
      }
      localNumberPicker.setVisibility(j);
    }
    localNumberPicker = this.d;
    if (localNumberPicker != null)
    {
      localNumberPicker.setEnabled(paramBoolean2);
      localNumberPicker = this.d;
      if (paramBoolean2) {
        j = 0;
      } else {
        j = 8;
      }
      localNumberPicker.setVisibility(j);
    }
    localNumberPicker = this.e;
    if (localNumberPicker != null)
    {
      localNumberPicker.setEnabled(paramBoolean3);
      localNumberPicker = this.e;
      if (paramBoolean3) {
        j = k;
      } else {
        j = 8;
      }
      localNumberPicker.setVisibility(j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePicker
 * JD-Core Version:    0.7.0.1
 */