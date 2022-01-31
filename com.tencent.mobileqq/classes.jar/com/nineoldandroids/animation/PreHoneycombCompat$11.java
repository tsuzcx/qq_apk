package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.view.animation.AnimatorProxy;

class PreHoneycombCompat$11
  extends IntProperty<View>
{
  PreHoneycombCompat$11(String paramString)
  {
    super(paramString);
  }
  
  public Integer get(View paramView)
  {
    return Integer.valueOf(AnimatorProxy.wrap(paramView).getScrollX());
  }
  
  public void setValue(View paramView, int paramInt)
  {
    AnimatorProxy.wrap(paramView).setScrollX(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.nineoldandroids.animation.PreHoneycombCompat.11
 * JD-Core Version:    0.7.0.1
 */