import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bpgd
  implements Animator.AnimatorListener
{
  bpgd(bpga parambpga) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bpga.a(this.a)) {}
    do
    {
      return;
      if (bpga.b(this.a)) {
        break;
      }
      bpga.a(this.a, false);
    } while (bpga.b(this.a) != 2);
    bpga.a(this.a, 0);
    return;
    bpga.a(this.a, false);
    bpga.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bpga.a(this.a)) {
      return;
    }
    if (!bpga.b(this.a))
    {
      bpga.a(this.a, false);
      if (bpga.b(this.a) == 1)
      {
        bpga.a(this.a, 3);
        return;
      }
      bpga.a(this.a, 0);
      return;
    }
    if (bpga.b(this.a) == 1)
    {
      bpga.a(this.a, 2);
      bpga.a(this.a, bpga.b(this.a), 1000);
      return;
    }
    bpga.a(this.a, false);
    bpga.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgd
 * JD-Core Version:    0.7.0.1
 */