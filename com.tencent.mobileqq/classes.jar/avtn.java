import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.nearby.widget.GradientAnimTextView;

public class avtn
  implements ValueAnimator.AnimatorUpdateListener
{
  public avtn(GradientAnimTextView paramGradientAnimTextView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    GradientAnimTextView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avtn
 * JD-Core Version:    0.7.0.1
 */