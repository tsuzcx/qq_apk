import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bovx
  extends AnimatorListenerAdapter
{
  bovx(bovv parambovv) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ykq.b(bovr.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ykq.b(bovr.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.b.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ykq.b(bovr.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bovx
 * JD-Core Version:    0.7.0.1
 */