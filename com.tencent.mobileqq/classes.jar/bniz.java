import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;

public class bniz
  extends AnimatorListenerAdapter
{
  public bniz(DoodleEditView paramDoodleEditView, bnno parambnno) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    xvv.b("DoodleEditView", "onAnimationEnd");
    this.jdField_a_of_type_Bnno.n = 1.0F;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    xvv.b("DoodleEditView", "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bniz
 * JD-Core Version:    0.7.0.1
 */