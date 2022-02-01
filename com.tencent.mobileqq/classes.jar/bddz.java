import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qphone.base.util.QLog;

class bddz
  implements Animator.AnimatorListener
{
  bddz(bddy parambddy) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (bddy.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IntegralClockView", 2, "integralLottieView play end");
      }
      bddy.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntegralClockView", 2, "integralLottieView play start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddz
 * JD-Core Version:    0.7.0.1
 */