import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.WindowManager;

class bbll
  implements Animator.AnimatorListener
{
  bbll(bblh parambblh) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (bblh.a(this.a) != null)
    {
      bblh.a(this.a).removeViewImmediate(bblh.a(this.a));
      bblh.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbll
 * JD-Core Version:    0.7.0.1
 */