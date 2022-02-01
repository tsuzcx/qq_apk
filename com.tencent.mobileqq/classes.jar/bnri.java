import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class bnri
  implements Animator.AnimatorListener
{
  bnri(bnrd parambnrd) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationCancel: mState:" + bnrd.c(this.a) + " isrun:" + bnrd.a(this.a));
    }
    if (this.a.isRunning())
    {
      bnrd.e(this.a, bnrd.c(this.a));
      if (bnrd.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bnrd.a(this.a, false);
      return;
      label105:
      if (bnrd.c(this.a) == 4) {
        this.a.a(5);
      } else if (bnrd.c(this.a) == 5) {
        this.a.a(1);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationEnd: mState:" + bnrd.c(this.a) + " isrun:" + bnrd.a(this.a));
    }
    if (this.a.isRunning())
    {
      bnrd.d(this.a, bnrd.c(this.a));
      if (bnrd.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bnrd.a(this.a, false);
      return;
      label105:
      if (bnrd.c(this.a) == 4)
      {
        this.a.a(0);
      }
      else if (bnrd.c(this.a) == 5)
      {
        this.a.a(1);
        bnrd.a(this.a, 0);
      }
      else if (bnrd.c(this.a) == 6)
      {
        this.a.a(2);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationStart: mState:" + bnrd.c(this.a) + " isrun:" + bnrd.a(this.a));
    }
    if (this.a.isRunning()) {
      bnrd.c(this.a, bnrd.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnri
 * JD-Core Version:    0.7.0.1
 */