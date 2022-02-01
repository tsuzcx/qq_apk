import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;

public class bbgy
  implements ValueAnimator.AnimatorUpdateListener
{
  public bbgy(CameraCaptureButtonLayout paramCameraCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    CameraCaptureButtonLayout.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgy
 * JD-Core Version:    0.7.0.1
 */