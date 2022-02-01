import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;

class ayku
  implements ValueAnimator.AnimatorUpdateListener
{
  ayku(ayko paramayko) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (ayko.a(this.a) != null)
    {
      ayko.a(this.a).setAlpha(f);
      ayko.a(this.a).setTranslationY((1.0F - f) * afur.a(25.0F, ayko.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayku
 * JD-Core Version:    0.7.0.1
 */