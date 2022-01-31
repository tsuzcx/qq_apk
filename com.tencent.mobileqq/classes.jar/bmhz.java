import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bmhz
  implements Animator.AnimatorListener
{
  bmhz(bmhu parambmhu) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bmhu.b(this.a, this.a.d);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhz
 * JD-Core Version:    0.7.0.1
 */