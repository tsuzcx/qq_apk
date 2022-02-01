package androidx.dynamicanimation.animation;

import android.view.View;

final class DynamicAnimation$12
  extends DynamicAnimation.ViewProperty
{
  DynamicAnimation$12(String paramString)
  {
    super(paramString, null);
  }
  
  public float getValue(View paramView)
  {
    return paramView.getAlpha();
  }
  
  public void setValue(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation.12
 * JD-Core Version:    0.7.0.1
 */