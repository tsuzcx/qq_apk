import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.anim.EnterExitAnimHelper.1.1;
import mqq.os.MqqHandler;

public class aqoc
  implements Animator.AnimatorListener
{
  aqoc(aqob paramaqob, aqrq paramaqrq, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Aqrq != null) {
      this.jdField_a_of_type_Aqrq.onColorNoteAnimFinish();
    }
    if ((this.jdField_a_of_type_Boolean) && ((paramAnimator instanceof zjh))) {
      ThreadManager.getUIHandler().postDelayed(new EnterExitAnimHelper.1.1(this, paramAnimator), 200L);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqoc
 * JD-Core Version:    0.7.0.1
 */