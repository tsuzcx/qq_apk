package androidx.dynamicanimation.animation;

import android.view.View;

final class DynamicAnimation$5
  extends DynamicAnimation.ViewProperty
{
  DynamicAnimation$5(String paramString)
  {
    super(paramString, null);
  }
  
  public float getValue(View paramView)
  {
    return paramView.getScaleY();
  }
  
  public void setValue(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation.5
 * JD-Core Version:    0.7.0.1
 */