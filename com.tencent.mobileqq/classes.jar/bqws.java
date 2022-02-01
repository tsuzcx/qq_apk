import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bqws
  implements Animator.AnimatorListener
{
  bqws(bqwo parambqwo) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bqwo.a(this.a)) {
      return;
    }
    if (!bqwo.b(this.a))
    {
      bqwo.a(this.a, false);
      if (bqwo.b(this.a) == 1)
      {
        bqwo.a(this.a, 3);
        return;
      }
      bqwo.a(this.a, 0);
      bqwo.a(this.a, "");
      return;
    }
    if (bqwo.b(this.a) == 1)
    {
      bqwo.a(this.a, 2);
      bqwo.a(this.a, bqwo.b(this.a), 1000);
      return;
    }
    bqwo.a(this.a, "");
    bqwo.a(this.a, 0);
    bqwo.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bqwo.a(this.a)) {
      return;
    }
    if (!bqwo.b(this.a))
    {
      bqwo.a(this.a, false);
      if (bqwo.b(this.a) == 1)
      {
        bqwo.a(this.a, 3);
        return;
      }
      bqwo.a(this.a, 0);
      bqwo.a(this.a, "");
      return;
    }
    if (bqwo.b(this.a) == 1)
    {
      bqwo.a(this.a, 2);
      bqwo.a(this.a, bqwo.b(this.a), 1000);
      return;
    }
    bqwo.a(this.a, "");
    bqwo.a(this.a, 0);
    bqwo.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqws
 * JD-Core Version:    0.7.0.1
 */