import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bphs
  extends AnimatorListenerAdapter
{
  bphs(bphq parambphq) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    yqp.b(bphm.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    yqp.b(bphm.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.b.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    yqp.b(bphm.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bphs
 * JD-Core Version:    0.7.0.1
 */