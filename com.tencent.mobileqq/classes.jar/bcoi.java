import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class bcoi
  implements ValueAnimator.AnimatorUpdateListener
{
  bcoi(bcof parambcof) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (bcof.a(this.a) != null)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      bcof.a(this.a).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcoi
 * JD-Core Version:    0.7.0.1
 */