import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bknv
  implements Animator.AnimatorListener
{
  bknv(bknr parambknr) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bknr.a(this.a)) {
      return;
    }
    if (!bknr.b(this.a))
    {
      bknr.a(this.a, false);
      if (bknr.b(this.a) == 1)
      {
        bknr.a(this.a, 3);
        return;
      }
      bknr.a(this.a, 0);
      bknr.a(this.a, "");
      return;
    }
    if (bknr.b(this.a) == 1)
    {
      bknr.a(this.a, 2);
      bknr.a(this.a, bknr.b(this.a), 1000);
      return;
    }
    bknr.a(this.a, "");
    bknr.a(this.a, 0);
    bknr.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bknr.a(this.a)) {
      return;
    }
    if (!bknr.b(this.a))
    {
      bknr.a(this.a, false);
      if (bknr.b(this.a) == 1)
      {
        bknr.a(this.a, 3);
        return;
      }
      bknr.a(this.a, 0);
      bknr.a(this.a, "");
      return;
    }
    if (bknr.b(this.a) == 1)
    {
      bknr.a(this.a, 2);
      bknr.a(this.a, bknr.b(this.a), 1000);
      return;
    }
    bknr.a(this.a, "");
    bknr.a(this.a, 0);
    bknr.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknv
 * JD-Core Version:    0.7.0.1
 */