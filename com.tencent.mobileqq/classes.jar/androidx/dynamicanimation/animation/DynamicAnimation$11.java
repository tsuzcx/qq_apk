package androidx.dynamicanimation.animation;

import android.view.View;
import androidx.core.view.ViewCompat;

final class DynamicAnimation$11
  extends DynamicAnimation.ViewProperty
{
  DynamicAnimation$11(String paramString)
  {
    super(paramString, null);
  }
  
  public float getValue(View paramView)
  {
    return ViewCompat.getZ(paramView);
  }
  
  public void setValue(View paramView, float paramFloat)
  {
    ViewCompat.setZ(paramView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation.11
 * JD-Core Version:    0.7.0.1
 */