import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;

class ansl
  implements Animator.AnimatorListener
{
  ansl(ansg paramansg, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_Ansg.l();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_Ansg.l();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Ansg.e) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansl
 * JD-Core Version:    0.7.0.1
 */