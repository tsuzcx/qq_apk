import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation.AnimatorFactory.AnimatorListener;

public final class anie
  implements ValueAnimator.AnimatorUpdateListener
{
  public anie(AnimatorFactory.AnimatorListener paramAnimatorListener) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a != null) {
      this.a.a(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anie
 * JD-Core Version:    0.7.0.1
 */