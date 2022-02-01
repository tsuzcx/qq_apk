import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bhxe
  implements ValueAnimator.AnimatorUpdateListener
{
  bhxe(bhxb parambhxb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    bhxb.b(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxe
 * JD-Core Version:    0.7.0.1
 */