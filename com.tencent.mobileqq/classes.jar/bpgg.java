import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bpgg
  implements Animator.AnimatorListener
{
  bpgg(bpge parambpge) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (bpge.b(this.a))
    {
      bpge.a(this.a, false);
      bpge.g(this.a, bpge.e(this.a));
      if (bpge.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bpge.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bpge.e(this.a) != 4);
    if ((bpge.a(this.a)) && (bpge.a(this.a) != null))
    {
      paramAnimator = (bpgp)bpge.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bpge.a(this.a).a(bpge.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bpge.e(this.a), bpge.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bpge.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error 2 !! rc is null:" + bpge.f(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.isRunning())
    {
      bpge.a(this.a, false);
      bpge.f(this.a, bpge.e(this.a));
      if (bpge.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bpge.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bpge.e(this.a) != 4);
    if ((bpge.a(this.a)) && (bpge.a(this.a) != null))
    {
      paramAnimator = (bpgp)bpge.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bpge.a(this.a).a(bpge.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bpge.e(this.a), bpge.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bpge.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error!! rc is null:" + bpge.f(this.a));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.isRunning()) {
      bpge.e(this.a, bpge.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgg
 * JD-Core Version:    0.7.0.1
 */