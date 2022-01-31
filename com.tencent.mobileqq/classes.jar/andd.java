import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class andd
  implements Animator.AnimatorListener
{
  andd(andc paramandc) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (andc.a(this.a) != null) {
      andc.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andd
 * JD-Core Version:    0.7.0.1
 */