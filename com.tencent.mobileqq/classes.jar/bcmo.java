import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bcmo
  implements ValueAnimator.AnimatorUpdateListener
{
  bcmo(bcmn parambcmn) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    bcmn.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcmo
 * JD-Core Version:    0.7.0.1
 */