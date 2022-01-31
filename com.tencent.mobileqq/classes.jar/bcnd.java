import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bcnd
  implements ValueAnimator.AnimatorUpdateListener
{
  bcnd(bcnc parambcnc) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    bcnc.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcnd
 * JD-Core Version:    0.7.0.1
 */