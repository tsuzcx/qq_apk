import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;

public class awcp
  implements ValueAnimator.AnimatorUpdateListener
{
  public awcp(ScanIconAnimateView paramScanIconAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.e = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awcp
 * JD-Core Version:    0.7.0.1
 */