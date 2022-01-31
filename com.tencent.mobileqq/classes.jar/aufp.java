import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;

class aufp
  implements ValueAnimator.AnimatorUpdateListener
{
  aufp(aufj paramaufj) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (aufj.a(this.a) != null)
    {
      aufj.a(this.a).setAlpha(f);
      aufj.a(this.a).setTranslationY((1.0F - f) * actj.a(25.0F, aufj.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aufp
 * JD-Core Version:    0.7.0.1
 */