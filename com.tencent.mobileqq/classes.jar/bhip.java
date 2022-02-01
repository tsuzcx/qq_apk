import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class bhip
  implements ValueAnimator.AnimatorUpdateListener
{
  bhip(azbu paramazbu) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.a.a(paramValueAnimator.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhip
 * JD-Core Version:    0.7.0.1
 */