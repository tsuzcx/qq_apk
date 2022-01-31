import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class anhm
  implements Animator.AnimatorListener
{
  anhm(anhl paramanhl) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (anhl.a(this.a) != null) {
      anhl.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhm
 * JD-Core Version:    0.7.0.1
 */