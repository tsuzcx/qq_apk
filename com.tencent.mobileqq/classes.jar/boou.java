import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCircleProgress;

public class boou
  extends AnimatorListenerAdapter
{
  public boou(QIMCircleProgress paramQIMCircleProgress) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.b = false;
    if (QLog.isColorLevel()) {
      QLog.d("QIMCircleProgress", 2, "[segmentCapture] nextSegmentBlinkAnimator cancel");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b = false;
    if (QLog.isColorLevel()) {
      QLog.d("QIMCircleProgress", 2, "[segmentCapture] nextSegmentBlinkAnimator end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("QIMCircleProgress", 2, "[segmentCapture] nextSegmentBlinkAnimator start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boou
 * JD-Core Version:    0.7.0.1
 */