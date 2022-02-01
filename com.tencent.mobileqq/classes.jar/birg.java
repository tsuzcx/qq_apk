import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class birg
  implements ValueAnimator.AnimatorUpdateListener
{
  birg(bird parambird) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (bird.a(this.a) != null)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      bird.a(this.a).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     birg
 * JD-Core Version:    0.7.0.1
 */