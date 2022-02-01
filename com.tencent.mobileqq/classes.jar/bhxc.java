import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bhxc
  implements ValueAnimator.AnimatorUpdateListener
{
  bhxc(bhxb parambhxb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    bhxb.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxc
 * JD-Core Version:    0.7.0.1
 */