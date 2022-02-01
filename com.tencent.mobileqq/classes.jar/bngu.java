import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bngu
  extends AnimatorListenerAdapter
{
  bngu(bngq parambngq) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    xvv.b(bngn.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    xvv.b(bngn.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.a.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    xvv.b(bngn.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngu
 * JD-Core Version:    0.7.0.1
 */