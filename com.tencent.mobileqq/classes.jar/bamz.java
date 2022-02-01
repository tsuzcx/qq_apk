import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.qassistant.view.VoicePanelSlideContainer;

public class bamz
  implements Animator.AnimatorListener
{
  public bamz(VoicePanelSlideContainer paramVoicePanelSlideContainer) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    VoicePanelSlideContainer.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VoicePanelSlideContainer.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamz
 * JD-Core Version:    0.7.0.1
 */