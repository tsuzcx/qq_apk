import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;

public class bnhg
  implements ValueAnimator.AnimatorUpdateListener
{
  public bnhg(CameraCaptureButtonLayout paramCameraCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    CameraCaptureButtonLayout.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhg
 * JD-Core Version:    0.7.0.1
 */