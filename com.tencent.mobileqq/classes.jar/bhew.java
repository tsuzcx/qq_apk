import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bhew
  implements ValueAnimator.AnimatorUpdateListener
{
  bhew(bhev parambhev) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    bhev.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhew
 * JD-Core Version:    0.7.0.1
 */