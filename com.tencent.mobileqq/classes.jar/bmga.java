import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.LightWeightCaptureButtonHorizontalLayout;
import dov.com.qq.im.ptv.LightWeightProgress;

public class bmga
  extends AnimatorListenerAdapter
{
  public bmga(LightWeightCaptureButtonHorizontalLayout paramLightWeightCaptureButtonHorizontalLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "rollBackDeleteAnimatorToActive mProgressView 50ms delay=90ms end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a.setStatus(false);
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "rollBackDeleteAnimatorToActive mProgressView begin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmga
 * JD-Core Version:    0.7.0.1
 */