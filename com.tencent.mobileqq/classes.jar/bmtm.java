import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;

public class bmtm
  extends AnimatorListenerAdapter
{
  public bmtm(DoodleEditView paramDoodleEditView, bmyj parambmyj) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    wxe.b("DoodleEditView", "onAnimationEnd");
    this.jdField_a_of_type_Bmyj.n = 1.0F;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    wxe.b("DoodleEditView", "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtm
 * JD-Core Version:    0.7.0.1
 */