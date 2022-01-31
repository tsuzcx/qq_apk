import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;

public class bkdq
  extends AnimatorListenerAdapter
{
  public bkdq(DoodleEditView paramDoodleEditView, bkin parambkin) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ved.b("DoodleEditView", "onAnimationEnd");
    this.jdField_a_of_type_Bkin.n = 1.0F;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ved.b("DoodleEditView", "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkdq
 * JD-Core Version:    0.7.0.1
 */