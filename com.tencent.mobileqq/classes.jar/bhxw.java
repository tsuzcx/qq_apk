import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bhxw
  implements ValueAnimator.AnimatorUpdateListener
{
  bhxw(bhxv parambhxv) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    bhxv.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxw
 * JD-Core Version:    0.7.0.1
 */