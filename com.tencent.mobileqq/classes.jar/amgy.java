import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.anim.EnterExitAnimHelper.1.1;
import mqq.os.MqqHandler;

public class amgy
  implements Animator.AnimatorListener
{
  amgy(amgx paramamgx, amkj paramamkj, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Amkj != null) {
      this.jdField_a_of_type_Amkj.onColorNoteAnimFinish();
    }
    if ((this.jdField_a_of_type_Boolean) && ((paramAnimator instanceof wez))) {
      ThreadManager.getUIHandler().postDelayed(new EnterExitAnimHelper.1.1(this, paramAnimator), 200L);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amgy
 * JD-Core Version:    0.7.0.1
 */