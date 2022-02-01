package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

final class Slide$1
  extends Slide.CalculateSlideHorizontal
{
  Slide$1()
  {
    super(null);
  }
  
  public float getGoneX(ViewGroup paramViewGroup, View paramView)
  {
    return paramView.getTranslationX() - paramViewGroup.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.Slide.1
 * JD-Core Version:    0.7.0.1
 */