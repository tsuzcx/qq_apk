import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class amjm
  implements ValueAnimator.AnimatorUpdateListener
{
  amjm(amjl paramamjl) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjm
 * JD-Core Version:    0.7.0.1
 */