import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;

public class boyr
  extends AnimatorListenerAdapter
{
  public boyr(DoodleEditView paramDoodleEditView, bpdg parambpdg) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ykq.b("DoodleEditView", "onAnimationEnd");
    this.jdField_a_of_type_Bpdg.n = 1.0F;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ykq.b("DoodleEditView", "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boyr
 * JD-Core Version:    0.7.0.1
 */