import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bppb
  implements Animator.AnimatorListener
{
  bppb(bpoz parambpoz) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (bpoz.a(this.a) != null) {
      bpoz.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bppb
 * JD-Core Version:    0.7.0.1
 */