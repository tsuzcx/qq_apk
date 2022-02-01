package com.google.android.material.slider;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R.attr;
import java.util.List;

public class Slider
  extends BaseSlider<Slider, Slider.OnChangeListener, Slider.OnSliderTouchListener>
{
  public Slider(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Slider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.P);
  }
  
  public Slider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842788 });
    if (paramContext.hasValue(0)) {
      setValue(paramContext.getFloat(0, 0.0F));
    }
    paramContext.recycle();
  }
  
  protected boolean b()
  {
    if (getActiveThumbIndex() != -1) {
      return true;
    }
    setActiveThumbIndex(0);
    return true;
  }
  
  public float getValue()
  {
    return ((Float)getValues().get(0)).floatValue();
  }
  
  public void setValue(float paramFloat)
  {
    setValues(new Float[] { Float.valueOf(paramFloat) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.slider.Slider
 * JD-Core Version:    0.7.0.1
 */