package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

final class Slide$4
  extends Slide.CalculateSlideHorizontal
{
  Slide$4()
  {
    super(null);
  }
  
  public float getGoneX(ViewGroup paramViewGroup, View paramView)
  {
    return paramView.getTranslationX() + paramViewGroup.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.Slide.4
 * JD-Core Version:    0.7.0.1
 */