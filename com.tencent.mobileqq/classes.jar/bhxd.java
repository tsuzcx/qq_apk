import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Paint;

class bhxd
  implements ValueAnimator.AnimatorUpdateListener
{
  bhxd(bhxb parambhxb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    bhxb.a(this.a).setAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxd
 * JD-Core Version:    0.7.0.1
 */