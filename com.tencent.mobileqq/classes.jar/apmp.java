import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class apmp
  implements Animator.AnimatorListener
{
  apmp(apmh paramapmh) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (apmh.a(this.a) != null) {
      apmh.a(this.a).b();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmp
 * JD-Core Version:    0.7.0.1
 */