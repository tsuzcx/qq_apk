import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.anim.EnterExitAnimHelper.1.1;
import mqq.os.MqqHandler;

public class anxy
  implements Animator.AnimatorListener
{
  anxy(anxx paramanxx, aobg paramaobg, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Aobg != null) {
      this.jdField_a_of_type_Aobg.onColorNoteAnimFinish();
    }
    if ((this.jdField_a_of_type_Boolean) && ((paramAnimator instanceof xto))) {
      ThreadManager.getUIHandler().postDelayed(new EnterExitAnimHelper.1.1(this, paramAnimator), 200L);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxy
 * JD-Core Version:    0.7.0.1
 */