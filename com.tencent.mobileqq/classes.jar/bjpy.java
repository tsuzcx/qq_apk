import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ptv.BaseButton;
import dov.com.qq.im.ptv.LightWeightCaptureButtonLayout;

public class bjpy
  extends AnimatorListenerAdapter
{
  public bjpy(LightWeightCaptureButtonLayout paramLightWeightCaptureButtonLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "startLockLoosenAnim  140ms end");
    }
    arql.a();
    this.a.a.setImageResource(2130843630);
    this.a.a.setOnTouchListener(null);
    this.a.a.setOnTouchListener(new bjpz(this));
    this.a.b.setStateful(true);
    this.a.b.setOnClickListener(new bjqa(this));
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "startLockLoosenAnim start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjpy
 * JD-Core Version:    0.7.0.1
 */