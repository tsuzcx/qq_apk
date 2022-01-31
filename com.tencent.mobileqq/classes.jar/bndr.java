import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bndr
  implements Animator.AnimatorListener
{
  bndr(bndn parambndn) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bndn.a(this.a)) {
      return;
    }
    if (!bndn.b(this.a))
    {
      bndn.a(this.a, false);
      if (bndn.b(this.a) == 1)
      {
        bndn.a(this.a, 3);
        return;
      }
      bndn.a(this.a, 0);
      bndn.a(this.a, "");
      return;
    }
    if (bndn.b(this.a) == 1)
    {
      bndn.a(this.a, 2);
      bndn.a(this.a, bndn.b(this.a), 1000);
      return;
    }
    bndn.a(this.a, "");
    bndn.a(this.a, 0);
    bndn.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bndn.a(this.a)) {
      return;
    }
    if (!bndn.b(this.a))
    {
      bndn.a(this.a, false);
      if (bndn.b(this.a) == 1)
      {
        bndn.a(this.a, 3);
        return;
      }
      bndn.a(this.a, 0);
      bndn.a(this.a, "");
      return;
    }
    if (bndn.b(this.a) == 1)
    {
      bndn.a(this.a, 2);
      bndn.a(this.a, bndn.b(this.a), 1000);
      return;
    }
    bndn.a(this.a, "");
    bndn.a(this.a, 0);
    bndn.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndr
 * JD-Core Version:    0.7.0.1
 */