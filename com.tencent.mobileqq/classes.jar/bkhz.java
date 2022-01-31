import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bkhz
  implements Animator.AnimatorListener
{
  bkhz(bkhx parambkhx) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (bkhx.a(this.a) != null) {
      bkhx.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkhz
 * JD-Core Version:    0.7.0.1
 */