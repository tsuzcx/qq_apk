import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.HintDrawable;

public class anoc
  implements Animator.AnimatorListener
{
  public anoc(HintDrawable paramHintDrawable) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!HintDrawable.a(this.a)) {
      return;
    }
    if (!HintDrawable.b(this.a))
    {
      HintDrawable.a(this.a, false);
      if (HintDrawable.b(this.a) == 1)
      {
        HintDrawable.a(this.a, 3);
        return;
      }
      HintDrawable.a(this.a, 0);
      HintDrawable.a(this.a, "");
      return;
    }
    if (HintDrawable.b(this.a) == 1)
    {
      HintDrawable.a(this.a, 2);
      HintDrawable.a(this.a, HintDrawable.b(this.a), 1000);
      return;
    }
    HintDrawable.a(this.a, "");
    HintDrawable.a(this.a, 0);
    HintDrawable.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!HintDrawable.a(this.a)) {
      return;
    }
    if (!HintDrawable.b(this.a))
    {
      HintDrawable.a(this.a, false);
      if (HintDrawable.b(this.a) == 1)
      {
        HintDrawable.a(this.a, 3);
        return;
      }
      HintDrawable.a(this.a, 0);
      HintDrawable.a(this.a, "");
      return;
    }
    if (HintDrawable.b(this.a) == 1)
    {
      HintDrawable.a(this.a, 2);
      HintDrawable.a(this.a, HintDrawable.b(this.a), 1000);
      return;
    }
    HintDrawable.a(this.a, "");
    HintDrawable.a(this.a, 0);
    HintDrawable.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anoc
 * JD-Core Version:    0.7.0.1
 */