import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bqjj
  implements ValueAnimator.AnimatorUpdateListener
{
  bqjj(bqji parambqji) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqjj
 * JD-Core Version:    0.7.0.1
 */