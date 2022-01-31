import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;

public class bkwq
  implements Animator.AnimatorListener
{
  public bkwq(QIMCameraCaptureButtonLayout paramQIMCameraCaptureButtonLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QIMCameraCaptureButtonLayout.a(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkwq
 * JD-Core Version:    0.7.0.1
 */