import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;

public class atiy
  implements ValueAnimator.AnimatorUpdateListener
{
  public atiy(ScanIconAnimateView paramScanIconAnimateView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.d = (((Float)paramValueAnimator.getAnimatedValue()).floatValue() * -1.0F * aciy.a(1.5F, this.a.getResources()));
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     atiy
 * JD-Core Version:    0.7.0.1
 */