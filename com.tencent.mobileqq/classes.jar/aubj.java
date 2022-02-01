import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.widget.LinearLayout;

class aubj
  implements ValueAnimator.AnimatorUpdateListener
{
  aubj(aubg paramaubg) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f = Float.valueOf(paramValueAnimator.getAnimatedValue().toString()).floatValue();
      if ((aubg.a(this.a).getVisibility() == 0) && (Math.abs(aubg.a(this.a).getAlpha() - f) >= 0.02F)) {
        aubg.a(this.a).setAlpha(f);
      }
      if ((aubg.a(this.a).getVisibility() == 0) && (Math.abs(aubg.a(this.a).getAlpha() - f) >= 0.02F)) {
        aubg.a(this.a).setAlpha(f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubj
 * JD-Core Version:    0.7.0.1
 */