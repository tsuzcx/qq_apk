package com.google.android.material.floatingactionbutton;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import com.google.android.material.animation.AnimationUtils;

class BaseMotionStrategy$1
  extends Property<ExtendedFloatingActionButton, Float>
{
  BaseMotionStrategy$1(BaseMotionStrategy paramBaseMotionStrategy, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(ExtendedFloatingActionButton paramExtendedFloatingActionButton)
  {
    int i = Color.alpha(paramExtendedFloatingActionButton.a.getColorForState(paramExtendedFloatingActionButton.getDrawableState(), BaseMotionStrategy.a(this.a).a.getDefaultColor()));
    return Float.valueOf(AnimationUtils.a(0.0F, 1.0F, Color.alpha(paramExtendedFloatingActionButton.getCurrentTextColor()) / 255.0F / i));
  }
  
  public void a(ExtendedFloatingActionButton paramExtendedFloatingActionButton, Float paramFloat)
  {
    int i = paramExtendedFloatingActionButton.a.getColorForState(paramExtendedFloatingActionButton.getDrawableState(), BaseMotionStrategy.a(this.a).a.getDefaultColor());
    ColorStateList localColorStateList = ColorStateList.valueOf(Color.argb((int)(AnimationUtils.a(0.0F, Color.alpha(i) / 255.0F, paramFloat.floatValue()) * 255.0F), Color.red(i), Color.green(i), Color.blue(i)));
    if (paramFloat.floatValue() == 1.0F)
    {
      paramExtendedFloatingActionButton.a(paramExtendedFloatingActionButton.a);
      return;
    }
    paramExtendedFloatingActionButton.a(localColorStateList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.BaseMotionStrategy.1
 * JD-Core Version:    0.7.0.1
 */