import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.LightWeightCaptureButtonCornerLayout;
import dov.com.qq.im.ptv.LightWeightProgress;

public class bmfv
  extends AnimatorListenerAdapter
{
  public bmfv(LightWeightCaptureButtonCornerLayout paramLightWeightCaptureButtonCornerLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "rollBackDeleteAnimatorToActiveCorner mProgressView 50ms delay=90ms end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a.setStatus(false);
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "rollBackDeleteAnimatorToActiveCorner mProgressView begin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfv
 * JD-Core Version:    0.7.0.1
 */