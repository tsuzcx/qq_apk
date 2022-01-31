import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class bkob
  implements Animator.AnimatorListener
{
  bkob(bknw parambknw) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationCancel: mState:" + bknw.c(this.a) + " isrun:" + bknw.a(this.a));
    }
    if (this.a.isRunning())
    {
      bknw.e(this.a, bknw.c(this.a));
      if (bknw.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bknw.a(this.a, false);
      return;
      label105:
      if (bknw.c(this.a) == 4) {
        this.a.a(5);
      } else if (bknw.c(this.a) == 5) {
        this.a.a(1);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationEnd: mState:" + bknw.c(this.a) + " isrun:" + bknw.a(this.a));
    }
    if (this.a.isRunning())
    {
      bknw.d(this.a, bknw.c(this.a));
      if (bknw.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bknw.a(this.a, false);
      return;
      label105:
      if (bknw.c(this.a) == 4)
      {
        this.a.a(0);
      }
      else if (bknw.c(this.a) == 5)
      {
        this.a.a(1);
        bknw.a(this.a, 0);
      }
      else if (bknw.c(this.a) == 6)
      {
        this.a.a(2);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationStart: mState:" + bknw.c(this.a) + " isrun:" + bknw.a(this.a));
    }
    if (this.a.isRunning()) {
      bknw.c(this.a, bknw.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkob
 * JD-Core Version:    0.7.0.1
 */