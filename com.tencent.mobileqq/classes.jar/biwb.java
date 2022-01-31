import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class biwb
  implements Animator.AnimatorListener
{
  biwb(bivy parambivy) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bivy.a(this.a)) {}
    do
    {
      return;
      if (bivy.b(this.a)) {
        break;
      }
      bivy.a(this.a, false);
    } while (bivy.b(this.a) != 2);
    bivy.a(this.a, 0);
    return;
    bivy.a(this.a, false);
    bivy.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bivy.a(this.a)) {
      return;
    }
    if (!bivy.b(this.a))
    {
      bivy.a(this.a, false);
      if (bivy.b(this.a) == 1)
      {
        bivy.a(this.a, 3);
        return;
      }
      bivy.a(this.a, 0);
      return;
    }
    if (bivy.b(this.a) == 1)
    {
      bivy.a(this.a, 2);
      bivy.a(this.a, bivy.b(this.a), 1000);
      return;
    }
    bivy.a(this.a, false);
    bivy.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwb
 * JD-Core Version:    0.7.0.1
 */