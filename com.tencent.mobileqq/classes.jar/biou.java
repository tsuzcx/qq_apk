import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class biou
  implements ValueAnimator.AnimatorUpdateListener
{
  biou(biot parambiot) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    biot.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biou
 * JD-Core Version:    0.7.0.1
 */