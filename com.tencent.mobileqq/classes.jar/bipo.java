import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bipo
  implements ValueAnimator.AnimatorUpdateListener
{
  bipo(bipn parambipn) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    bipn.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bipo
 * JD-Core Version:    0.7.0.1
 */