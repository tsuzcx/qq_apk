import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bkhi
  implements Animator.AnimatorListener
{
  bkhi(bkhg parambkhg) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (bkhg.a(this.a) != null) {
      bkhg.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkhi
 * JD-Core Version:    0.7.0.1
 */