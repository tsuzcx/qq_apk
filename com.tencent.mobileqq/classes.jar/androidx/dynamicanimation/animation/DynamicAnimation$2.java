package androidx.dynamicanimation.animation;

import android.view.View;

final class DynamicAnimation$2
  extends DynamicAnimation.ViewProperty
{
  DynamicAnimation$2(String paramString)
  {
    super(paramString, null);
  }
  
  public float a(View paramView)
  {
    return paramView.getTranslationY();
  }
  
  public void a(View paramView, float paramFloat)
  {
    paramView.setTranslationY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation.2
 * JD-Core Version:    0.7.0.1
 */