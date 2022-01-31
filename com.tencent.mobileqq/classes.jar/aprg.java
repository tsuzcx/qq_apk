import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.widget.LinearLayout;

class aprg
  implements ValueAnimator.AnimatorUpdateListener
{
  aprg(aprb paramaprb) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f = Float.valueOf(paramValueAnimator.getAnimatedValue().toString()).floatValue();
      if ((aprb.a(this.a).getVisibility() == 0) && (Math.abs(aprb.a(this.a).getAlpha() - f) >= 0.02F)) {
        aprb.a(this.a).setAlpha(f);
      }
      if ((aprb.a(this.a).getVisibility() == 0) && (Math.abs(aprb.a(this.a).getAlpha() - f) >= 0.02F)) {
        aprb.a(this.a).setAlpha(f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aprg
 * JD-Core Version:    0.7.0.1
 */