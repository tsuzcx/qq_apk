import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bpug
  implements Animator.AnimatorListener
{
  bpug(bpud parambpud) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bpud.a(this.a)) {}
    do
    {
      return;
      if (bpud.b(this.a)) {
        break;
      }
      bpud.a(this.a, false);
    } while (bpud.b(this.a) != 2);
    bpud.a(this.a, 0);
    return;
    bpud.a(this.a, false);
    bpud.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bpud.a(this.a)) {
      return;
    }
    if (!bpud.b(this.a))
    {
      bpud.a(this.a, false);
      if (bpud.b(this.a) == 1)
      {
        bpud.a(this.a, 3);
        return;
      }
      bpud.a(this.a, 0);
      return;
    }
    if (bpud.b(this.a) == 1)
    {
      bpud.a(this.a, 2);
      bpud.a(this.a, bpud.b(this.a), 1000);
      return;
    }
    bpud.a(this.a, false);
    bpud.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpug
 * JD-Core Version:    0.7.0.1
 */