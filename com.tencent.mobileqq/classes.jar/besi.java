import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class besi
  implements ValueAnimator.AnimatorUpdateListener
{
  besi(besf parambesf) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (besf.a(this.a) != null)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      besf.a(this.a).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besi
 * JD-Core Version:    0.7.0.1
 */