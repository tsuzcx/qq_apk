import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class bmyo
  implements Animator.AnimatorListener
{
  bmyo(bmyl parambmyl) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!bmyl.a(this.a)) {}
    do
    {
      return;
      if (bmyl.b(this.a)) {
        break;
      }
      bmyl.a(this.a, false);
    } while (bmyl.b(this.a) != 2);
    bmyl.a(this.a, 0);
    return;
    bmyl.a(this.a, false);
    bmyl.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!bmyl.a(this.a)) {
      return;
    }
    if (!bmyl.b(this.a))
    {
      bmyl.a(this.a, false);
      if (bmyl.b(this.a) == 1)
      {
        bmyl.a(this.a, 3);
        return;
      }
      bmyl.a(this.a, 0);
      return;
    }
    if (bmyl.b(this.a) == 1)
    {
      bmyl.a(this.a, 2);
      bmyl.a(this.a, bmyl.b(this.a), 1000);
      return;
    }
    bmyl.a(this.a, false);
    bmyl.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyo
 * JD-Core Version:    0.7.0.1
 */