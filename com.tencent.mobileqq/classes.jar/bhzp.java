import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class bhzp
  implements ValueAnimator.AnimatorUpdateListener
{
  bhzp(bhzm parambhzm) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (bhzm.a(this.a) != null)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      bhzm.a(this.a).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhzp
 * JD-Core Version:    0.7.0.1
 */