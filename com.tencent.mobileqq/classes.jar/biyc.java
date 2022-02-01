import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class biyc
  implements ValueAnimator.AnimatorUpdateListener
{
  biyc(bixz parambixz) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    bixz.b(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biyc
 * JD-Core Version:    0.7.0.1
 */