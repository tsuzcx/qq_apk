import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bpuj
  implements Animator.AnimatorListener
{
  bpuj(bpuh parambpuh) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (bpuh.b(this.a))
    {
      bpuh.a(this.a, false);
      bpuh.g(this.a, bpuh.e(this.a));
      if (bpuh.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bpuh.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bpuh.e(this.a) != 4);
    if ((bpuh.a(this.a)) && (bpuh.a(this.a) != null))
    {
      paramAnimator = (bpus)bpuh.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bpuh.a(this.a).a(bpuh.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bpuh.e(this.a), bpuh.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bpuh.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error 2 !! rc is null:" + bpuh.f(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.isRunning())
    {
      bpuh.a(this.a, false);
      bpuh.f(this.a, bpuh.e(this.a));
      if (bpuh.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bpuh.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bpuh.e(this.a) != 4);
    if ((bpuh.a(this.a)) && (bpuh.a(this.a) != null))
    {
      paramAnimator = (bpus)bpuh.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bpuh.a(this.a).a(bpuh.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bpuh.e(this.a), bpuh.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bpuh.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error!! rc is null:" + bpuh.f(this.a));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.isRunning()) {
      bpuh.e(this.a, bpuh.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpuj
 * JD-Core Version:    0.7.0.1
 */