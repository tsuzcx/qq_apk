import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.widget.LinearLayout;

class aror
  implements ValueAnimator.AnimatorUpdateListener
{
  aror(aron paramaron) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f = Float.valueOf(paramValueAnimator.getAnimatedValue().toString()).floatValue();
      if ((aron.a(this.a).getVisibility() == 0) && (Math.abs(aron.a(this.a).getAlpha() - f) >= 0.02F)) {
        aron.a(this.a).setAlpha(f);
      }
      if ((aron.a(this.a).getVisibility() == 0) && (Math.abs(aron.a(this.a).getAlpha() - f) >= 0.02F)) {
        aron.a(this.a).setAlpha(f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aror
 * JD-Core Version:    0.7.0.1
 */