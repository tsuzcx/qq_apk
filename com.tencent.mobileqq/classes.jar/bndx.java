import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class bndx
  implements Animator.AnimatorListener
{
  bndx(bnds parambnds) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationCancel: mState:" + bnds.c(this.a) + " isrun:" + bnds.a(this.a));
    }
    if (this.a.isRunning())
    {
      bnds.e(this.a, bnds.c(this.a));
      if (bnds.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bnds.a(this.a, false);
      return;
      label105:
      if (bnds.c(this.a) == 4) {
        this.a.a(5);
      } else if (bnds.c(this.a) == 5) {
        this.a.a(1);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationEnd: mState:" + bnds.c(this.a) + " isrun:" + bnds.a(this.a));
    }
    if (this.a.isRunning())
    {
      bnds.d(this.a, bnds.c(this.a));
      if (bnds.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bnds.a(this.a, false);
      return;
      label105:
      if (bnds.c(this.a) == 4)
      {
        this.a.a(0);
      }
      else if (bnds.c(this.a) == 5)
      {
        this.a.a(1);
        bnds.a(this.a, 0);
      }
      else if (bnds.c(this.a) == 6)
      {
        this.a.a(2);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationStart: mState:" + bnds.c(this.a) + " isrun:" + bnds.a(this.a));
    }
    if (this.a.isRunning()) {
      bnds.c(this.a, bnds.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndx
 * JD-Core Version:    0.7.0.1
 */