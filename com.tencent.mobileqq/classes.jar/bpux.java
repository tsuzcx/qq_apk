import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bpux
  implements Animator.AnimatorListener
{
  bpux(bput parambput) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bput.a(this.a)) {
      return;
    }
    if (!bput.b(this.a))
    {
      bput.a(this.a, false);
      if (bput.b(this.a) == 1)
      {
        bput.a(this.a, 3);
        return;
      }
      bput.a(this.a, 0);
      bput.a(this.a, "");
      return;
    }
    if (bput.b(this.a) == 1)
    {
      bput.a(this.a, 2);
      bput.a(this.a, bput.b(this.a), 1000);
      return;
    }
    bput.a(this.a, "");
    bput.a(this.a, 0);
    bput.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bput.a(this.a)) {
      return;
    }
    if (!bput.b(this.a))
    {
      bput.a(this.a, false);
      if (bput.b(this.a) == 1)
      {
        bput.a(this.a, 3);
        return;
      }
      bput.a(this.a, 0);
      bput.a(this.a, "");
      return;
    }
    if (bput.b(this.a) == 1)
    {
      bput.a(this.a, 2);
      bput.a(this.a, bput.b(this.a), 1000);
      return;
    }
    bput.a(this.a, "");
    bput.a(this.a, 0);
    bput.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpux
 * JD-Core Version:    0.7.0.1
 */