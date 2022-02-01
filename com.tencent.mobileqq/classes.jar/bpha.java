import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class bpha
  implements Animator.AnimatorListener
{
  bpha(bpgv parambpgv) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationCancel: mState:" + bpgv.c(this.a) + " isrun:" + bpgv.a(this.a));
    }
    if (this.a.isRunning())
    {
      bpgv.e(this.a, bpgv.c(this.a));
      if (bpgv.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bpgv.a(this.a, false);
      return;
      label105:
      if (bpgv.c(this.a) == 4) {
        this.a.a(5);
      } else if (bpgv.c(this.a) == 5) {
        this.a.a(1);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationEnd: mState:" + bpgv.c(this.a) + " isrun:" + bpgv.a(this.a));
    }
    if (this.a.isRunning())
    {
      bpgv.d(this.a, bpgv.c(this.a));
      if (bpgv.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bpgv.a(this.a, false);
      return;
      label105:
      if (bpgv.c(this.a) == 4)
      {
        this.a.a(0);
      }
      else if (bpgv.c(this.a) == 5)
      {
        this.a.a(1);
        bpgv.a(this.a, 0);
      }
      else if (bpgv.c(this.a) == 6)
      {
        this.a.a(2);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationStart: mState:" + bpgv.c(this.a) + " isrun:" + bpgv.a(this.a));
    }
    if (this.a.isRunning()) {
      bpgv.c(this.a, bpgv.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpha
 * JD-Core Version:    0.7.0.1
 */