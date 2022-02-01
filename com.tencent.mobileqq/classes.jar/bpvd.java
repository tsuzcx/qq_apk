import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class bpvd
  implements Animator.AnimatorListener
{
  bpvd(bpuy parambpuy) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationCancel: mState:" + bpuy.c(this.a) + " isrun:" + bpuy.a(this.a));
    }
    if (this.a.isRunning())
    {
      bpuy.e(this.a, bpuy.c(this.a));
      if (bpuy.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bpuy.a(this.a, false);
      return;
      label105:
      if (bpuy.c(this.a) == 4) {
        this.a.a(5);
      } else if (bpuy.c(this.a) == 5) {
        this.a.a(1);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationEnd: mState:" + bpuy.c(this.a) + " isrun:" + bpuy.a(this.a));
    }
    if (this.a.isRunning())
    {
      bpuy.d(this.a, bpuy.c(this.a));
      if (bpuy.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bpuy.a(this.a, false);
      return;
      label105:
      if (bpuy.c(this.a) == 4)
      {
        this.a.a(0);
      }
      else if (bpuy.c(this.a) == 5)
      {
        this.a.a(1);
        bpuy.a(this.a, 0);
      }
      else if (bpuy.c(this.a) == 6)
      {
        this.a.a(2);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationStart: mState:" + bpuy.c(this.a) + " isrun:" + bpuy.a(this.a));
    }
    if (this.a.isRunning()) {
      bpuy.c(this.a, bpuy.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpvd
 * JD-Core Version:    0.7.0.1
 */