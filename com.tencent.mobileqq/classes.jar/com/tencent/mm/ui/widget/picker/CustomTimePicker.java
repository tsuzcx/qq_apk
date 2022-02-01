package com.tencent.mm.ui.widget.picker;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import com.tencent.mm.ui.b;
import com.tencent.mm.ui.f;
import java.util.Locale;

public class CustomTimePicker
  extends TimePicker
{
  private NumberPicker a;
  private NumberPicker b;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  
  public CustomTimePicker(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131952936));
    a();
  }
  
  public CustomTimePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131952936), paramAttributeSet);
    a();
  }
  
  public CustomTimePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  @TargetApi(21)
  public CustomTimePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a();
  }
  
  private NumberPicker a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return c(paramString);
    }
    return b(paramString);
  }
  
  private void a()
  {
    setIs24HourView(Boolean.valueOf(true));
    this.a = a("mHourSpinner");
    this.b = a("mMinuteSpinner");
    NumberPickerUtil.reflectSetNumberPickerEditTextNotEditable(this.a);
    NumberPickerUtil.reflectSetNumberPickerEditTextNotEditable(this.b);
    c();
    NumberPicker localNumberPicker = this.a;
    if (localNumberPicker != null) {
      localNumberPicker.setOnValueChangedListener(new CustomTimePicker.1(this));
    }
    if ((this.b != null) && (Build.VERSION.SDK_INT >= 21)) {
      this.b.setOnValueChangedListener(new CustomTimePicker.2(this));
    }
    NumberPickerUtil.removePendingSetSelectionCommand(this.a);
    NumberPickerUtil.removePendingSetSelectionCommand(this.b);
  }
  
  private NumberPicker b(String paramString)
  {
    try
    {
      paramString = (NumberPicker)new b(this, paramString, null).a();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void b()
  {
    NumberPicker localNumberPicker;
    if ((PickerTimeUtil.checkHourIntValid(this.c)) && (PickerTimeUtil.checkMinuteIntValid(this.d)))
    {
      localNumberPicker = this.a;
      if ((localNumberPicker != null) && (this.b != null)) {
        if (localNumberPicker.getValue() == this.c) {
          this.b.setMinValue(this.d);
        } else {
          this.b.setMinValue(0);
        }
      }
    }
    if (PickerTimeUtil.checkHourIntValid(this.e))
    {
      localNumberPicker = this.a;
      if ((localNumberPicker != null) && (this.b != null))
      {
        if (localNumberPicker.getValue() == this.e)
        {
          this.b.setMaxValue(this.f);
          return;
        }
        this.b.setMaxValue(59);
      }
    }
  }
  
  private NumberPicker c(String paramString)
  {
    try
    {
      Object localObject = new b(this, "mDelegate", null).a();
      if (localObject != null)
      {
        paramString = (NumberPicker)new b(localObject, paramString, null).a();
        return paramString;
      }
    }
    catch (IllegalAccessException paramString)
    {
      f.a("CustomTimePicker", paramString, "super_getNumberPickerApi21 IllegalAccessException", new Object[0]);
      return null;
    }
    catch (NoSuchFieldException paramString)
    {
      f.a("CustomTimePicker", paramString, "super_getNumberPickerApi21 NoSuchFieldException", new Object[0]);
    }
    return null;
  }
  
  private void c()
  {
    Drawable localDrawable = getResources().getDrawable(2130842461);
    NumberPickerUtil.reflectSetDividerDrawable(this.a, localDrawable);
    NumberPickerUtil.reflectSetDividerDrawable(this.b, localDrawable);
  }
  
  public String currentValue()
  {
    return String.format(Locale.US, "%02d:%02d", new Object[] { getCurrentHour(), getCurrentMinute() });
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    NumberPickerUtil.fixDefaultValueDisplaying(this.a);
    NumberPickerUtil.fixDefaultValueDisplaying(this.b);
  }
  
  public void onShow()
  {
    b();
  }
  
  public void setCurrentTime(int paramInt1, int paramInt2)
  {
    if ((PickerTimeUtil.checkHourIntValid(paramInt1)) && (PickerTimeUtil.checkMinuteIntValid(paramInt2)))
    {
      setCurrentHour(Integer.valueOf(paramInt1));
      setCurrentMinute(Integer.valueOf(paramInt2));
    }
    b();
  }
  
  public void setMaxTime(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    if (PickerTimeUtil.checkHourIntValid(this.e))
    {
      NumberPicker localNumberPicker = this.a;
      if (localNumberPicker != null) {
        localNumberPicker.setMaxValue(this.e);
      }
    }
  }
  
  public void setMinTime(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    if (PickerTimeUtil.checkHourIntValid(this.c))
    {
      NumberPicker localNumberPicker = this.a;
      if (localNumberPicker != null) {
        localNumberPicker.setMinValue(this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomTimePicker
 * JD-Core Version:    0.7.0.1
 */