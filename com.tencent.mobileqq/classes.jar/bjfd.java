import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;

public class bjfd
  implements Animator.AnimatorListener
{
  public bjfd(FloatingScreenContainer paramFloatingScreenContainer) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator.removeAllListeners();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjfd
 * JD-Core Version:    0.7.0.1
 */