import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.Button;
import dov.com.qq.im.ae.AECMShowCameraUnit.7;

public class bmvq
  implements ValueAnimator.AnimatorUpdateListener
{
  public bmvq(AECMShowCameraUnit.7 param7) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    bmvk.a(this.a.this$0).setAlpha(paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvq
 * JD-Core Version:    0.7.0.1
 */