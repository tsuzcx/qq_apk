import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;

class avwt
  implements ValueAnimator.AnimatorUpdateListener
{
  avwt(avwn paramavwn) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (avwn.a(this.a) != null)
    {
      avwn.a(this.a).setAlpha(f);
      avwn.a(this.a).setTranslationY((1.0F - f) * aekt.a(25.0F, avwn.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avwt
 * JD-Core Version:    0.7.0.1
 */