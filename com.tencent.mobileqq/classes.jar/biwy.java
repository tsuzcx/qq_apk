import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class biwy
  implements Animator.AnimatorListener
{
  biwy(biwt parambiwt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationCancel: mState:" + biwt.c(this.a) + " isrun:" + biwt.a(this.a));
    }
    if (this.a.isRunning())
    {
      biwt.e(this.a, biwt.c(this.a));
      if (biwt.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      biwt.a(this.a, false);
      return;
      label105:
      if (biwt.c(this.a) == 4) {
        this.a.a(5);
      } else if (biwt.c(this.a) == 5) {
        this.a.a(1);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationEnd: mState:" + biwt.c(this.a) + " isrun:" + biwt.a(this.a));
    }
    if (this.a.isRunning())
    {
      biwt.d(this.a, biwt.c(this.a));
      if (biwt.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      biwt.a(this.a, false);
      return;
      label105:
      if (biwt.c(this.a) == 4)
      {
        this.a.a(0);
      }
      else if (biwt.c(this.a) == 5)
      {
        this.a.a(1);
        biwt.a(this.a, 0);
      }
      else if (biwt.c(this.a) == 6)
      {
        this.a.a(2);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationStart: mState:" + biwt.c(this.a) + " isrun:" + biwt.a(this.a));
    }
    if (this.a.isRunning()) {
      biwt.c(this.a, biwt.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwy
 * JD-Core Version:    0.7.0.1
 */