import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bqwb
  implements Animator.AnimatorListener
{
  bqwb(bqvy parambqvy) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bqvy.a(this.a)) {}
    do
    {
      return;
      if (bqvy.b(this.a)) {
        break;
      }
      bqvy.a(this.a, false);
    } while (bqvy.b(this.a) != 2);
    bqvy.a(this.a, 0);
    return;
    bqvy.a(this.a, false);
    bqvy.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bqvy.a(this.a)) {
      return;
    }
    if (!bqvy.b(this.a))
    {
      bqvy.a(this.a, false);
      if (bqvy.b(this.a) == 1)
      {
        bqvy.a(this.a, 3);
        return;
      }
      bqvy.a(this.a, 0);
      return;
    }
    if (bqvy.b(this.a) == 1)
    {
      bqvy.a(this.a, 2);
      bqvy.a(this.a, bqvy.b(this.a), 1000);
      return;
    }
    bqvy.a(this.a, false);
    bqvy.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqwb
 * JD-Core Version:    0.7.0.1
 */