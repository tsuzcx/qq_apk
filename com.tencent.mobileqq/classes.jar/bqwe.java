import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bqwe
  implements Animator.AnimatorListener
{
  bqwe(bqwc parambqwc) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (bqwc.b(this.a))
    {
      bqwc.a(this.a, false);
      bqwc.g(this.a, bqwc.e(this.a));
      if (bqwc.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bqwc.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bqwc.e(this.a) != 4);
    if ((bqwc.a(this.a)) && (bqwc.a(this.a) != null))
    {
      paramAnimator = (bqwn)bqwc.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bqwc.a(this.a).a(bqwc.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bqwc.e(this.a), bqwc.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bqwc.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error 2 !! rc is null:" + bqwc.f(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.isRunning())
    {
      bqwc.a(this.a, false);
      bqwc.f(this.a, bqwc.e(this.a));
      if (bqwc.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bqwc.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bqwc.e(this.a) != 4);
    if ((bqwc.a(this.a)) && (bqwc.a(this.a) != null))
    {
      paramAnimator = (bqwn)bqwc.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bqwc.a(this.a).a(bqwc.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bqwc.e(this.a), bqwc.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bqwc.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error!! rc is null:" + bqwc.f(this.a));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.isRunning()) {
      bqwc.e(this.a, bqwc.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqwe
 * JD-Core Version:    0.7.0.1
 */