import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Paint;

class biov
  implements ValueAnimator.AnimatorUpdateListener
{
  biov(biot parambiot) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    biot.a(this.a).setAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biov
 * JD-Core Version:    0.7.0.1
 */