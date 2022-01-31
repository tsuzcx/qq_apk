import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bkne
  implements Animator.AnimatorListener
{
  bkne(bkna parambkna) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bkna.a(this.a)) {
      return;
    }
    if (!bkna.b(this.a))
    {
      bkna.a(this.a, false);
      if (bkna.b(this.a) == 1)
      {
        bkna.a(this.a, 3);
        return;
      }
      bkna.a(this.a, 0);
      bkna.a(this.a, "");
      return;
    }
    if (bkna.b(this.a) == 1)
    {
      bkna.a(this.a, 2);
      bkna.a(this.a, bkna.b(this.a), 1000);
      return;
    }
    bkna.a(this.a, "");
    bkna.a(this.a, 0);
    bkna.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bkna.a(this.a)) {
      return;
    }
    if (!bkna.b(this.a))
    {
      bkna.a(this.a, false);
      if (bkna.b(this.a) == 1)
      {
        bkna.a(this.a, 3);
        return;
      }
      bkna.a(this.a, 0);
      bkna.a(this.a, "");
      return;
    }
    if (bkna.b(this.a) == 1)
    {
      bkna.a(this.a, 2);
      bkna.a(this.a, bkna.b(this.a), 1000);
      return;
    }
    bkna.a(this.a, "");
    bkna.a(this.a, 0);
    bkna.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkne
 * JD-Core Version:    0.7.0.1
 */