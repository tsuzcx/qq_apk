import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.WindowManager;

class bjao
  implements Animator.AnimatorListener
{
  bjao(bjak parambjak) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (bjak.a(this.a) != null)
    {
      bjak.a(this.a).removeViewImmediate(bjak.a(this.a));
      bjak.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjao
 * JD-Core Version:    0.7.0.1
 */