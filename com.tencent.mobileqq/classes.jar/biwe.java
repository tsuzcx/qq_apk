import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class biwe
  implements Animator.AnimatorListener
{
  biwe(biwc parambiwc) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (biwc.b(this.a))
    {
      biwc.a(this.a, false);
      biwc.g(this.a, biwc.e(this.a));
      if (biwc.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (biwc.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (biwc.e(this.a) != 4);
    if ((biwc.a(this.a)) && (biwc.a(this.a) != null))
    {
      paramAnimator = (biwn)biwc.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = biwc.a(this.a).a(biwc.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(biwc.e(this.a), biwc.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      biwc.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error 2 !! rc is null:" + biwc.f(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.isRunning())
    {
      biwc.a(this.a, false);
      biwc.f(this.a, biwc.e(this.a));
      if (biwc.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (biwc.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (biwc.e(this.a) != 4);
    if ((biwc.a(this.a)) && (biwc.a(this.a) != null))
    {
      paramAnimator = (biwn)biwc.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = biwc.a(this.a).a(biwc.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(biwc.e(this.a), biwc.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      biwc.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error!! rc is null:" + biwc.f(this.a));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.isRunning()) {
      biwc.e(this.a, biwc.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwe
 * JD-Core Version:    0.7.0.1
 */