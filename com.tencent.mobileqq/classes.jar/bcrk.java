import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.troop.widget.RedDotAnimateView;

public class bcrk
  implements ValueAnimator.AnimatorUpdateListener
{
  public bcrk(RedDotAnimateView paramRedDotAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.c = ((int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F));
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcrk
 * JD-Core Version:    0.7.0.1
 */