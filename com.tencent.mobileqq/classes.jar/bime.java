import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;

public class bime
  extends AnimatorListenerAdapter
{
  public bime(DoodleEditView paramDoodleEditView, birb parambirb) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    urk.b("DoodleEditView", "onAnimationEnd");
    this.jdField_a_of_type_Birb.n = 1.0F;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    urk.b("DoodleEditView", "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bime
 * JD-Core Version:    0.7.0.1
 */