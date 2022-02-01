import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;

public class bpks
  extends AnimatorListenerAdapter
{
  public bpks(DoodleEditView paramDoodleEditView, bppp parambppp) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    yqp.b("DoodleEditView", "onAnimationEnd");
    this.jdField_a_of_type_Bppp.n = 1.0F;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    yqp.b("DoodleEditView", "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpks
 * JD-Core Version:    0.7.0.1
 */