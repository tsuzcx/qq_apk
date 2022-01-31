import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bije
  extends AnimatorListenerAdapter
{
  bije(bijc parambijc) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    urk.b(biiy.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    urk.b(biiy.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.b.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    urk.b(biiy.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bije
 * JD-Core Version:    0.7.0.1
 */