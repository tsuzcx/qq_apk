import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class aqtg
  implements Animator.AnimatorListener
{
  aqtg(aqsy paramaqsy) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (aqsy.a(this.a) != null) {
      aqsy.a(this.a).b();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtg
 * JD-Core Version:    0.7.0.1
 */