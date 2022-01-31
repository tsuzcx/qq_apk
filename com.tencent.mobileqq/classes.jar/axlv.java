import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;

public class axlv
  implements ValueAnimator.AnimatorUpdateListener
{
  public axlv(CameraCaptureButtonLayout paramCameraCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    CameraCaptureButtonLayout.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axlv
 * JD-Core Version:    0.7.0.1
 */