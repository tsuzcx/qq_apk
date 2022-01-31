import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;

class aufn
  implements ValueAnimator.AnimatorUpdateListener
{
  aufn(aufh paramaufh) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (aufh.a(this.a) != null)
    {
      aufh.a(this.a).setAlpha(f);
      aufh.a(this.a).setTranslationY((1.0F - f) * actn.a(25.0F, aufh.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aufn
 * JD-Core Version:    0.7.0.1
 */