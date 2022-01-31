import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bnda
  implements Animator.AnimatorListener
{
  bnda(bncx parambncx) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bncx.a(this.a)) {}
    do
    {
      return;
      if (bncx.b(this.a)) {
        break;
      }
      bncx.a(this.a, false);
    } while (bncx.b(this.a) != 2);
    bncx.a(this.a, 0);
    return;
    bncx.a(this.a, false);
    bncx.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bncx.a(this.a)) {
      return;
    }
    if (!bncx.b(this.a))
    {
      bncx.a(this.a, false);
      if (bncx.b(this.a) == 1)
      {
        bncx.a(this.a, 3);
        return;
      }
      bncx.a(this.a, 0);
      return;
    }
    if (bncx.b(this.a) == 1)
    {
      bncx.a(this.a, 2);
      bncx.a(this.a, bncx.b(this.a), 1000);
      return;
    }
    bncx.a(this.a, false);
    bncx.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnda
 * JD-Core Version:    0.7.0.1
 */