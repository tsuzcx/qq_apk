package androidx.dynamicanimation.animation;

import android.view.View;

final class DynamicAnimation$14
  extends DynamicAnimation.ViewProperty
{
  DynamicAnimation$14(String paramString)
  {
    super(paramString, null);
  }
  
  public float a(View paramView)
  {
    return paramView.getScrollY();
  }
  
  public void a(View paramView, float paramFloat)
  {
    paramView.setScrollY((int)paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation.14
 * JD-Core Version:    0.7.0.1
 */