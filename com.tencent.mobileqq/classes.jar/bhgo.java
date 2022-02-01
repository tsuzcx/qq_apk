import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class bhgo
  implements ValueAnimator.AnimatorUpdateListener
{
  bhgo(bhgl parambhgl) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (bhgl.a(this.a) != null)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      bhgl.a(this.a).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhgo
 * JD-Core Version:    0.7.0.1
 */