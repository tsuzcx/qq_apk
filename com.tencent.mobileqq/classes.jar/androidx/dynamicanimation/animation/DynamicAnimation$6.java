package androidx.dynamicanimation.animation;

import android.view.View;

final class DynamicAnimation$6
  extends DynamicAnimation.ViewProperty
{
  DynamicAnimation$6(String paramString)
  {
    super(paramString, null);
  }
  
  public float getValue(View paramView)
  {
    return paramView.getRotation();
  }
  
  public void setValue(View paramView, float paramFloat)
  {
    paramView.setRotation(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation.6
 * JD-Core Version:    0.7.0.1
 */