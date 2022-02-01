import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bhee
  implements ValueAnimator.AnimatorUpdateListener
{
  bhee(bheb parambheb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    bheb.b(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhee
 * JD-Core Version:    0.7.0.1
 */