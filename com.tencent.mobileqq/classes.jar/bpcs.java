import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bpcs
  implements Animator.AnimatorListener
{
  bpcs(bpcq parambpcq) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (bpcq.a(this.a) != null) {
      bpcq.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpcs
 * JD-Core Version:    0.7.0.1
 */