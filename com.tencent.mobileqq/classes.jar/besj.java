import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.WindowManager;

class besj
  implements Animator.AnimatorListener
{
  besj(besf parambesf) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (besf.a(this.a) != null)
    {
      besf.a(this.a).removeViewImmediate(besf.a(this.a));
      besf.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besj
 * JD-Core Version:    0.7.0.1
 */