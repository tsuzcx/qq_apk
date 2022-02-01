import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;

public class bqmn
  extends AnimatorListenerAdapter
{
  public bqmn(DoodleEditView paramDoodleEditView, bqrk parambqrk) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    yuk.b("DoodleEditView", "onAnimationEnd");
    this.jdField_a_of_type_Bqrk.n = 1.0F;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    yuk.b("DoodleEditView", "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqmn
 * JD-Core Version:    0.7.0.1
 */