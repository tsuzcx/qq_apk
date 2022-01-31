import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bkam
  implements ValueAnimator.AnimatorUpdateListener
{
  bkam(bkal parambkal) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkam
 * JD-Core Version:    0.7.0.1
 */