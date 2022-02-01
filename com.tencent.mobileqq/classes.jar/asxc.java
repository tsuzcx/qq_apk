import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.widget.LinearLayout;

class asxc
  implements ValueAnimator.AnimatorUpdateListener
{
  asxc(aswz paramaswz) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      float f = Float.valueOf(paramValueAnimator.getAnimatedValue().toString()).floatValue();
      if ((aswz.a(this.a).getVisibility() == 0) && (Math.abs(aswz.a(this.a).getAlpha() - f) >= 0.02F)) {
        aswz.a(this.a).setAlpha(f);
      }
      if ((aswz.a(this.a).getVisibility() == 0) && (Math.abs(aswz.a(this.a).getAlpha() - f) >= 0.02F)) {
        aswz.a(this.a).setAlpha(f);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxc
 * JD-Core Version:    0.7.0.1
 */