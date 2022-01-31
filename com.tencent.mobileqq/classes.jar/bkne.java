import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bkne
  implements Animator.AnimatorListener
{
  bkne(bknb parambknb) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bknb.a(this.a)) {}
    do
    {
      return;
      if (bknb.b(this.a)) {
        break;
      }
      bknb.a(this.a, false);
    } while (bknb.b(this.a) != 2);
    bknb.a(this.a, 0);
    return;
    bknb.a(this.a, false);
    bknb.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bknb.a(this.a)) {
      return;
    }
    if (!bknb.b(this.a))
    {
      bknb.a(this.a, false);
      if (bknb.b(this.a) == 1)
      {
        bknb.a(this.a, 3);
        return;
      }
      bknb.a(this.a, 0);
      return;
    }
    if (bknb.b(this.a) == 1)
    {
      bknb.a(this.a, 2);
      bknb.a(this.a, bknb.b(this.a), 1000);
      return;
    }
    bknb.a(this.a, false);
    bknb.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkne
 * JD-Core Version:    0.7.0.1
 */