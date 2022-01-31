import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.widget.DynamicGridView;

public class bhrt
  implements ValueAnimator.AnimatorUpdateListener
{
  public bhrt(DynamicGridView paramDynamicGridView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhrt
 * JD-Core Version:    0.7.0.1
 */