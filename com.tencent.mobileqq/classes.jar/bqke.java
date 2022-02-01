import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bqke
  extends AnimatorListenerAdapter
{
  bqke(bqka parambqka) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    yuk.b(bqjx.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    yuk.b(bqjx.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.a.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    yuk.b(bqjx.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqke
 * JD-Core Version:    0.7.0.1
 */