import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.widget.LinearLayout;

class atsx
  implements ValueAnimator.AnimatorUpdateListener
{
  atsx(atsu paramatsu) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f = Float.valueOf(paramValueAnimator.getAnimatedValue().toString()).floatValue();
      if ((atsu.a(this.a).getVisibility() == 0) && (Math.abs(atsu.a(this.a).getAlpha() - f) >= 0.02F)) {
        atsu.a(this.a).setAlpha(f);
      }
      if ((atsu.a(this.a).getVisibility() == 0) && (Math.abs(atsu.a(this.a).getAlpha() - f) >= 0.02F)) {
        atsu.a(this.a).setAlpha(f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsx
 * JD-Core Version:    0.7.0.1
 */