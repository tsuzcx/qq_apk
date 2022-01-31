import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;

public class anom
  implements ValueAnimator.AnimatorUpdateListener
{
  public anom(PickerContainer paramPickerContainer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setAlpha(PickerContainer.b(this.a).floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anom
 * JD-Core Version:    0.7.0.1
 */