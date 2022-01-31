import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bkmn
  implements Animator.AnimatorListener
{
  bkmn(bkmk parambkmk) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bkmk.a(this.a)) {}
    do
    {
      return;
      if (bkmk.b(this.a)) {
        break;
      }
      bkmk.a(this.a, false);
    } while (bkmk.b(this.a) != 2);
    bkmk.a(this.a, 0);
    return;
    bkmk.a(this.a, false);
    bkmk.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bkmk.a(this.a)) {
      return;
    }
    if (!bkmk.b(this.a))
    {
      bkmk.a(this.a, false);
      if (bkmk.b(this.a) == 1)
      {
        bkmk.a(this.a, 3);
        return;
      }
      bkmk.a(this.a, 0);
      return;
    }
    if (bkmk.b(this.a) == 1)
    {
      bkmk.a(this.a, 2);
      bkmk.a(this.a, bkmk.b(this.a), 1000);
      return;
    }
    bkmk.a(this.a, false);
    bkmk.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkmn
 * JD-Core Version:    0.7.0.1
 */