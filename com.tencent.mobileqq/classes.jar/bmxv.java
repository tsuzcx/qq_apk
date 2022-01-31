import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bmxv
  implements Animator.AnimatorListener
{
  bmxv(bmxt parambmxt) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (bmxt.a(this.a) != null) {
      bmxt.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxv
 * JD-Core Version:    0.7.0.1
 */