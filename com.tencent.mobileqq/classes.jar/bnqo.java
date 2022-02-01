import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bnqo
  implements Animator.AnimatorListener
{
  bnqo(bnqm parambnqm) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (bnqm.b(this.a))
    {
      bnqm.a(this.a, false);
      bnqm.g(this.a, bnqm.e(this.a));
      if (bnqm.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bnqm.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bnqm.e(this.a) != 4);
    if ((bnqm.a(this.a)) && (bnqm.a(this.a) != null))
    {
      paramAnimator = (bnqx)bnqm.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bnqm.a(this.a).a(bnqm.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bnqm.e(this.a), bnqm.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bnqm.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error 2 !! rc is null:" + bnqm.f(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.isRunning())
    {
      bnqm.a(this.a, false);
      bnqm.f(this.a, bnqm.e(this.a));
      if (bnqm.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bnqm.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bnqm.e(this.a) != 4);
    if ((bnqm.a(this.a)) && (bnqm.a(this.a) != null))
    {
      paramAnimator = (bnqx)bnqm.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bnqm.a(this.a).a(bnqm.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bnqm.e(this.a), bnqm.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bnqm.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error!! rc is null:" + bnqm.f(this.a));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.isRunning()) {
      bnqm.e(this.a, bnqm.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqo
 * JD-Core Version:    0.7.0.1
 */