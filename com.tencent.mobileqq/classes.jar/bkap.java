import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bkap
  implements ValueAnimator.AnimatorUpdateListener
{
  bkap(bkao parambkao) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.w = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkap
 * JD-Core Version:    0.7.0.1
 */