import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bmmr
  extends AnimatorListenerAdapter
{
  bmmr(bmmn parambmmn) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    wsv.b(bmmk.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    wsv.b(bmmk.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.a.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    wsv.b(bmmk.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmr
 * JD-Core Version:    0.7.0.1
 */