import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.ArrayList;

class bqqv
  implements ValueAnimator.AnimatorUpdateListener
{
  bqqv(bqqu parambqqu) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (ArrayList)paramValueAnimator.getAnimatedValue();
    this.a.a = paramValueAnimator;
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqqv
 * JD-Core Version:    0.7.0.1
 */