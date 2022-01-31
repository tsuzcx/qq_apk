import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bndd
  implements Animator.AnimatorListener
{
  bndd(bndb parambndb) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (bndb.b(this.a))
    {
      bndb.a(this.a, false);
      bndb.g(this.a, bndb.e(this.a));
      if (bndb.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bndb.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bndb.e(this.a) != 4);
    if ((bndb.a(this.a)) && (bndb.a(this.a) != null))
    {
      paramAnimator = (bndm)bndb.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bndb.a(this.a).a(bndb.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bndb.e(this.a), bndb.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bndb.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error 2 !! rc is null:" + bndb.f(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.isRunning())
    {
      bndb.a(this.a, false);
      bndb.f(this.a, bndb.e(this.a));
      if (bndb.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (bndb.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (bndb.e(this.a) != 4);
    if ((bndb.a(this.a)) && (bndb.a(this.a) != null))
    {
      paramAnimator = (bndm)bndb.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = bndb.a(this.a).a(bndb.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(bndb.e(this.a), bndb.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      bndb.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error!! rc is null:" + bndb.f(this.a));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.isRunning()) {
      bndb.e(this.a, bndb.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndd
 * JD-Core Version:    0.7.0.1
 */