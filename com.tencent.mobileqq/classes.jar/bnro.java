import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.ae.view.AECMShowFaceScanView;

public class bnro
  implements Animator.AnimatorListener
{
  public bnro(AECMShowFaceScanView paramAECMShowFaceScanView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECMShowFaceScanView.b(this.a, false);
    if (this.a.a != null) {
      this.a.a.F();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECMShowFaceScanView.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnro
 * JD-Core Version:    0.7.0.1
 */