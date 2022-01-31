import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.MarkDrawable;

public class anoh
  implements Animator.AnimatorListener
{
  public anoh(MarkDrawable paramMarkDrawable) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationCancel: mState:" + MarkDrawable.c(this.a) + " isrun:" + MarkDrawable.a(this.a));
    }
    if (this.a.isRunning())
    {
      MarkDrawable.e(this.a, MarkDrawable.c(this.a));
      if (MarkDrawable.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      MarkDrawable.a(this.a, false);
      return;
      label105:
      if (MarkDrawable.c(this.a) == 4) {
        this.a.a(5);
      } else if (MarkDrawable.c(this.a) == 5) {
        this.a.a(1);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationEnd: mState:" + MarkDrawable.c(this.a) + " isrun:" + MarkDrawable.a(this.a));
    }
    if (this.a.isRunning())
    {
      MarkDrawable.d(this.a, MarkDrawable.c(this.a));
      if (MarkDrawable.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      MarkDrawable.a(this.a, false);
      return;
      label105:
      if (MarkDrawable.c(this.a) == 4)
      {
        this.a.a(0);
      }
      else if (MarkDrawable.c(this.a) == 5)
      {
        this.a.a(1);
        MarkDrawable.a(this.a, 0);
      }
      else if (MarkDrawable.c(this.a) == 6)
      {
        this.a.a(2);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationStart: mState:" + MarkDrawable.c(this.a) + " isrun:" + MarkDrawable.a(this.a));
    }
    if (this.a.isRunning()) {
      MarkDrawable.c(this.a, MarkDrawable.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anoh
 * JD-Core Version:    0.7.0.1
 */