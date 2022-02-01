import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class aqpt
  implements Animator.AnimatorListener
{
  aqpt(aqpl paramaqpl) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (aqpl.a(this.a) != null) {
      aqpl.a(this.a).b();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpt
 * JD-Core Version:    0.7.0.1
 */