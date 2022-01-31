import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.nearby.widget.GradientAnimTextView;

public class atbu
  implements ValueAnimator.AnimatorUpdateListener
{
  public atbu(GradientAnimTextView paramGradientAnimTextView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    GradientAnimTextView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atbu
 * JD-Core Version:    0.7.0.1
 */