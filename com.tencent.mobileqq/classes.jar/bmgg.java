import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;

public class bmgg
  extends AnimatorListenerAdapter
{
  public bmgg(LightWeightCaptureButtonLayout paramLightWeightCaptureButtonLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.d = 5;
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "startDeleteAdsorptionAnimation captureView 190ms all end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "startDeleteAdsorptionAnimation captureView begin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgg
 * JD-Core Version:    0.7.0.1
 */