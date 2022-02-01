import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.ArrayList;

class bpcr
  implements ValueAnimator.AnimatorUpdateListener
{
  bpcr(bpcq parambpcq) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (ArrayList)paramValueAnimator.getAnimatedValue();
    this.a.a = paramValueAnimator;
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpcr
 * JD-Core Version:    0.7.0.1
 */