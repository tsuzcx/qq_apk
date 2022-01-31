import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.WindowManager;

class bcoy
  implements Animator.AnimatorListener
{
  bcoy(bcou parambcou) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (bcou.a(this.a) != null)
    {
      bcou.a(this.a).removeViewImmediate(bcou.a(this.a));
      bcou.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcoy
 * JD-Core Version:    0.7.0.1
 */