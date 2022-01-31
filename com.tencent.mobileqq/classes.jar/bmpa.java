import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;

public class bmpa
  extends AnimatorListenerAdapter
{
  public bmpa(DoodleEditView paramDoodleEditView, bmtx parambmtx) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    wsv.b("DoodleEditView", "onAnimationEnd");
    this.jdField_a_of_type_Bmtx.n = 1.0F;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    wsv.b("DoodleEditView", "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpa
 * JD-Core Version:    0.7.0.1
 */