import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;

public class bmgl
  extends AnimatorListenerAdapter
{
  public bmgl(LightWeightCaptureButtonLayout paramLightWeightCaptureButtonLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "startLockLoosenAnim  140ms end");
    }
    atlr.a();
    this.a.a.setImageResource(2130844062);
    this.a.a.setOnTouchListener(null);
    this.a.a.setOnTouchListener(new bmgm(this));
    this.a.b.setStateful(true);
    this.a.b.setOnClickListener(new bmgn(this));
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "startLockLoosenAnim start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgl
 * JD-Core Version:    0.7.0.1
 */