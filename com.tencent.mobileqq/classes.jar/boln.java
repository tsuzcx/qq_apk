import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class boln
  implements Animator.AnimatorListener
{
  boln(boll paramboll) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEBottomListPart", 2, "Watermark Panel Opened!");
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boln
 * JD-Core Version:    0.7.0.1
 */