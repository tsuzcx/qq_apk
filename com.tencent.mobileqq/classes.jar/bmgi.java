import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;

public class bmgi
  extends AnimatorListenerAdapter
{
  public bmgi(LightWeightCaptureButtonLayout paramLightWeightCaptureButtonLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "startDeleteAdsorptionAnimation  140ms translate end");
    }
    this.a.a.d = 4;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a.a = SystemClock.uptimeMillis();
    this.a.a.b = 140L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgi
 * JD-Core Version:    0.7.0.1
 */