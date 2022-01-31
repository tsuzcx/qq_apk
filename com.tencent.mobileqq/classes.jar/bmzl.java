import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class bmzl
  implements Animator.AnimatorListener
{
  bmzl(bmzg parambmzg) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationCancel: mState:" + bmzg.c(this.a) + " isrun:" + bmzg.a(this.a));
    }
    if (this.a.isRunning())
    {
      bmzg.e(this.a, bmzg.c(this.a));
      if (bmzg.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bmzg.a(this.a, false);
      return;
      label105:
      if (bmzg.c(this.a) == 4) {
        this.a.a(5);
      } else if (bmzg.c(this.a) == 5) {
        this.a.a(1);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationEnd: mState:" + bmzg.c(this.a) + " isrun:" + bmzg.a(this.a));
    }
    if (this.a.isRunning())
    {
      bmzg.d(this.a, bmzg.c(this.a));
      if (bmzg.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bmzg.a(this.a, false);
      return;
      label105:
      if (bmzg.c(this.a) == 4)
      {
        this.a.a(0);
      }
      else if (bmzg.c(this.a) == 5)
      {
        this.a.a(1);
        bmzg.a(this.a, 0);
      }
      else if (bmzg.c(this.a) == 6)
      {
        this.a.a(2);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationStart: mState:" + bmzg.c(this.a) + " isrun:" + bmzg.a(this.a));
    }
    if (this.a.isRunning()) {
      bmzg.c(this.a, bmzg.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzl
 * JD-Core Version:    0.7.0.1
 */