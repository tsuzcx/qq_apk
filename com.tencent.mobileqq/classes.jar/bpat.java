import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout;

public class bpat
  implements ValueAnimator.AnimatorUpdateListener
{
  public bpat(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpat
 * JD-Core Version:    0.7.0.1
 */