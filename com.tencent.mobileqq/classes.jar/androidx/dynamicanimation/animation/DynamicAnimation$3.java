package androidx.dynamicanimation.animation;

import android.view.View;
import androidx.core.view.ViewCompat;

final class DynamicAnimation$3
  extends DynamicAnimation.ViewProperty
{
  DynamicAnimation$3(String paramString)
  {
    super(paramString, null);
  }
  
  public float a(View paramView)
  {
    return ViewCompat.getTranslationZ(paramView);
  }
  
  public void a(View paramView, float paramFloat)
  {
    ViewCompat.setTranslationZ(paramView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation.3
 * JD-Core Version:    0.7.0.1
 */