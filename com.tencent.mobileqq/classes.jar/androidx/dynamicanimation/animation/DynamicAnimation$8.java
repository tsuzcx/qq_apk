package androidx.dynamicanimation.animation;

import android.view.View;

final class DynamicAnimation$8
  extends DynamicAnimation.ViewProperty
{
  DynamicAnimation$8(String paramString)
  {
    super(paramString, null);
  }
  
  public float getValue(View paramView)
  {
    return paramView.getRotationY();
  }
  
  public void setValue(View paramView, float paramFloat)
  {
    paramView.setRotationY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation.8
 * JD-Core Version:    0.7.0.1
 */