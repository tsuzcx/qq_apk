import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class bcox
  implements ValueAnimator.AnimatorUpdateListener
{
  bcox(bcou parambcou) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (bcou.a(this.a) != null)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      bcou.a(this.a).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcox
 * JD-Core Version:    0.7.0.1
 */