package androidx.dynamicanimation.animation;

import android.view.View;

final class DynamicAnimation$9
  extends DynamicAnimation.ViewProperty
{
  DynamicAnimation$9(String paramString)
  {
    super(paramString, null);
  }
  
  public float getValue(View paramView)
  {
    return paramView.getX();
  }
  
  public void setValue(View paramView, float paramFloat)
  {
    paramView.setX(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation.9
 * JD-Core Version:    0.7.0.1
 */