import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bijv
  extends AnimatorListenerAdapter
{
  bijv(bijr parambijr) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    urk.b(bijo.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    urk.b(bijo.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.a.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    urk.b(bijo.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bijv
 * JD-Core Version:    0.7.0.1
 */