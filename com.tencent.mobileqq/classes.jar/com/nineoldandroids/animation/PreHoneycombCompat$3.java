package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.view.animation.AnimatorProxy;

class PreHoneycombCompat$3
  extends FloatProperty<View>
{
  PreHoneycombCompat$3(String paramString)
  {
    super(paramString);
  }
  
  public Float get(View paramView)
  {
    return Float.valueOf(AnimatorProxy.wrap(paramView).getPivotY());
  }
  
  public void setValue(View paramView, float paramFloat)
  {
    AnimatorProxy.wrap(paramView).setPivotY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nineoldandroids.animation.PreHoneycombCompat.3
 * JD-Core Version:    0.7.0.1
 */