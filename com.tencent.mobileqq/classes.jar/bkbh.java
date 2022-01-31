import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bkbh
  extends AnimatorListenerAdapter
{
  bkbh(bkbd parambkbd) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ved.b(bkba.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ved.b(bkba.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.a.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ved.b(bkba.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkbh
 * JD-Core Version:    0.7.0.1
 */