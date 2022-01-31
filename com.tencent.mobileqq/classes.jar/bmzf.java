import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bmzf
  implements Animator.AnimatorListener
{
  bmzf(bmzb parambmzb) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bmzb.a(this.a)) {
      return;
    }
    if (!bmzb.b(this.a))
    {
      bmzb.a(this.a, false);
      if (bmzb.b(this.a) == 1)
      {
        bmzb.a(this.a, 3);
        return;
      }
      bmzb.a(this.a, 0);
      bmzb.a(this.a, "");
      return;
    }
    if (bmzb.b(this.a) == 1)
    {
      bmzb.a(this.a, 2);
      bmzb.a(this.a, bmzb.b(this.a), 1000);
      return;
    }
    bmzb.a(this.a, "");
    bmzb.a(this.a, 0);
    bmzb.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bmzb.a(this.a)) {
      return;
    }
    if (!bmzb.b(this.a))
    {
      bmzb.a(this.a, false);
      if (bmzb.b(this.a) == 1)
      {
        bmzb.a(this.a, 3);
        return;
      }
      bmzb.a(this.a, 0);
      bmzb.a(this.a, "");
      return;
    }
    if (bmzb.b(this.a) == 1)
    {
      bmzb.a(this.a, 2);
      bmzb.a(this.a, bmzb.b(this.a), 1000);
      return;
    }
    bmzb.a(this.a, "");
    bmzb.a(this.a, 0);
    bmzb.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzf
 * JD-Core Version:    0.7.0.1
 */