package com.tencent.mm.ui.widget.picker;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import androidx.annotation.Nullable;
import com.tencent.mm.ui.b;
import com.tencent.mm.ui.f;

public class NumberPickerUtil
{
  public static void fixDefaultValueDisplaying(NumberPicker paramNumberPicker)
  {
    if (paramNumberPicker == null) {
      return;
    }
    try
    {
      paramNumberPicker = (EditText)new b(paramNumberPicker, "mInputText", null).a();
      if (paramNumberPicker != null)
      {
        paramNumberPicker.setFilters(new InputFilter[0]);
        return;
      }
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      f.a("NumberPickerUtil", paramNumberPicker, "fixDefaultValueDisplaying NoSuchFieldException", new Object[0]);
      return;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      f.a("NumberPickerUtil", paramNumberPicker, "fixDefaultValueDisplaying IllegalAccessException", new Object[0]);
    }
  }
  
  public static EditText getInputText(NumberPicker paramNumberPicker)
  {
    if (paramNumberPicker == null) {
      return null;
    }
    try
    {
      paramNumberPicker = (EditText)new b(paramNumberPicker, "mInputText", null).a();
      return paramNumberPicker;
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      f.a("NumberPickerUtil", paramNumberPicker, "getInputText NoSuchFieldException", new Object[0]);
      return null;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      f.a("NumberPickerUtil", paramNumberPicker, "getInputText IllegalAccessException", new Object[0]);
    }
    return null;
  }
  
  @Nullable
  public static Paint getSelectorWheelPaint(NumberPicker paramNumberPicker)
  {
    if (paramNumberPicker == null) {
      return null;
    }
    try
    {
      paramNumberPicker = (Paint)new b(paramNumberPicker, "mSelectorWheelPaint", null).a();
      return paramNumberPicker;
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      f.a("NumberPickerUtil", paramNumberPicker, "getSelectorWheelPaint NoSuchFieldException", new Object[0]);
      return null;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      f.a("NumberPickerUtil", paramNumberPicker, "getSelectorWheelPaint IllegalAccessException", new Object[0]);
    }
    return null;
  }
  
  public static void reflectSetDividerDrawable(NumberPicker paramNumberPicker, Drawable paramDrawable)
  {
    if (paramNumberPicker != null) {}
    try
    {
      new b(paramNumberPicker, "mSelectionDivider", null).a(paramDrawable);
      return;
    }
    catch (Exception paramNumberPicker) {}
  }
  
  public static void reflectSetDividerDrawable(Object paramObject, String paramString, Drawable paramDrawable)
  {
    try
    {
      paramObject = new b(paramObject, paramString, null).a();
      if ((paramObject != null) && ((paramObject instanceof NumberPicker)))
      {
        new b(paramObject, "mSelectionDivider", null).a(paramDrawable);
        return;
      }
    }
    catch (NoSuchFieldException paramObject)
    {
      f.a("NumberPickerUtil", paramObject, "reflectSetDividerDrawable NoSuchFieldException", new Object[0]);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      f.a("NumberPickerUtil", paramObject, "reflectSetDividerDrawable IllegalAccessException", new Object[0]);
    }
  }
  
  public static void reflectSetNumberPickerEditTextNotEditable(NumberPicker paramNumberPicker)
  {
    if (paramNumberPicker == null) {
      return;
    }
    paramNumberPicker.setDescendantFocusability(393216);
  }
  
  public static void removePendingSetSelectionCommand(NumberPicker paramNumberPicker)
  {
    if (paramNumberPicker == null) {
      return;
    }
    try
    {
      Runnable localRunnable = (Runnable)new b(paramNumberPicker, "mSetSelectionCommand", null).a();
      if (localRunnable != null)
      {
        paramNumberPicker.removeCallbacks(localRunnable);
        return;
      }
    }
    catch (NoSuchFieldException paramNumberPicker)
    {
      f.a("NumberPickerUtil", paramNumberPicker, "removePendingSetSelectionCommand NoSuchFieldException", new Object[0]);
      return;
    }
    catch (IllegalAccessException paramNumberPicker)
    {
      f.a("NumberPickerUtil", paramNumberPicker, "removePendingSetSelectionCommand IllegalAccessException", new Object[0]);
    }
  }
  
  public static void setNumberPickerTextColor(NumberPicker paramNumberPicker, int paramInt)
  {
    int j = paramNumberPicker.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramNumberPicker.getChildAt(i);
      if ((localView instanceof EditText))
      {
        Paint localPaint = getSelectorWheelPaint(paramNumberPicker);
        if (localPaint != null) {
          localPaint.setColor(paramInt);
        }
        ((EditText)localView).setTextColor(paramInt);
        paramNumberPicker.invalidate();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.NumberPickerUtil
 * JD-Core Version:    0.7.0.1
 */