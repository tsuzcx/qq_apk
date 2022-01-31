import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.nearby.widget.AutoScrollImageView;

public class avth
  implements ValueAnimator.AnimatorUpdateListener
{
  public avth(AutoScrollImageView paramAutoScrollImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AutoScrollImageView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avth
 * JD-Core Version:    0.7.0.1
 */