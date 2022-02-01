import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.troop.widget.RedDotAnimateView;

public class bgnu
  implements ValueAnimator.AnimatorUpdateListener
{
  public bgnu(RedDotAnimateView paramRedDotAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.b = (((Float)paramValueAnimator.getAnimatedValue()).floatValue() * this.a.a / 2.0F);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgnu
 * JD-Core Version:    0.7.0.1
 */