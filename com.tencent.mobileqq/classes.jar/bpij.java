import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bpij
  extends AnimatorListenerAdapter
{
  bpij(bpif parambpif) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    yqp.b(bpic.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    yqp.b(bpic.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.a.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    yqp.b(bpic.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpij
 * JD-Core Version:    0.7.0.1
 */