import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

public class anps
  implements Animator.AnimatorListener
{
  public anps(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.c.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anps
 * JD-Core Version:    0.7.0.1
 */