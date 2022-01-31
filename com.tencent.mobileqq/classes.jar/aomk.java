import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.ContainerDrawable;

public class aomk
  implements Animator.AnimatorListener
{
  public aomk(ContainerDrawable paramContainerDrawable) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!ContainerDrawable.a(this.a)) {}
    do
    {
      return;
      if (ContainerDrawable.b(this.a)) {
        break;
      }
      ContainerDrawable.a(this.a, false);
    } while (ContainerDrawable.b(this.a) != 2);
    ContainerDrawable.a(this.a, 0);
    return;
    ContainerDrawable.a(this.a, false);
    ContainerDrawable.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!ContainerDrawable.a(this.a)) {
      return;
    }
    if (!ContainerDrawable.b(this.a))
    {
      ContainerDrawable.a(this.a, false);
      if (ContainerDrawable.b(this.a) == 1)
      {
        ContainerDrawable.a(this.a, 3);
        return;
      }
      ContainerDrawable.a(this.a, 0);
      return;
    }
    if (ContainerDrawable.b(this.a) == 1)
    {
      ContainerDrawable.a(this.a, 2);
      ContainerDrawable.a(this.a, ContainerDrawable.b(this.a), 1000);
      return;
    }
    ContainerDrawable.a(this.a, false);
    ContainerDrawable.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aomk
 * JD-Core Version:    0.7.0.1
 */