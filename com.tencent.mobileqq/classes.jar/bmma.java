import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bmma
  extends AnimatorListenerAdapter
{
  bmma(bmly parambmly) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    wsv.b(bmlu.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    wsv.b(bmlu.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.b.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    wsv.b(bmlu.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmma
 * JD-Core Version:    0.7.0.1
 */