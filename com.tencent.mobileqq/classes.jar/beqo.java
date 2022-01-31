import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class beqo
  implements ValueAnimator.AnimatorUpdateListener
{
  beqo(beqn parambeqn) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    beqn.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqo
 * JD-Core Version:    0.7.0.1
 */