import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bijb
  implements Animator.AnimatorListener
{
  bijb(biiz parambiiz) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.a = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a = false;
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    this.a.a = true;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bijb
 * JD-Core Version:    0.7.0.1
 */