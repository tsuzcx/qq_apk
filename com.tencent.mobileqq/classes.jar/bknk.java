import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class bknk
  implements Animator.AnimatorListener
{
  bknk(bknf parambknf) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationCancel: mState:" + bknf.c(this.a) + " isrun:" + bknf.a(this.a));
    }
    if (this.a.isRunning())
    {
      bknf.e(this.a, bknf.c(this.a));
      if (bknf.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bknf.a(this.a, false);
      return;
      label105:
      if (bknf.c(this.a) == 4) {
        this.a.a(5);
      } else if (bknf.c(this.a) == 5) {
        this.a.a(1);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationEnd: mState:" + bknf.c(this.a) + " isrun:" + bknf.a(this.a));
    }
    if (this.a.isRunning())
    {
      bknf.d(this.a, bknf.c(this.a));
      if (bknf.c(this.a) != 2) {
        break label105;
      }
      this.a.a(3);
    }
    for (;;)
    {
      bknf.a(this.a, false);
      return;
      label105:
      if (bknf.c(this.a) == 4)
      {
        this.a.a(0);
      }
      else if (bknf.c(this.a) == 5)
      {
        this.a.a(1);
        bknf.a(this.a, 0);
      }
      else if (bknf.c(this.a) == 6)
      {
        this.a.a(2);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarkDrawable", 2, "onAnimationStart: mState:" + bknf.c(this.a) + " isrun:" + bknf.a(this.a));
    }
    if (this.a.isRunning()) {
      bknf.c(this.a, bknf.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknk
 * JD-Core Version:    0.7.0.1
 */