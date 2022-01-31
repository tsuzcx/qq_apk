import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.widget.SlideDownFrameLayout;

public class berd
  implements Animator.AnimatorListener
{
  public berd(SlideDownFrameLayout paramSlideDownFrameLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SlideDownFrameLayout.a(this.a).a();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berd
 * JD-Core Version:    0.7.0.1
 */