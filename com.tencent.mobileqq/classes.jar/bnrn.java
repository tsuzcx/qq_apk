import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.ae.view.AECMShowFaceScanView;

public class bnrn
  implements ValueAnimator.AnimatorUpdateListener
{
  public bnrn(AECMShowFaceScanView paramAECMShowFaceScanView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AECMShowFaceScanView.c(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrn
 * JD-Core Version:    0.7.0.1
 */