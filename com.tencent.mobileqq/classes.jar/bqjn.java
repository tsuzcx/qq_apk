import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bqjn
  extends AnimatorListenerAdapter
{
  bqjn(bqjl parambqjl) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    yuk.b(bqjh.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    yuk.b(bqjh.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.b.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    yuk.b(bqjh.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqjn
 * JD-Core Version:    0.7.0.1
 */