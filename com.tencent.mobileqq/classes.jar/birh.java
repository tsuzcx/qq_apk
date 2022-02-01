import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.WindowManager;

class birh
  implements Animator.AnimatorListener
{
  birh(bird parambird) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (bird.a(this.a) != null)
    {
      bird.a(this.a).removeViewImmediate(bird.a(this.a));
      bird.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     birh
 * JD-Core Version:    0.7.0.1
 */