import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.WindowManager;

class bhgp
  implements Animator.AnimatorListener
{
  bhgp(bhgl parambhgl) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (bhgl.a(this.a) != null)
    {
      bhgl.a(this.a).removeViewImmediate(bhgl.a(this.a));
      bhgl.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhgp
 * JD-Core Version:    0.7.0.1
 */