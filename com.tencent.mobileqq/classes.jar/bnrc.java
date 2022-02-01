import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bnrc
  implements Animator.AnimatorListener
{
  bnrc(bnqy parambnqy) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bnqy.a(this.a)) {
      return;
    }
    if (!bnqy.b(this.a))
    {
      bnqy.a(this.a, false);
      if (bnqy.b(this.a) == 1)
      {
        bnqy.a(this.a, 3);
        return;
      }
      bnqy.a(this.a, 0);
      bnqy.a(this.a, "");
      return;
    }
    if (bnqy.b(this.a) == 1)
    {
      bnqy.a(this.a, 2);
      bnqy.a(this.a, bnqy.b(this.a), 1000);
      return;
    }
    bnqy.a(this.a, "");
    bnqy.a(this.a, 0);
    bnqy.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bnqy.a(this.a)) {
      return;
    }
    if (!bnqy.b(this.a))
    {
      bnqy.a(this.a, false);
      if (bnqy.b(this.a) == 1)
      {
        bnqy.a(this.a, 3);
        return;
      }
      bnqy.a(this.a, 0);
      bnqy.a(this.a, "");
      return;
    }
    if (bnqy.b(this.a) == 1)
    {
      bnqy.a(this.a, 2);
      bnqy.a(this.a, bnqy.b(this.a), 1000);
      return;
    }
    bnqy.a(this.a, "");
    bnqy.a(this.a, 0);
    bnqy.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrc
 * JD-Core Version:    0.7.0.1
 */