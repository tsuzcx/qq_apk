package androidx.dynamicanimation.animation;

import android.view.View;

final class DynamicAnimation$13
  extends DynamicAnimation.ViewProperty
{
  DynamicAnimation$13(String paramString)
  {
    super(paramString, null);
  }
  
  public float getValue(View paramView)
  {
    return paramView.getScrollX();
  }
  
  public void setValue(View paramView, float paramFloat)
  {
    paramView.setScrollX((int)paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation.13
 * JD-Core Version:    0.7.0.1
 */