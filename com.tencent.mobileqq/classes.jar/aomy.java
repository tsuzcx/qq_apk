import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.HintDrawable;

public class aomy
  implements ValueAnimator.AnimatorUpdateListener
{
  public aomy(HintDrawable paramHintDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aomy
 * JD-Core Version:    0.7.0.1
 */