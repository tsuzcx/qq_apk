import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.widget.LinearLayout;

class arki
  implements ValueAnimator.AnimatorUpdateListener
{
  arki(arke paramarke) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f = Float.valueOf(paramValueAnimator.getAnimatedValue().toString()).floatValue();
      if ((arke.a(this.a).getVisibility() == 0) && (Math.abs(arke.a(this.a).getAlpha() - f) >= 0.02F)) {
        arke.a(this.a).setAlpha(f);
      }
      if ((arke.a(this.a).getVisibility() == 0) && (Math.abs(arke.a(this.a).getAlpha() - f) >= 0.02F)) {
        arke.a(this.a).setAlpha(f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arki
 * JD-Core Version:    0.7.0.1
 */