import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bmrb
  implements ValueAnimator.AnimatorUpdateListener
{
  bmrb(bmqz parambmqz) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a.a.b == null) {
      return;
    }
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.s = (this.a.d + this.a.f * (1.0F - f));
    this.a.t = (this.a.e + this.a.g * (1.0F - f));
    this.a.q = (this.a.b + this.a.h * (1.0F - f));
    this.a.r = (this.a.c + this.a.i * (1.0F - f));
    if (f == 1.0F)
    {
      this.a.a.b = null;
      this.a.a.b(4);
    }
    bmqw.b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrb
 * JD-Core Version:    0.7.0.1
 */