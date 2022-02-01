import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.ae.view.AECMShowFaceScanView;

public class bnrk
  implements ValueAnimator.AnimatorUpdateListener
{
  public bnrk(AECMShowFaceScanView paramAECMShowFaceScanView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AECMShowFaceScanView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrk
 * JD-Core Version:    0.7.0.1
 */