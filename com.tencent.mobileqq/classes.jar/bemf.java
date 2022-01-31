import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bemf
  implements ValueAnimator.AnimatorUpdateListener
{
  bemf(beme parambeme) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    beme.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemf
 * JD-Core Version:    0.7.0.1
 */