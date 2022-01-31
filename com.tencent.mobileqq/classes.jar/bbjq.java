import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bbjq
  implements ValueAnimator.AnimatorUpdateListener
{
  bbjq(bbjp parambbjp) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    bbjp.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbjq
 * JD-Core Version:    0.7.0.1
 */