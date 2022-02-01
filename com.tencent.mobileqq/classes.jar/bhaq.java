import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class bhaq
  implements ValueAnimator.AnimatorUpdateListener
{
  bhaq(ayvn paramayvn) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.a.a(paramValueAnimator.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhaq
 * JD-Core Version:    0.7.0.1
 */