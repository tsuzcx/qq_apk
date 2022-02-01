import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView;

public class booi
  implements Animator.AnimatorListener
{
  public booi(AEProviderContainerView paramAEProviderContainerView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEProviderContainerView", 2, "panel opened");
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     booi
 * JD-Core Version:    0.7.0.1
 */