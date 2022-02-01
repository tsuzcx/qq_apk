import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;

public class boob
  implements Animator.AnimatorListener
{
  public boob(AEMaterialPanel paramAEMaterialPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    bpam.d("AEMaterialPanel", "[openWithAnimation] translationY - onAnimationCancel");
  }
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boob
 * JD-Core Version:    0.7.0.1
 */