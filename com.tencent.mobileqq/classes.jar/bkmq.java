import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bkmq
  implements Animator.AnimatorListener
{
  bkmq(bkmo parambkmo) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (bkmo.b(this.a))
    {
      bkmo.a(this.a, false);
      bkmo.g(this.a, bkmo.e(this.a));
      if (bkmo.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bkmo.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bkmo.e(this.a) != 4);
    if ((bkmo.a(this.a)) && (bkmo.a(this.a) != null))
    {
      paramAnimator = (bkmz)bkmo.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bkmo.a(this.a).a(bkmo.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bkmo.e(this.a), bkmo.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bkmo.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error 2 !! rc is null:" + bkmo.f(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.isRunning())
    {
      bkmo.a(this.a, false);
      bkmo.f(this.a, bkmo.e(this.a));
      if (bkmo.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bkmo.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bkmo.e(this.a) != 4);
    if ((bkmo.a(this.a)) && (bkmo.a(this.a) != null))
    {
      paramAnimator = (bkmz)bkmo.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bkmo.a(this.a).a(bkmo.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bkmo.e(this.a), bkmo.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bkmo.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error!! rc is null:" + bkmo.f(this.a));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.isRunning()) {
      bkmo.e(this.a, bkmo.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkmq
 * JD-Core Version:    0.7.0.1
 */