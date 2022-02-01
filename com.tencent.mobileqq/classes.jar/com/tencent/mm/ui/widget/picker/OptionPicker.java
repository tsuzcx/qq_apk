package com.tencent.mm.ui.widget.picker;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.NumberPicker;
import com.tencent.mm.ui.g;

public class OptionPicker
  extends NumberPicker
{
  private String[] a;
  private int b;
  private int c;
  private int d;
  private Context e;
  
  public OptionPicker(Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
    a();
  }
  
  public OptionPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e = paramContext;
    a();
  }
  
  public OptionPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.e = paramContext;
    a();
  }
  
  @TargetApi(21)
  public OptionPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.e = paramContext;
    a();
  }
  
  private void a()
  {
    this.b = g.a(this.e, 120);
    this.d = g.a(this.e, 20);
    NumberPickerUtil.reflectSetDividerDrawable(this, getResources().getDrawable(2130842461));
    setDescendantFocusability(393216);
    NumberPickerUtil.setNumberPickerTextColor(this, this.e.getResources().getColor(2131166595));
  }
  
  public final int currentIndex()
  {
    return getValue();
  }
  
  public final String currentValue()
  {
    String[] arrayOfString = this.a;
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      return arrayOfString[getValue()];
    }
    return "";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((View.MeasureSpec.getMode(paramInt1) == -2147483648) || (View.MeasureSpec.getMode(paramInt1) == 1073741824)) {
      this.c = View.MeasureSpec.getSize(paramInt1);
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), paramInt2);
    paramInt2 = getMeasuredWidth();
    paramInt1 = this.b;
    if (paramInt2 <= paramInt1)
    {
      paramInt2 = this.c;
      if ((paramInt2 <= 0) || (paramInt1 <= paramInt2))
      {
        setMeasuredDimension(this.b, getMeasuredHeight());
        return;
      }
    }
    paramInt2 = getMeasuredWidth() + this.d * 2;
    int i = this.c;
    paramInt1 = paramInt2;
    if (i > 0) {
      if (i > paramInt2) {
        paramInt1 = paramInt2;
      } else {
        paramInt1 = i;
      }
    }
    setMeasuredDimension(paramInt1, getMeasuredHeight());
  }
  
  @Deprecated
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    super.setDisplayedValues(paramArrayOfString);
  }
  
  public final void setExtraPadding(int paramInt)
  {
    this.d = Math.max(paramInt, 0);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void setMinWidth(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setOptionsArray(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    this.a = paramArrayOfString;
    setDisplayedValues(null);
    setMinValue(0);
    setMaxValue(Math.max(paramArrayOfString.length - 1, 0));
    setWrapSelectorWheel(false);
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString.length <= 0) {
      arrayOfString = null;
    }
    super.setDisplayedValues(arrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.OptionPicker
 * JD-Core Version:    0.7.0.1
 */