import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatView;

public class bcve
  implements Animator.AnimatorListener
{
  public bcve(QUSHalfScreenFloatView paramQUSHalfScreenFloatView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.jdField_a_of_type_Bkmg != null) {
      this.a.jdField_a_of_type_Bkmg.displayPanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.jdField_a_of_type_Bkmg != null) {
      this.a.jdField_a_of_type_Bkmg.displayPanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcve
 * JD-Core Version:    0.7.0.1
 */