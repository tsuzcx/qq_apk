import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bqjm
  implements ValueAnimator.AnimatorUpdateListener
{
  bqjm(bqjl parambqjl) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.w = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqjm
 * JD-Core Version:    0.7.0.1
 */