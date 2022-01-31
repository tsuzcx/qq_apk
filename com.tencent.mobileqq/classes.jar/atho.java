import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;

class atho
  implements ValueAnimator.AnimatorUpdateListener
{
  atho(athi paramathi) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (athi.a(this.a) != null)
    {
      athi.a(this.a).setAlpha(f);
      athi.a(this.a).setTranslationY((1.0F - f) * aciy.a(25.0F, athi.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     atho
 * JD-Core Version:    0.7.0.1
 */