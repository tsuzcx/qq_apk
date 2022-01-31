import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class benz
  implements ValueAnimator.AnimatorUpdateListener
{
  benz(benw parambenw) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (benw.a(this.a) != null)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      benw.a(this.a).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benz
 * JD-Core Version:    0.7.0.1
 */