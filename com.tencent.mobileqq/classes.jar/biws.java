import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class biws
  implements Animator.AnimatorListener
{
  biws(biwo parambiwo) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!biwo.a(this.a)) {
      return;
    }
    if (!biwo.b(this.a))
    {
      biwo.a(this.a, false);
      if (biwo.b(this.a) == 1)
      {
        biwo.a(this.a, 3);
        return;
      }
      biwo.a(this.a, 0);
      biwo.a(this.a, "");
      return;
    }
    if (biwo.b(this.a) == 1)
    {
      biwo.a(this.a, 2);
      biwo.a(this.a, biwo.b(this.a), 1000);
      return;
    }
    biwo.a(this.a, "");
    biwo.a(this.a, 0);
    biwo.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!biwo.a(this.a)) {
      return;
    }
    if (!biwo.b(this.a))
    {
      biwo.a(this.a, false);
      if (biwo.b(this.a) == 1)
      {
        biwo.a(this.a, 3);
        return;
      }
      biwo.a(this.a, 0);
      biwo.a(this.a, "");
      return;
    }
    if (biwo.b(this.a) == 1)
    {
      biwo.a(this.a, 2);
      biwo.a(this.a, biwo.b(this.a), 1000);
      return;
    }
    biwo.a(this.a, "");
    biwo.a(this.a, 0);
    biwo.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biws
 * JD-Core Version:    0.7.0.1
 */