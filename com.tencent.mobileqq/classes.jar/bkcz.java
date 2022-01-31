import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;

public class bkcz
  extends AnimatorListenerAdapter
{
  public bkcz(DoodleEditView paramDoodleEditView, bkhw parambkhw) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    veg.b("DoodleEditView", "onAnimationEnd");
    this.jdField_a_of_type_Bkhw.n = 1.0F;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    veg.b("DoodleEditView", "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkcz
 * JD-Core Version:    0.7.0.1
 */