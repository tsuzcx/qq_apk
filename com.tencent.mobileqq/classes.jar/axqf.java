import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class axqf
  extends AnimatorListenerAdapter
{
  public axqf(CameraCaptureButtonLayout paramCameraCaptureButtonLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "scaleAnimator cancel!");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "scaleAnimator end, shortVideoShot:" + this.a.a.get() + ", mActionUpAnimator:" + this.a.b.get());
    }
    if (!this.a.b.get())
    {
      this.a.a.set(true);
      CameraCaptureButtonLayout.a(this.a).sendEmptyMessage(2);
      CameraCaptureButtonLayout.a(this.a, System.currentTimeMillis());
      CameraCaptureButtonLayout.a(this.a).sendEmptyMessage(5);
    }
    for (;;)
    {
      this.a.b.set(false);
      return;
      CameraCaptureButtonLayout.a(this.a).setVisibility(8);
      CameraCaptureButtonLayout.a(this.a);
      CameraCaptureButtonLayout.a(this.a, 1.0F);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "scaleAnimator start!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axqf
 * JD-Core Version:    0.7.0.1
 */