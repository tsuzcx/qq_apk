import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;

public class bexl
  implements Animator.AnimatorListener
{
  public bexl(FloatingScreenContainer paramFloatingScreenContainer) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    FloatingScreenContainer.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FloatingScreenContainer.a(this.a).removeAllListeners();
    if (FloatingScreenContainer.a(this.a) != null) {
      FloatingScreenContainer.a(this.a).b();
    }
    FloatingScreenContainer.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    FloatingScreenContainer.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (FloatingScreenContainer.a(this.a) != null) {
      FloatingScreenContainer.a(this.a).a();
    }
    FloatingScreenContainer.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bexl
 * JD-Core Version:    0.7.0.1
 */