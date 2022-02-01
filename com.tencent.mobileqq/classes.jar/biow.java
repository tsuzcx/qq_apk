import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class biow
  implements ValueAnimator.AnimatorUpdateListener
{
  biow(biot parambiot) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    biot.b(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biow
 * JD-Core Version:    0.7.0.1
 */