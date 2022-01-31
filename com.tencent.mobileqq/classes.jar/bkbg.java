import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bkbg
  implements ValueAnimator.AnimatorUpdateListener
{
  bkbg(bkbd parambkbd) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.w = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkbg
 * JD-Core Version:    0.7.0.1
 */