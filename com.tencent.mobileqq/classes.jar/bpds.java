import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class bpds
  extends AnimatorListenerAdapter
{
  bpds(bpdr parambpdr, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    yqp.b("Q.qqstory.record.EditVideoFragment", "resetAnimator cancel!");
    this.jdField_a_of_type_AndroidViewView.setTag(new Boolean(false));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    yqp.c("Q.qqstory.record.EditVideoFragment", "resetAnimator end!");
    this.jdField_a_of_type_AndroidViewView.setTag(new Boolean(false));
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    yqp.c("Q.qqstory.record.EditVideoFragment", "resetAnimator start!");
    this.jdField_a_of_type_AndroidViewView.setTag(new Boolean(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpds
 * JD-Core Version:    0.7.0.1
 */