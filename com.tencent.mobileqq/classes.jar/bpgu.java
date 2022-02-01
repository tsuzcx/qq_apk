import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bpgu
  implements Animator.AnimatorListener
{
  bpgu(bpgq parambpgq) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bpgq.a(this.a)) {
      return;
    }
    if (!bpgq.b(this.a))
    {
      bpgq.a(this.a, false);
      if (bpgq.b(this.a) == 1)
      {
        bpgq.a(this.a, 3);
        return;
      }
      bpgq.a(this.a, 0);
      bpgq.a(this.a, "");
      return;
    }
    if (bpgq.b(this.a) == 1)
    {
      bpgq.a(this.a, 2);
      bpgq.a(this.a, bpgq.b(this.a), 1000);
      return;
    }
    bpgq.a(this.a, "");
    bpgq.a(this.a, 0);
    bpgq.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bpgq.a(this.a)) {
      return;
    }
    if (!bpgq.b(this.a))
    {
      bpgq.a(this.a, false);
      if (bpgq.b(this.a) == 1)
      {
        bpgq.a(this.a, 3);
        return;
      }
      bpgq.a(this.a, 0);
      bpgq.a(this.a, "");
      return;
    }
    if (bpgq.b(this.a) == 1)
    {
      bpgq.a(this.a, 2);
      bpgq.a(this.a, bpgq.b(this.a), 1000);
      return;
    }
    bpgq.a(this.a, "");
    bpgq.a(this.a, 0);
    bpgq.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgu
 * JD-Core Version:    0.7.0.1
 */