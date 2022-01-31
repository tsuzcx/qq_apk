import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatView;

public class bcup
  implements Animator.AnimatorListener
{
  public bcup(QUSHalfScreenFloatView paramQUSHalfScreenFloatView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.jdField_a_of_type_Bklp != null) {
      this.a.jdField_a_of_type_Bklp.displayPanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.jdField_a_of_type_Bklp != null) {
      this.a.jdField_a_of_type_Bklp.displayPanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcup
 * JD-Core Version:    0.7.0.1
 */