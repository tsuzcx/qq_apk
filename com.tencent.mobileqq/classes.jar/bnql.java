import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bnql
  implements Animator.AnimatorListener
{
  bnql(bnqi parambnqi) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bnqi.a(this.a)) {}
    do
    {
      return;
      if (bnqi.b(this.a)) {
        break;
      }
      bnqi.a(this.a, false);
    } while (bnqi.b(this.a) != 2);
    bnqi.a(this.a, 0);
    return;
    bnqi.a(this.a, false);
    bnqi.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bnqi.a(this.a)) {
      return;
    }
    if (!bnqi.b(this.a))
    {
      bnqi.a(this.a, false);
      if (bnqi.b(this.a) == 1)
      {
        bnqi.a(this.a, 3);
        return;
      }
      bnqi.a(this.a, 0);
      return;
    }
    if (bnqi.b(this.a) == 1)
    {
      bnqi.a(this.a, 2);
      bnqi.a(this.a, bnqi.b(this.a), 1000);
      return;
    }
    bnqi.a(this.a, false);
    bnqi.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnql
 * JD-Core Version:    0.7.0.1
 */