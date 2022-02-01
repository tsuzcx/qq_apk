import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class apqe
  implements Animator.AnimatorListener
{
  apqe(apqd paramapqd) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (apqd.a(this.a) != null) {
      apqd.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqe
 * JD-Core Version:    0.7.0.1
 */