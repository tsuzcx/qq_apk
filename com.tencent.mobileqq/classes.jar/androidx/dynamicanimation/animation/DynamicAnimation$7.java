package androidx.dynamicanimation.animation;

import android.view.View;

final class DynamicAnimation$7
  extends DynamicAnimation.ViewProperty
{
  DynamicAnimation$7(String paramString)
  {
    super(paramString, null);
  }
  
  public float getValue(View paramView)
  {
    return paramView.getRotationX();
  }
  
  public void setValue(View paramView, float paramFloat)
  {
    paramView.setRotationX(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation.7
 * JD-Core Version:    0.7.0.1
 */