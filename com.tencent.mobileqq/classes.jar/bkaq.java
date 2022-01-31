import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bkaq
  extends AnimatorListenerAdapter
{
  bkaq(bkao parambkao) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ved.b(bkak.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ved.b(bkak.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.b.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ved.b(bkak.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkaq
 * JD-Core Version:    0.7.0.1
 */