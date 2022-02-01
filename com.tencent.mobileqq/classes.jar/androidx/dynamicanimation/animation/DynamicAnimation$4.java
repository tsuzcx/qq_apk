package androidx.dynamicanimation.animation;

import android.view.View;

final class DynamicAnimation$4
  extends DynamicAnimation.ViewProperty
{
  DynamicAnimation$4(String paramString)
  {
    super(paramString, null);
  }
  
  public float a(View paramView)
  {
    return paramView.getScaleX();
  }
  
  public void a(View paramView, float paramFloat)
  {
    paramView.setScaleX(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation.4
 * JD-Core Version:    0.7.0.1
 */