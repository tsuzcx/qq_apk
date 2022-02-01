import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.WindowManager;

class bhzq
  implements Animator.AnimatorListener
{
  bhzq(bhzm parambhzm) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (bhzm.a(this.a) != null)
    {
      bhzm.a(this.a).removeViewImmediate(bhzm.a(this.a));
      bhzm.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhzq
 * JD-Core Version:    0.7.0.1
 */