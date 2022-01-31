import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

public class bkvj
  implements ValueAnimator.AnimatorUpdateListener
{
  public bkvj(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkvj
 * JD-Core Version:    0.7.0.1
 */