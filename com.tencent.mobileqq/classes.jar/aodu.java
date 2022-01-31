import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.RectF;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.GroundDrawable;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerFore;
import java.lang.ref.WeakReference;

public class aodu
  implements Animator.AnimatorListener
{
  public aodu(GroundDrawable paramGroundDrawable) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (GroundDrawable.b(this.a))
    {
      GroundDrawable.a(this.a, false);
      GroundDrawable.g(this.a, GroundDrawable.e(this.a));
      if (GroundDrawable.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (GroundDrawable.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (GroundDrawable.e(this.a) != 4);
    if ((GroundDrawable.a(this.a)) && (GroundDrawable.a(this.a) != null))
    {
      paramAnimator = (aoed)GroundDrawable.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = GroundDrawable.a(this.a).a(GroundDrawable.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(GroundDrawable.e(this.a), GroundDrawable.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      GroundDrawable.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error 2 !! rc is null:" + GroundDrawable.f(this.a));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.isRunning())
    {
      GroundDrawable.a(this.a, false);
      GroundDrawable.f(this.a, GroundDrawable.e(this.a));
      if (GroundDrawable.e(this.a) != 1) {
        break label53;
      }
      this.a.a(2);
    }
    label53:
    do
    {
      return;
      if (GroundDrawable.e(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
    } while (GroundDrawable.e(this.a) != 4);
    if ((GroundDrawable.a(this.a)) && (GroundDrawable.a(this.a) != null))
    {
      paramAnimator = (aoed)GroundDrawable.a(this.a).get();
      if (paramAnimator != null)
      {
        RectF localRectF = GroundDrawable.a(this.a).a(GroundDrawable.f(this.a));
        if (localRectF == null) {
          break label183;
        }
        paramAnimator.a(GroundDrawable.e(this.a), GroundDrawable.f(this.a), localRectF);
      }
    }
    for (;;)
    {
      GroundDrawable.b(this.a, false);
      this.a.a(0);
      return;
      label183:
      QLog.d("GroundDrawable", 2, "onGroundMarkSelected error!! rc is null:" + GroundDrawable.f(this.a));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.isRunning()) {
      GroundDrawable.e(this.a, GroundDrawable.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aodu
 * JD-Core Version:    0.7.0.1
 */