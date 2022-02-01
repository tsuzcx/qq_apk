import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bngf
  extends AnimatorListenerAdapter
{
  bngf(bngd parambngd) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    xvv.b(bnfz.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    xvv.b(bnfz.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.b.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    xvv.b(bnfz.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngf
 * JD-Core Version:    0.7.0.1
 */