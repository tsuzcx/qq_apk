import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class bmra
  implements ValueAnimator.AnimatorUpdateListener
{
  bmra(bmqz parambmqz) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a.a.b == null) {
      return;
    }
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.s = (this.a.d + this.a.f * f);
    this.a.t = (this.a.e + this.a.g * f);
    this.a.q = (this.a.b + this.a.h * f);
    this.a.r = (this.a.c + this.a.i * f);
    if (this.a.a.a != null) {
      this.a.a.a.a(f);
    }
    if (f == 1.0F) {
      this.a.a.b(5);
    }
    bmqw.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmra
 * JD-Core Version:    0.7.0.1
 */