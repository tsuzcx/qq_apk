import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bmyr
  implements Animator.AnimatorListener
{
  bmyr(bmyp parambmyp) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (bmyp.b(this.a))
    {
      bmyp.a(this.a, false);
      bmyp.g(this.a, bmyp.e(this.a));
      if (bmyp.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bmyp.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bmyp.e(this.a) != 4);
    if ((bmyp.a(this.a)) && (bmyp.a(this.a) != null))
    {
      paramAnimator = (bmza)bmyp.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bmyp.a(this.a).a(bmyp.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bmyp.e(this.a), bmyp.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bmyp.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error 2 !! rc is null:" + bmyp.f(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.isRunning())
    {
      bmyp.a(this.a, false);
      bmyp.f(this.a, bmyp.e(this.a));
      if (bmyp.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bmyp.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bmyp.e(this.a) != 4);
    if ((bmyp.a(this.a)) && (bmyp.a(this.a) != null))
    {
      paramAnimator = (bmza)bmyp.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bmyp.a(this.a).a(bmyp.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bmyp.e(this.a), bmyp.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bmyp.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error!! rc is null:" + bmyp.f(this.a));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.isRunning()) {
      bmyp.e(this.a, bmyp.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyr
 * JD-Core Version:    0.7.0.1
 */