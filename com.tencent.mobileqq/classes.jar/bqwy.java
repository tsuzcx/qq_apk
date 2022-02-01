import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class bqwy
  implements Animator.AnimatorListener
{
  bqwy(bqwt parambqwt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationCancel: mState:" + bqwt.c(this.a) + " isrun:" + bqwt.a(this.a));
    }
    if (this.a.isRunning())
    {
      bqwt.e(this.a, bqwt.c(this.a));
      if (bqwt.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bqwt.a(this.a, false);
      return;
      label105:
      if (bqwt.c(this.a) == 4) {
        this.a.a(5);
      } else if (bqwt.c(this.a) == 5) {
        this.a.a(1);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationEnd: mState:" + bqwt.c(this.a) + " isrun:" + bqwt.a(this.a));
    }
    if (this.a.isRunning())
    {
      bqwt.d(this.a, bqwt.c(this.a));
      if (bqwt.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bqwt.a(this.a, false);
      return;
      label105:
      if (bqwt.c(this.a) == 4)
      {
        this.a.a(0);
      }
      else if (bqwt.c(this.a) == 5)
      {
        this.a.a(1);
        bqwt.a(this.a, 0);
      }
      else if (bqwt.c(this.a) == 6)
      {
        this.a.a(2);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationStart: mState:" + bqwt.c(this.a) + " isrun:" + bqwt.a(this.a));
    }
    if (this.a.isRunning()) {
      bqwt.c(this.a, bqwt.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqwy
 * JD-Core Version:    0.7.0.1
 */