import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.WindowManager;

class bcoj
  implements Animator.AnimatorListener
{
  bcoj(bcof parambcof) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (bcof.a(this.a) != null)
    {
      bcof.a(this.a).removeViewImmediate(bcof.a(this.a));
      bcof.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcoj
 * JD-Core Version:    0.7.0.1
 */