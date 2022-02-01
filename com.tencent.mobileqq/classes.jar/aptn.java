import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class aptn
  implements ValueAnimator.AnimatorUpdateListener
{
  aptn(aptm paramaptm) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptn
 * JD-Core Version:    0.7.0.1
 */