package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

final class Slide$3
  extends Slide.CalculateSlideVertical
{
  Slide$3()
  {
    super(null);
  }
  
  public float getGoneY(ViewGroup paramViewGroup, View paramView)
  {
    return paramView.getTranslationY() - paramViewGroup.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.Slide.3
 * JD-Core Version:    0.7.0.1
 */