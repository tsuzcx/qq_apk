import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation.AnimatorFactory.AnimatorListener;

public final class anyj
  implements ValueAnimator.AnimatorUpdateListener
{
  public anyj(AnimatorFactory.AnimatorListener paramAnimatorListener) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a != null) {
      this.a.a(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anyj
 * JD-Core Version:    0.7.0.1
 */