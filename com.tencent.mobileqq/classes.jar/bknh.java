import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bknh
  implements Animator.AnimatorListener
{
  bknh(bknf parambknf) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (bknf.b(this.a))
    {
      bknf.a(this.a, false);
      bknf.g(this.a, bknf.e(this.a));
      if (bknf.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bknf.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bknf.e(this.a) != 4);
    if ((bknf.a(this.a)) && (bknf.a(this.a) != null))
    {
      paramAnimator = (bknq)bknf.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bknf.a(this.a).a(bknf.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bknf.e(this.a), bknf.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bknf.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error 2 !! rc is null:" + bknf.f(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.isRunning())
    {
      bknf.a(this.a, false);
      bknf.f(this.a, bknf.e(this.a));
      if (bknf.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bknf.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bknf.e(this.a) != 4);
    if ((bknf.a(this.a)) && (bknf.a(this.a) != null))
    {
      paramAnimator = (bknq)bknf.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bknf.a(this.a).a(bknf.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bknf.e(this.a), bknf.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bknf.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error!! rc is null:" + bknf.f(this.a));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.isRunning()) {
      bknf.e(this.a, bknf.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknh
 * JD-Core Version:    0.7.0.1
 */