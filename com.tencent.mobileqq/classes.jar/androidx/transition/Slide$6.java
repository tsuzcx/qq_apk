package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

final class Slide$6
  extends Slide.CalculateSlideVertical
{
  Slide$6()
  {
    super(null);
  }
  
  public float getGoneY(ViewGroup paramViewGroup, View paramView)
  {
    return paramView.getTranslationY() + paramViewGroup.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.Slide.6
 * JD-Core Version:    0.7.0.1
 */