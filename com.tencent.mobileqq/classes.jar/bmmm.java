import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class bmmm
  extends AnimatorListenerAdapter
{
  bmmm(bmml parambmml, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    wxe.b("Q.qqstory.record.EditVideoFragment", "resetAnimator cancel!");
    this.jdField_a_of_type_AndroidViewView.setTag(new Boolean(false));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    wxe.c("Q.qqstory.record.EditVideoFragment", "resetAnimator end!");
    this.jdField_a_of_type_AndroidViewView.setTag(new Boolean(false));
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    wxe.c("Q.qqstory.record.EditVideoFragment", "resetAnimator start!");
    this.jdField_a_of_type_AndroidViewView.setTag(new Boolean(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmm
 * JD-Core Version:    0.7.0.1
 */