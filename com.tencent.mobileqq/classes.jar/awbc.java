import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;

class awbc
  implements ValueAnimator.AnimatorUpdateListener
{
  awbc(awaw paramawaw) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (awaw.a(this.a) != null)
    {
      awaw.a(this.a).setAlpha(f);
      awaw.a(this.a).setTranslationY((1.0F - f) * aepi.a(25.0F, awaw.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awbc
 * JD-Core Version:    0.7.0.1
 */