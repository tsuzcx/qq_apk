import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;

class azdn
  implements ValueAnimator.AnimatorUpdateListener
{
  azdn(azdh paramazdh) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (azdh.a(this.a) != null)
    {
      azdh.a(this.a).setAlpha(f);
      azdh.a(this.a).setTranslationY((1.0F - f) * agej.a(25.0F, azdh.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdn
 * JD-Core Version:    0.7.0.1
 */