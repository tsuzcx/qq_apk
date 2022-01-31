import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.nearby.widget.GradientAnimTextView;

public class atya
  implements ValueAnimator.AnimatorUpdateListener
{
  public atya(GradientAnimTextView paramGradientAnimTextView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    GradientAnimTextView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atya
 * JD-Core Version:    0.7.0.1
 */