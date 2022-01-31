import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.WindowManager;

class beoa
  implements Animator.AnimatorListener
{
  beoa(benw parambenw) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (benw.a(this.a) != null)
    {
      benw.a(this.a).removeViewImmediate(benw.a(this.a));
      benw.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beoa
 * JD-Core Version:    0.7.0.1
 */