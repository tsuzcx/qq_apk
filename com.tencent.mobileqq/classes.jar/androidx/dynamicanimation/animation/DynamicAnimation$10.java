package androidx.dynamicanimation.animation;

import android.view.View;

final class DynamicAnimation$10
  extends DynamicAnimation.ViewProperty
{
  DynamicAnimation$10(String paramString)
  {
    super(paramString, null);
  }
  
  public float getValue(View paramView)
  {
    return paramView.getY();
  }
  
  public void setValue(View paramView, float paramFloat)
  {
    paramView.setY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation.10
 * JD-Core Version:    0.7.0.1
 */